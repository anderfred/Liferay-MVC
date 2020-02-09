/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.anderfred.service.impl;

import com.anderfred.model.Vacancy;
import com.anderfred.service.base.VacancyLocalServiceBaseImpl;
import com.anderfred.service.util.JobHHApiGet;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The implementation of the vacancy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.anderfred.service.VacancyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VacancyLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.anderfred.model.Vacancy",
        service = AopService.class
)
public class VacancyLocalServiceImpl extends VacancyLocalServiceBaseImpl {
    private JobHHApiGet jobHHApiGet = new JobHHApiGet();
    private static final Log _log = LogFactoryUtil.getLog(
            VacancyLocalServiceImpl.class);

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.anderfred.service.VacancyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.anderfred.service.VacancyLocalServiceUtil</code>.
     */
    public void createOrUpdateVacancy(List<Vacancy> list) throws PortalException {
        int added = 0, updated = 0;
        if (list.size() > 0) {
            _log.info("createOrUpdateVacancy List size:"+list.size());
        for (Vacancy v : list) {

                Optional<Vacancy> optional = Optional.ofNullable(fetchVacancy(v.getId()));
                if (optional.isPresent()) {
                    _log.info("update vacancy id:" + optional.get().getId());
                    updated++;
                    updateVacancy(optional.get());
                } else {
                    _log.info("add new vacancy id:" + v.getId());
                    added++;
                    addVacancy(v);
                }
            }
        }
        _log.info("added:" + added + " updated:" + updated);
    }

    public List<Vacancy> makeExampleRequest() {
        List<Vacancy> list = jobHHApiGet.exampleGetRequest();
        _log.info("exampleRequest vacancies count:" + list.size());
        try {
            createOrUpdateVacancy(list);
            _log.info("Vacancies added to db successfully");
        } catch (PortalException e) {
            _log.error("Error adding vacancies to db", e);
            e.printStackTrace();
        }
        return list;
    }

    public Map<Integer, String> getAreas() {
        Map<Integer, String> map = jobHHApiGet.getAreasRequest();
        _log.info("get " + map.size() + " areas");
        return map;
    }

    public Map<Integer, String> getSpecs() {
        Map<Integer, String> map = jobHHApiGet.getSpecRequest();
        _log.info("get " + map.size() + " specs");
        return map;
    }

    public List<Vacancy> getParametrizedRequest(int area, int spec) {
        List<Vacancy> list = new ArrayList<>();
        try {
            jobHHApiGet.parseVacancy(jobHHApiGet.getRequest(), area, spec);
            _log.info("make parse vacancy request, with area:" + area + " spec:" + spec);
        } catch (JSONException e) {
            _log.error("parse vacancy error:" + e.getLocalizedMessage(), e);
            e.printStackTrace();
        } catch (IOException e) {
            _log.error("parse vacancy error:" + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        _log.info("getParametrizedRequest return " + list.size() + " vacancies");
        return list;
    }

}
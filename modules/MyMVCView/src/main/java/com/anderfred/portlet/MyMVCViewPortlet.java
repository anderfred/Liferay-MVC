package com.anderfred.portlet;

import com.anderfred.constants.MyMVCViewPortletKeys;
import com.anderfred.model.Vacancy;
import com.anderfred.service.VacancyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author fredx
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=MyMVCView",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + MyMVCViewPortletKeys.MYMVCVIEW,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MyMVCViewPortlet extends MVCPortlet {
    @Reference
    private VacancyLocalService vacancyLocalService;


    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        renderRequest.setAttribute("areas", vacancyLocalService.getAreas());
        _log.info("Areas added to renderAttribute");
        renderRequest.setAttribute("specs", vacancyLocalService.getSpecs());
        _log.info("Specs added to renderAttribute");
        renderRequest.setAttribute("vacancyList", vacancyLocalService.makeExampleRequest());
        super.render(renderRequest, renderResponse);
    }


    private static final Log _log = LogFactoryUtil.getLog(
            MyMVCViewPortlet.class);

    @ProcessAction(name = "showAreaAndSpec")
    public void showAreaAndSpec(ActionRequest request, ActionResponse response) {
        String specId = ParamUtil.getString(request, "specSelect");
        String areaId = ParamUtil.getString(request, "areaSelect");

        _log.info("spec: id=" + specId + " name=" + vacancyLocalService.getSpecs().get(Integer.parseInt(specId)));
        _log.info("area: id=" + areaId + " name=" + vacancyLocalService.getAreas().get(Integer.parseInt(areaId)));
        List<Vacancy> list = vacancyLocalService.getParametrizedRequest(Integer.parseInt(areaId), Integer.parseInt(specId));
        try {
            vacancyLocalService.createOrUpdateVacancy(list);
        } catch (PortalException e) {
            e.printStackTrace();
        }

        request.setAttribute("paramList", list);

    }

    @ProcessAction(name = "showStandardData")
    public void showStandardData(ActionRequest request, ActionResponse response) {
        List<Vacancy> list = vacancyLocalService.getParametrizedRequest(1, 4);
        try {
            vacancyLocalService.createOrUpdateVacancy(list);
        } catch (PortalException e) {
            e.printStackTrace();
        }

        request.setAttribute("vacancyList", list);

    }

}
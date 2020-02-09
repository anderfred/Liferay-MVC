package com.anderfred.portlet;

import com.anderfred.constants.MyMVCViewPortletKeys;
import com.anderfred.service.VacancyLocalService;
import com.anderfred.util.JobHHApiGet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.Map;

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

    private Map<Integer, String> areas;
    private Map<Integer, String> specs;
    JobHHApiGet jobHHApiGet;

    {
        jobHHApiGet = new JobHHApiGet(getVacancyLocalService());
        areas = jobHHApiGet.getAreas();
        specs = jobHHApiGet.getSpecs();
    }

    @Reference
    VacancyLocalService vacancyLocalService;

    private VacancyLocalService getVacancyLocalService() {
        return vacancyLocalService;
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        renderRequest.setAttribute("areas", areas);
        _log.info("Areas added to renderAttribute");
        renderRequest.setAttribute("specs", specs);
        _log.info("Specs added to renderAttribute");
        super.render(renderRequest, renderResponse);
    }


    private static final Log _log = LogFactoryUtil.getLog(
            MyMVCViewPortlet.class);

    @ProcessAction(name = "showAreaAndSpec")
    public void greet(ActionRequest request, ActionResponse response) {
        String specId = ParamUtil.getString(request, "specSelect");
        String areaId = ParamUtil.getString(request, "areaSelect");

        _log.info("spec: id="+specId+" name="+specs.get(Integer.parseInt(specId)));
        _log.info("area: id="+areaId+" name="+areas.get(Integer.parseInt(areaId)));

    }
}
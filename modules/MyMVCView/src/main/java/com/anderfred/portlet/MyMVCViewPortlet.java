package com.anderfred.portlet;

import com.anderfred.constants.MyMVCViewPortletKeys;

import com.anderfred.service.VacancyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

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
    VacancyLocalService vacancyLocalService;

    private VacancyLocalService getVacancyLocalService() {
        return vacancyLocalService;
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        System.out.println("works");

        System.out.println("i think");
        renderRequest.setAttribute("guestbookId", 43);
        super.render(renderRequest, renderResponse);
    }

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {
        renderRequest.setAttribute("name", "nilang");
        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "addName")
    public void addName(ActionRequest actionRequest,
                        ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
        actionRequest.setAttribute("userName", "Nilang");
    }

}
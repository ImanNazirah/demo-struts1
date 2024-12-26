package com.demo.struts1.action;


import com.demo.struts1.form.DashboardForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashboardAction extends BaseAction {

    @Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DashboardForm dashboardForm = (DashboardForm) form;
        dashboardForm.setTitle("Overview");
        return mapping.findForward("success");
    }

}
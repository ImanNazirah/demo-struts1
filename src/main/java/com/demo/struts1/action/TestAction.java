package com.demo.struts1.action;

import com.demo.struts1.form.TestForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        TestForm testForm = (TestForm) form;
        testForm.setGreeting("Test using Struts!");

        return mapping.findForward("success");
    }

}
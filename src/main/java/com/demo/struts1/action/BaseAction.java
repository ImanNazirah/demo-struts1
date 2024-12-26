package com.demo.struts1.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseAction extends Action {

    protected abstract ActionForward performAction(ActionMapping mapping, ActionForm form,
                                                   HttpServletRequest request, HttpServletResponse response)
            throws Exception;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            // Redirect to login page if not authenticated
            return mapping.findForward("login");
        }

        return performAction(mapping, form, request, response);
    }
}

package com.demo.struts1.action.User;

import com.demo.struts1.action.BaseAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends BaseAction {
    @Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return mapping.findForward("login");
    }
}

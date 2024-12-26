package com.demo.struts1.action.User;

import com.demo.struts1.action.Spotify.SpotifyCreateAction;
import com.demo.struts1.dao.UserDao;
import com.demo.struts1.form.LoginForm;
import com.demo.struts1.model.User;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {

    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        UserDao userDao = new UserDao();
        User userData = userDao.findByUsername(username);
        logger.info("userData  :: {}",userData);

        if(userData == null){
            return mapping.findForward("failure");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean passwordMatch = encoder.matches(password, userData.getPassword());
        logger.info("Checking passwordMatch  :: {}",passwordMatch);

        if(!passwordMatch){
            return mapping.findForward("failure");

        }

        request.getSession().setAttribute("loggedInUser", username);
        return mapping.findForward("success");


    }
}

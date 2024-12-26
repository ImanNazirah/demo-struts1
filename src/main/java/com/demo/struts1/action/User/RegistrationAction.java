//package com.demo.struts1.action.User;
//
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//public class RegistrationAction extends Action {
//
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @Override
//    public ActionForward execute(ActionMapping mapping, ActionForm form,
//                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        String username = request.getParameter("username");
//        String rawPassword = request.getParameter("password");
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//
//        // Step 3: Insert the user data into the database
//        insertUserIntoDatabase(username, encodedPassword);
//
//        // Step 4: Return the appropriate ActionForward (success page)
//        return mapping.findForward("success");
//
//    }
//
//
//}

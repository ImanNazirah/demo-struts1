package com.demo.struts1.action.Spotify;

import com.demo.struts1.action.BaseAction;
import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.form.SpotifyForm;
import org.apache.struts.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyUpdateAction extends BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyUpdateAction.class);

    @Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        SpotifyForm spotifyForm = (SpotifyForm) form;

        ActionErrors errors = spotifyForm.validate(mapping, request);
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            return mapping.findForward("failure");
        }

        SpotifyDao spotifyDao = new SpotifyDao();

        boolean isUpdated = spotifyDao.updateSpotify(spotifyForm);

        if (isUpdated) {

            request.setAttribute("message", "Data update successfully!");
            logger.info("Successfully updated");
            return mapping.findForward("success");

        } else {
            logger.error("Update failed");
            request.setAttribute("message", "Data update failed.");
            return mapping.findForward("failure");
        }
    }

}

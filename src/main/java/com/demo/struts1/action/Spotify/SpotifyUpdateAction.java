package com.demo.struts1.action.Spotify;

import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.form.SpotifyForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyUpdateAction extends Action {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyUpdateAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        SpotifyForm spotifyForm = (SpotifyForm) form;
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

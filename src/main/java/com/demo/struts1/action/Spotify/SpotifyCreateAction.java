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

public class SpotifyCreateAction extends Action {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyCreateAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        SpotifyForm spotifyForm = (SpotifyForm) form;
        SpotifyDao spotifyDao = new SpotifyDao();
        boolean isCreated = spotifyDao.createSpotify(spotifyForm.getTrackName(), spotifyForm.getArtistName(), spotifyForm.getGenre(), spotifyForm.getPopularity());

        if (isCreated) {

            request.setAttribute("message", "Data created successfully!");
            logger.info("Successfully created");
            return mapping.findForward("success");

        } else {
            logger.error("Creation failed");
            request.setAttribute("message", "Data creation failed.");
            return mapping.findForward("failure");
        }
    }
}

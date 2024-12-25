package com.demo.struts1.action.Spotify;


import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.form.SpotifyForm;
import com.demo.struts1.model.Spotify;
import org.apache.struts.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyCreateAction extends Action {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyCreateAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        logger.info("Request form :: {}",form);

        SpotifyForm spotifyForm = (SpotifyForm) form;

        ActionErrors errors = spotifyForm.validate(mapping, request);
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            return mapping.findForward("failure");
        }

        SpotifyDao spotifyDao = new SpotifyDao();

        Spotify data = new Spotify();
        data.setArtistName(spotifyForm.getArtistName());
        data.setGenre(spotifyForm.getGenre());
        data.setPopularity(spotifyForm.getPopularity());
        data.setTrackName(spotifyForm.getTrackName());

        boolean isCreated = spotifyDao.createSpotify(data);

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

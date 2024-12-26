package com.demo.struts1.action.Spotify;

import com.demo.struts1.action.BaseAction;
import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.form.SpotifyForm;
import com.demo.struts1.model.Spotify;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyInitAction extends BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyInitAction.class);

    @Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        SpotifyDao spotifyDao = new SpotifyDao();

        logger.info("Request query parameter action :: {}",request.getParameter("action"));
        String actionType = request.getParameter("action");

        SpotifyForm spotifyForm = (SpotifyForm) form;
        spotifyForm.setActionType(actionType);


        if((actionType.equals("edit") || actionType.equals("delete")) && request.getParameter("id") != null){
            Spotify data = spotifyDao.getById(Long.parseLong(request.getParameter("id")));
            spotifyForm.setArtistName(data.getArtistName());
            spotifyForm.setTrackName(data.getTrackName());
            spotifyForm.setGenre(data.getGenre());
            spotifyForm.setPopularity(data.getPopularity());
            logger.info("Get Existing data :: {}",data);

        }

        return mapping.findForward("success");
    }

}

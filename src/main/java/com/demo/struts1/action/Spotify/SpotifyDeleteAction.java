package com.demo.struts1.action.Spotify;

import com.demo.struts1.action.BaseAction;
import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.form.SpotifyForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpotifyDeleteAction extends BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyDeleteAction.class);

    @Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        SpotifyForm spotifyForm = (SpotifyForm) form;
        SpotifyDao spotifyDao = new SpotifyDao();

        boolean isDeleted = spotifyDao.deleteSpotify(spotifyForm.getId());

        if (isDeleted) {

            request.setAttribute("message", "Data delete successfully!");
            logger.info("Successfully deleted");
            return mapping.findForward("success");

        } else {
            logger.error("Delete failed");
            request.setAttribute("message", "Data delete failed.");
            return mapping.findForward("failure");
        }

    }

}

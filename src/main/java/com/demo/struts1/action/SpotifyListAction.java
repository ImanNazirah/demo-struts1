package com.demo.struts1.action;

import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.model.Spotify;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class SpotifyListAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        SpotifyDao spotifyDao = new SpotifyDao();
        List<Spotify> results = spotifyDao.getAll();

        String dynamicTitle = "Spotify List";
        request.setAttribute("pageTitle", dynamicTitle);
        request.setAttribute("results", results);
        return mapping.findForward("success");
    }
}

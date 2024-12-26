package com.demo.struts1.action.Spotify;

import com.demo.struts1.action.BaseAction;
import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.model.Spotify;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SpotifyListPaginationAction extends BaseAction {

    private static final int PAGE_SIZE = 10;

    @Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        SpotifyDao spotifyDao = new SpotifyDao();
        String pageParam = request.getParameter("page");
        int currentPage = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
        int start = (currentPage - 1) * PAGE_SIZE;

        List<Spotify> data = spotifyDao.findByPaginated(start, PAGE_SIZE);
        long totalRecords = spotifyDao.getTotalRecords();
        int totalPages = (int) Math.ceil((double) totalRecords / PAGE_SIZE);

        request.setAttribute("data", data);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        return mapping.findForward("success");
    }

}

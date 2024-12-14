package com.demo.struts1.Action;

import com.demo.struts1.action.Spotify.SpotifyListPaginationAction;
import com.demo.struts1.dao.SpotifyDao;
import com.demo.struts1.model.Spotify;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpotifyListPaginationTest {

    private static final Logger log = Logger.getLogger(SpotifyListPaginationTest.class);
    private static final int PAGE_SIZE = 10;

    @Test
    void testExecute() throws Exception {
        SpotifyListPaginationAction action = new SpotifyListPaginationAction();

        ActionMapping mapping = mock(ActionMapping.class);
        ActionForm form = mock(ActionForm.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("page")).thenReturn("1");
        // Mock ActionMapping to return the correct forward
        when(mapping.findForward("success")).thenReturn(new ActionForward("success"));

        SpotifyDao spotifyDao = mock(SpotifyDao.class);
        when(spotifyDao.getAll()).thenReturn(new ArrayList<Spotify>());

        // Execute the action
        ActionForward result = action.execute(mapping, form, request, response);

        log.info("Checking result: "+ result);
        // Assert the result
        assertNotNull(result);
        assertEquals("success", result.getPath());
    }
}

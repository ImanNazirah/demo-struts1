package com.demo.struts1.action;

import com.demo.struts1.model.Spotify;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class SpotifyListAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {


        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        Session session = cfg.buildSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        // HQL query to select all records
        Query<Spotify> query = session.createQuery("FROM Spotify", Spotify.class);
        List<Spotify> results = query.list();
        tx.commit();
        session.close();

        request.setAttribute("results", results);
        return mapping.findForward("success");
    }
}

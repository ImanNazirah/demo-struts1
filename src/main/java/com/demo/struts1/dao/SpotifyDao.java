package com.demo.struts1.dao;

import com.demo.struts1.model.Spotify;
import com.demo.struts1.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotifyDao {

    private static final Logger logger = LoggerFactory.getLogger(SpotifyDao.class);

    public SpotifyDao() {
    }

    public List<Spotify> getAll() {

        Session session = HibernateUtil.getSession();
        List<Spotify> data = null;

        try {

            session.beginTransaction();
            Query<Spotify> query = session.createQuery("FROM Spotify", Spotify.class);
            data = query.list();

        } catch (Exception e) {
            logger.error("Error",e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return data;
    }

    public List<Spotify> findByPaginated(int start, int maxResults) {
        Session session = HibernateUtil.getSession();
        List<Spotify> data = null;

        try {

            session.beginTransaction();
            Criteria query = session.createCriteria(Spotify.class);
            query.setFirstResult(start);
            query.setMaxResults(maxResults);

            data = query.list();
            logger.info("Checking : {}",data);

        } catch (Exception e) {
            logger.error("Error",e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return data;

    }

    public Long getTotalRecords() {

        Session session = HibernateUtil.getSession();
        Long total = null;

        try {

            session.beginTransaction();
            Criteria query = session.createCriteria(Spotify.class);
            query.setProjection(Projections.rowCount());

            total = (Long) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Error",e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return total;

    }

}


package com.demo.struts1.dao;

import com.demo.struts1.form.SpotifyForm;
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
            logger.error("Error", e);
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
            logger.info("Checking : {}", data);

        } catch (Exception e) {
            logger.error("Error", e);
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
            logger.error("Error", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return total;

    }

    public boolean createSpotify(Spotify spotifyData) {
        Session session = HibernateUtil.getSession();
        boolean isSuccess = false;

        try {

            session.beginTransaction();
            session.save(spotifyData);
            session.getTransaction().commit();

            isSuccess = true;


        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            logger.error("Error creating data", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return isSuccess;
    }

    public boolean updateSpotify(SpotifyForm spotify) {
        Session session = HibernateUtil.getSession();
        boolean isSuccess = false;

        try {
            // Start a transaction
            session.beginTransaction();

            Spotify existingData = session.get(Spotify.class, spotify.getId());

            if (existingData != null) {

                existingData.setTrackName(spotify.getTrackName());
                existingData.setArtistName(spotify.getArtistName());
                existingData.setPopularity(spotify.getPopularity());
                existingData.setGenre(spotify.getGenre());

                session.update(existingData);
                session.getTransaction().commit();

                isSuccess = true;
            } else {
                logger.error("Spotify with id " + spotify.getId() + " not found.");
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            logger.error("Error updating data", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return isSuccess;
    }

    public boolean deleteSpotify(Long id) {
        Session session = HibernateUtil.getSession();
        boolean isSuccess = false;
        Spotify data = null;

        try {

            session.beginTransaction();
            data = session.get(Spotify.class, id);

            if (data != null) {
                session.delete(data);
                session.getTransaction().commit();
                isSuccess = true;
            } else {
                logger.warn("Spotify with id " + id + " not found.");
            }

        } catch (Exception e) {

            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            logger.error("Error deleting Spotify", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return isSuccess;
    }

    public Spotify getById(Long id) {
        Session session = HibernateUtil.getSession();
        Spotify data = null;
        try {
            // Begin a transaction
            session.beginTransaction();

            data = session.get(Spotify.class, id);

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }

            logger.error("Error get by Id", e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return data;
    }


}


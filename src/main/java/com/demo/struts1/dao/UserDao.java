package com.demo.struts1.dao;

import com.demo.struts1.model.User;
import com.demo.struts1.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public UserDao() {
    }

    public User findByUsername(String username){
        Session session = HibernateUtil.getSession();
        User data = null;

        try {

            session.beginTransaction();
            Criteria query = session.createCriteria(User.class);
            query.add(Restrictions.eq("username", username));
            query.add(Restrictions.eq("isEnable", true));
            data = (User) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Error", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return data;
    }

}

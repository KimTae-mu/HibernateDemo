package com.tae.dao;

import com.tae.domain.User;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Taeyeon-Serenity on 2017/7/30.
 */
public class UserDao {
    public void save1(User u1) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(u1);
    }
    public void save2(User u2) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(u2);
    }
}

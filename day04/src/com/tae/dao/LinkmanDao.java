package com.tae.dao;

import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import sun.awt.image.ImageWatched;

import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/7/31.
 */
public class LinkmanDao {
    public void save(Linkman man) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(man);
    }

    public List<Linkman> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        return session.createQuery("from Linkman").list();
    }

    public List<Linkman> findAll(DetachedCriteria criteria) {
        Session session = HibernateUtils.getCurrentSession();
        //执行
        return criteria.getExecutableCriteria(session).list();
    }
}

package com.tae.dao;

import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by Taeyeon-Serenity on 2017/7/31.
 */
public class LinkmanDao {
    public void save(Linkman man) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(man);
    }
}

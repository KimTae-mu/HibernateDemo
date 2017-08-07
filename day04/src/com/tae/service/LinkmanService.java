package com.tae.service;

import com.tae.dao.CustomerDao;
import com.tae.dao.LinkmanDao;
import com.tae.domain.Customer;
import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/7/31.
 */
public class LinkmanService {

    public void save(Linkman man, long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        try {
            //先查客户
            Customer c=new CustomerDao().findById(cust_id);
            //设置
            man.setCustomer(c);
            new LinkmanDao().save(man);

            tr.commit();
        }catch (Exception e){
            tr.rollback();
            e.printStackTrace();
        }
    }

    public List<Linkman> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Linkman> mans=null;

        try {
            mans=new LinkmanDao().findAll();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mans;
    }

    public List<Linkman> findAll(DetachedCriteria criteria) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Linkman> mans=null;

        try {
            mans=new LinkmanDao().findAll(criteria);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mans;
    }
}

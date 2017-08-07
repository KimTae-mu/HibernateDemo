package com.tae.service;

import com.tae.dao.CustomerDao;
import com.tae.dao.LinkmanDao;
import com.tae.domain.Customer;
import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}

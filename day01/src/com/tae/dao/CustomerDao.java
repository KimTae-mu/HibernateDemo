package com.tae.dao;

import com.tae.domain.Customer;
import com.tae.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/7/29.
 */
public class CustomerDao {
    /**
     * 保存客户
     * */
    public void save(Customer c){
        //先获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //保存用户
        session.save(c);
        tr.commit();
        session.close();
    }

    /**
     * 查询所有的客户
     * */
    public List<Customer> findAll(){
        //QBC查询
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //查询
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        tr.commit();
        session.close();
        return list;
    }

    /**
     * 带条件的查询
     * */
    public List<Customer> findAll(String custName){
        //QBC查询
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //查询
        Criteria criteria = session.createCriteria(Customer.class);
        if(custName!=null && !custName.trim().isEmpty()){
            criteria.add(Restrictions.like("cust_name","%"+custName+"%"));
        }
        List<Customer> list = criteria.list();
        tr.commit();
        session.close();
        return list;
    }
}

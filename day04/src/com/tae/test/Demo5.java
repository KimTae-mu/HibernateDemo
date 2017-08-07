package com.tae.test;

/**
 * Created by Taeyeon-Serenity on 2017/8/2.
 */

import com.tae.domain.Customer;
import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import sun.util.resources.cldr.saq.CurrencyNames_saq;

import java.util.*;

/**
 * HQL的多表查询
 * */
public class Demo5 {
    /**
     * 查询的客户，客户和联系人有关联
     * select * from cst_customer c,cst_linkman l where c.id = l.id;*/
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //内连接的查询
        Query query = session.createQuery("from Customer c inner join c.linkmans");

        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }


        tr.commit();
    }

    /**
     * 数据默认返回的数据，把数据封装到对象中
     * 提供关键字：fetch 迫切连接 可以把数据封装到对象中
     * */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //内连接的查询
        Query query = session.createQuery("from Customer c inner join fetch c.linkmans");

        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }


        tr.commit();
    }

    /**
     * 数据的重复问题
     * */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //内连接的查询
        Query query = session.createQuery("from Customer c inner join fetch c.linkmans");

        List<Customer> list = query.list();
        //手动解决
        Set<Customer> set=new HashSet<Customer>(list);
        for (Customer customer : set) {
            System.out.println(customer);
        }


        tr.commit();
    }
}

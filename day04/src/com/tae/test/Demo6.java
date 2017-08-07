package com.tae.test;

/**
 * Created by Taeyeon-Serenity on 2017/8/2.
 */

import com.tae.domain.Customer;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 演示延迟加载，提升程序的性能
 * */
public class Demo6 {
    /**
     * 类级别的延迟加载
     * 需要使用session.load() 默认情况使用的延迟加载
     * */
    @Test
    public void run1(){
        //查询客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //使用get方法
        Customer c1 = session.get(Customer.class, 1L);
        System.out.println("==============================");
        System.out.println(c1.getCust_name());

        tr.commit();
    }

    /**
     * 类级别的延迟加载
     * 需要使用session.load() 默认情况使用的延迟加载
     * */
    @Test
    public void run2(){
        //查询客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //load方法，默认是延迟加载
        Customer c1 = session.load(Customer.class,1L);

        System.out.println("==============================");
        System.out.println(c1.getCust_name());

        tr.commit();
    }

    /**
     * 关联级别的延迟加载
     * 说的是客户下的联系人的集合
     * */
    @Test
    public void run3(){
        //查询客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //先查询1号客户
        Customer c1 = session.get(Customer.class, 1L);
        System.out.println("===============================");
        //看客户下面的所有联系人
        System.out.println(c1.getLinkmans().size());

        tr.commit();
    }
}

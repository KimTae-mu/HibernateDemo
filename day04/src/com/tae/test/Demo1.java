package com.tae.test;

import com.tae.domain.Customer;
import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Taeyeon-Serenity on 2017/8/1.
 */
public class Demo1 {
    /**
     * 对象导航的方式
     * */
    @Test
    public void run1(){
        //先查询1号客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //先使用OID的方式查询客户
        Customer c = session.get(Customer.class, 1L);
        System.out.println("===================");
        //查看该客户下的联系人的集合
        System.out.println(c.getLinkmans().size());

        tr.commit();
    }

    /**
     * 查询联系人，属于某一个客户
     * */
    @Test
    public void run2(){
        //先查询1号客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Linkman man = session.get(Linkman.class, 5L);
        System.out.println("========================");
        System.out.println(man.getCustomer().getCust_name());

        tr.commit();
    }
}

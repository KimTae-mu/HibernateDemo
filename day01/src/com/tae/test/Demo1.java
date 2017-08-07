package com.tae.test;

/**
 * Created by Taeyeon-Serenity on 2017/7/29.
 */

import com.tae.domain.Customer;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * 测试Hibernate框架
 * */
public class Demo1 {
    /**
     * 测试保存客户
     * */
    @Test
    public void testSave(){
        /**
         * 先加载配置文件
         * 创建SessionFactory对象，生成Session对象
         * 创建session对象
         * 开启事务
         * 编写保存代码
         * 提交事务
         * 释放资源
         * */
        Configuration config=new Configuration();
        //默认加载src目录下hibernate.cfg.xml的配置文件
        config.configure();

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tr = session.beginTransaction();

        //编写保存的代码
        Customer c=new Customer();
        c.setCust_name("测试1");
        c.setCust_level("2");
        c.setCust_phone("110");
        //保存数据，操作对象就相当于操作数据库的表结构
        session.save(c);

        tr.commit();

        session.close();
        factory.close();
    }

    @Test
    public void testSave2(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        Customer c=new Customer();
        c.setCust_name("testSave2");
        session.save(c);

        tr.commit();
        session.close();
    }

    @Test
    public void testGet(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //测试查询的方法 2个参数：查询JavaBean的class对象；主键的值
        Customer c = session.get(Customer.class, 17L);
        System.out.println(c);

        tr.commit();
        session.close();
    }

    /**
     * 测试删除的方法
     * 注意：删除或者修改，先查询在删除或修改
     * */
    @Test
    public void testDel(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //查询
        Customer c = session.get(Customer.class, 17L);
        //删除客户
        session.delete(c);

        tr.commit();
        session.close();
    }

    /**
     * 测试修改
     * */
    @Test
    public void testUpdate(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //测试查询的方法 2个参数：查询JavaBean的class对象；主键的值
        Customer c = session.get(Customer.class, 16L);
        c.setCust_name("修改");
        c.setCust_level("3");

        session.update(c);

        tr.commit();
        session.close();
    }

    /**
     * 测试添加或者修改
     * */
    @Test
    public void SaveOrUpdate(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        Customer c=new Customer();
        c.setCust_name("添加");
        c.setCust_level("4");

        session.saveOrUpdate(c);

        tr.commit();
        session.close();
    }

    /**
     * 测试查询的方法
     * */
    @Test
    public void testSel(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //创建查询的接口
        Query query = session.createQuery("from Customer ");
        //查询所有的数据 select * from 表
        List<Customer> list=query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        tr.commit();
        session.close();
    }
}

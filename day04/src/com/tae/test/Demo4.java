package com.tae.test;

/**
 * Created by Taeyeon-Serenity on 2017/8/2.
 */

import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * SQL的查询方式
 * */
public class Demo4 {
    /**
     * 测试SQL语句的查询
     * */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建的是SQL的查询的接口
        SQLQuery query = session.createSQLQuery("select * from cst_linkman");

        List<Object[]> list=query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }

        tr.commit();
    }

    /**
     * 把数据封装到对象中
     * */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建的是SQL的查询的接口
        SQLQuery query = session.createSQLQuery("select * from cst_linkman");
        //通过方法设置
        query.addEntity(Linkman.class);
        List<Linkman> list = query.list();

        for (Linkman linkman : list) {
            System.out.println(linkman);
        }

        tr.commit();
    }
}

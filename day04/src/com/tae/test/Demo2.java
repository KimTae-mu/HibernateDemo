package com.tae.test;

import com.tae.domain.Customer;
import com.tae.domain.Linkman;
import com.tae.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Taeyeon-Serenity on 2017/8/1.
 */
/**
 * 演示HQL的基本查询
 * */
public class Demo2 {
    @Test
    public void run1(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        Query query = session.createQuery("from Customer");
        //调用list()方法
        List<Customer> list = query.list();
        for(Customer customer : list){
            System.out.println(customer);
        }

        tr.commit();
    }

    /**
     * 支持方法链的编程风格
     * */
    @Test
    public void run2(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        List<Customer> list = session.createQuery("from Customer").list();
        for(Customer customer : list){
            System.out.println(customer);
        }

        tr.commit();
    }

    /**
     * 具有别名的方式
     * */
    @Test
    public void run3(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        List<Customer> list = session.createQuery("select c from Customer c").list();
        for(Customer customer : list){
            System.out.println(customer);
        }

        tr.commit();
    }

    /**
     * 排序查询
     * SQL：order by 字段asc/desc
     * HQL：关键字都是一样的，都是用order by 属性
     * */
    @Test
    public void run4(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //查询联系人
        List<Linkman> list = session.createQuery("from Linkman l order by l.lkm_id desc").list();
        for(Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * HQL分页查询的两个方法
     * setFirstResult(a)    --从哪条记录开始，如果查询是从第一条开始，值是0
     * setMaxResults(b)     --每页查询的记录条数
     * */
    @Test
    public void run5(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("from Linkman l");
        //分页查询  调用方法，查询第一页的数据1-3条
        /*query.setFirstResult(0);
        query.setMaxResults(3);*/
        //查询第二页的数据
        query.setFirstResult(3);//(当前页-1)*pageSize
        query.setMaxResults(3);



        List<Linkman> list = query.list();
        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * 按条件进行查询
     * */
    @Test
    public void run6(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("from Linkman l where l.lkm_id > ? and l.lkm_gender = ?");
        //query.setString(0,"男");
        //query.setString("gender","女");
        //query.setLong(0,2L);
        //通用的方法，不用再去判断具体的类型
        query.setParameter(0,3L);
        query.setParameter(1,"女");

        List<Linkman> list=query.list();
        for (Linkman linkman : list){
            System.out.println(linkman);
        }


        tr.commit();
    }

    /**
     * 投影查询：只查询几个字段，不是所有的字段
     * */
    @Test
    public void run7(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("select lkm_name,lkm_gender from Linkman");
        List<Object[]> list = query.list();
        for (Object[] objects : list){
            System.out.println(Arrays.toString(objects));
        }

        tr.commit();
    }

    /**
     * 投影查询：只查询几个字段，不是所有的字段
     * 第一步：需要在JavaBean类提供对应的构造方法
     * 第二步：HQL语句需要发生变化*/
    @Test
    public void run8(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("select new Linkman(lkm_name,lkm_gender) from Linkman");
        List<Linkman> list = query.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * 聚合函数：count() sum() avg() max() min()
     * */
    @Test
    public void run9(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //查询的所有的联系人的数量
        List<Number> list = session.createQuery("select count(*) from Linkman").list();
        //通过下标值取值
        long count = list.get(0).longValue();
        System.out.println("数量："+count);

        tr.commit();
    }

    /**
     * 聚合函数：count() sum() avg() max() min()
     * */
    @Test
    public void run10(){
        Session session= HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //查询的所有的联系人的数量
        List<Number> list = session.createQuery("select sum(lkm_id) from Linkman").list();
        //通过下标值取值
        long count = list.get(0).longValue();
        System.out.println("数量："+count);

        tr.commit();
    }
}

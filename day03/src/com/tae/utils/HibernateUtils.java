package com.tae.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Taeyeon-Serenity on 2017/7/29.
 */
public class HibernateUtils {
    private static final Configuration CONFIG;
    private static final SessionFactory FACTORY;

    static {
        //加载xml配置文件
        CONFIG=new Configuration().configure();
        //构造工厂
        FACTORY=CONFIG.buildSessionFactory();
    }

    /**
     * 从工厂中获取Session对象
     * */
    public static Session getSession(){
        return FACTORY.openSession();
    }

    /**
     * 本地session
     * */
    public static Session getCurrentSession(){
        return FACTORY.getCurrentSession();
    }

    public static void main(String[] args) {
        //调用获取session的方法
        getSession();
    }
}

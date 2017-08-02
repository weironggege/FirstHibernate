package com.weirong.hibernate;


import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		//1.创建一个sessionFactory对象
		SessionFactory sessionFactory = null;
		
		//2. 创建一个session对象
		//1). 创建一个configuration对象：对应hibernate的基本配置信息和对象映射关系信息
		Configuration configuration = new Configuration().configure();
		
		//2). 创建一个ServiceRegistry对象: hibernate 4.x 新添加的对象，
		//hibernate 的任何配置对象和服务器都需要注册后才能有效
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		//3. 开启事务
		Transaction transaction = session.beginTransaction();
		
		//4. 执行保存操作
//		News news = new News(1, "java", "weirong", new Date(new java.util.Date().getTime()));
//		session.save(news);
		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);
		
		//5. 提交事务
		transaction.commit();
		
		//6. 关闭session
		session.close();
		
		//7. 关闭sessionFactory对象
		sessionFactory.close();
	}

}

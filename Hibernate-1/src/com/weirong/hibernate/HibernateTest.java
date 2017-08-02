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
		//1.����һ��sessionFactory����
		SessionFactory sessionFactory = null;
		
		//2. ����һ��session����
		//1). ����һ��configuration���󣺶�Ӧhibernate�Ļ���������Ϣ�Ͷ���ӳ���ϵ��Ϣ
		Configuration configuration = new Configuration().configure();
		
		//2). ����һ��ServiceRegistry����: hibernate 4.x ����ӵĶ���
		//hibernate ���κ����ö���ͷ���������Ҫע��������Ч
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		//3. ��������
		Transaction transaction = session.beginTransaction();
		
		//4. ִ�б������
//		News news = new News(1, "java", "weirong", new Date(new java.util.Date().getTime()));
//		session.save(news);
		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);
		
		//5. �ύ����
		transaction.commit();
		
		//6. �ر�session
		session.close();
		
		//7. �ر�sessionFactory����
		sessionFactory.close();
	}

}

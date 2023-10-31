package com.mywork.deeptech;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

public class EmployeeStoreData {

	public static void main(String[] args) {
		StandardServiceRegistry s = new StandardServiceRegistryBuilder().configure("hbconfig.cfg.xml").build();
		Metadata meta = new MetadataSources(s).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		//Connection b/w java application with database establish time
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setEmpname("Maaz");
		e1.setDesignation("Developer");
		e1.setSalary(50000);
		session.save(e1);
		t.commit();
		System.out.println("Data Saved Successfully");
		factory.close();
		session.close();
		
	}

}

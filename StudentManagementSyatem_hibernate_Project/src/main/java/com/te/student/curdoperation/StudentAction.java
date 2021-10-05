package com.te.student.curdoperation;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.hibernate.exception.InvalidRollnoException;
import com.te.project.dao.Student;

public class StudentAction {
	Student student = new Student();
	Scanner scanner = new Scanner(System.in);
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	public void selectAllData() {
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		String findall = "from Student";
		Query query = manager.createQuery(findall);
		List<Student> list = query.getResultList();
		System.out.println("\n........All Student Information............");
		for (Student employee : list) {
			System.out.println(employee);

		}

	}

	public void selectParticularData() {
		try {
			System.out.println("Please Provide the Rollno to Display ");
			int rollno = scanner.nextInt();
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			student = manager.find(Student.class, rollno);
			String findall = "from Student where rollno =:rollno";
			if (manager.contains(student)) {
				Query query = manager.createQuery(findall);
				query.setParameter("rollno", rollno);

				List<Student> list = query.getResultList();
				System.out.println("......... Information for RollNo -> " + rollno + " ...........");
				for (Student student : list) {
					System.out.println(student);

				}
			} else {
				throw new InvalidRollnoException("Roll_No is Incurrect / Not Found Please Provide Valide Roll_No..");
			}
		} catch (InvalidRollnoException e) {
			e.printStackTrace();

		}

	}

	public void updateData() {

		System.out.println("Pease Provide the rollno to Update :");
		int rollno = scanner.nextInt();
		System.out.println("Please Provide the Name to Upate :");
		String name = scanner.next();
		System.out.println("Please Provide the phoneno to Update :");
		String phoneno = scanner.next();
		System.out.println("Please Provide the standard to Update");
		String standard = scanner.next();

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			student = manager.find(Student.class, rollno);
			String update = "update Student set name = :name, phoneno = :phoneno, standard=:standard  where rollno =:rollno ";
			if (manager.contains(student)) {
				Query query = manager.createQuery(update);
				query.setParameter("rollno", rollno);
				query.setParameter("name", name);
				query.setParameter("phoneno", phoneno);
				query.setParameter("standard", standard);
				int result = query.executeUpdate();
				transaction.commit();
			} else {
				try {
					throw new InvalidRollnoException("Please Provide Valide RollNo to Update");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteData() {

		System.out.println("Pease Provide the rollno to Delete the Data From DataBase :");
		int rollno = scanner.nextInt();

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			student = manager.find(Student.class, rollno);
			String deleteData = "delete from Student where rollno = :rollno";
			if (manager.contains(student)) {
				Query query = manager.createQuery(deleteData);
				query.setParameter("rollno", rollno);
				int result = query.executeUpdate();
				System.out.println("Requested Data has been Deleted Succusfuly");
				transaction.commit();
			} else {
				try {
					throw new InvalidRollnoException("Please Provide Valide Roll_No to Delete");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertData() {

		student.setRollno(999);
		student.setName("Ravan");
		student.setPhoneno("988049XXX8");
		student.setStandard("12th");

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(student);
			System.out.println(" Requested Object Added to the Data Base!.............");
			System.out.println(student);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}

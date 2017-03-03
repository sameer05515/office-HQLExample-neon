package com.journaldev.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.pojo.EmployeeNameCity;
import com.journaldev.hibernate.util.HibernateUtil;

public class HQLExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();
		for (Employee emp : empList) {
			System.out.println("List of Employees::" + emp.getId() + "," + emp.getAddress().getCity());
		}

		// Get Employee with id
		query = session.createQuery("from Employee where id= :id");
		query.setLong("id", 3);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("Employee Name=" + emp.getName() + ", City=" + emp.getAddress().getCity());

		// Update Employee
		query = session.createQuery("update Employee set name= :name where id= :id");
		query.setParameter("name", "Pankaj Kumar");
		query.setLong("id", 1);
		int result = query.executeUpdate();
		System.out.println("Employee Update Status=" + result);

		// Delete Employee, we need to take care of foreign key constraints too
		query = session.createQuery("delete from Address where id= :id");
		query.setLong("id", 4);
		// result = query.executeUpdate();
		System.out.println("Address Delete Status=" + result);

		query = session.createQuery("delete from Employee where id= :id");
		query.setLong("id", 4);
		// result = query.executeUpdate();
		System.out.println("Employee Delete Status=" + result);

		// Aggregate function examples
		query = session.createQuery("select sum(salary) from Employee");
		double sumSalary = (Double) query.uniqueResult();
		System.out.println("Sum of all Salaries= " + sumSalary);

		// join examples
		// query = session.createQuery("select a.city,e.name from Employee e "
		// + "INNER JOIN e.address a");
		// List<Object[]> list = query.list();
		// for(Object[] arr : list){
		// System.out.println(Arrays.toString(arr));
		// }
		query = session.createQuery(
				"select  new com.journaldev.hibernate.pojo.EmployeeNameCity(a.city,e.name) from Employee e "
						+ "INNER JOIN e.address a");
		List<EmployeeNameCity> list = query.list();
		for (EmployeeNameCity arr : list) {
			// System.out.println(Arrays.toString(arr));
			System.out.println(arr);
		}

		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();
	}

}

package com.tka.OperationalFlow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OperationalFlow.entity.Country;
import com.tka.OperationalFlow.entity.Employee;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country added Sucessfully...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country is updated";
		}
		 catch (Exception e) {
			 if(tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 if (session != null) {
				 session.close();
			 }
		 }
		return msg;
	}

	public String deleteCountry(int cid) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, cid);
			session.remove(country);
			tx.commit();

			msg = "Country is Deleted..";

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Country";
			
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Country getparticularCountryById(int cid) {
		
		Session session = null;
		Transaction tx = null;
		Country country = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			country = session.get(Country.class, cid);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.persist(emp);
			tx.commit();
			msg = "Employee Added Successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String updateCountry(int id, Employee emp) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Employee employee = session.get(Employee.class, id);
			employee.setName(emp.getName());
			employee.setMobileno(emp.getMobileno());
			employee.setEmailid(emp.getEmailid());
			employee.setSalary(emp.getSalary());
			employee.setStatus(emp.getStatus());
			employee.setDepartment(emp.getDepartment());
			employee.setCreatedBy(emp.getCreatedBy());
			employee.setCreatedDate(emp.getCreatedDate());
			employee.setUpdatedBy(emp.getUpdatedBy());
			employee.setUpdatedDate(emp.getUpdatedDate());
			employee.setCountry(emp.getCountry());
			session.merge(employee);
			tx.commit();
			msg = "Employee Record is updated...";
		}
		 catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 }
		  finally {
			  if (session != null) {
				  session.close();
			  }
		  }
		return msg;
	}

	public String deleteEmployee(int id) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Employee emp = session.get(Employee.class, id);
			session.remove(emp);
			msg = "employee is Deleted...";
		}
		 catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 }
		  finally {
			  if (session != null) {
				  session.close();
			  }
		  }
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		
		try {
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "from Employee";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();
			
		}
		 catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 }
	      finally {
	    	  if (session != null) {
	    		  session.close();
	    	  }
	      }
		return list;
	}

	public Employee getParticularById(int id) {
		
		Session session = null;
		Transaction tx = null;
		Employee emp = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			tx.commit();
		}
		 catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 }
		  finally {
			  if (session != null) {
				  session.close();
			  }
		  }
		return emp;
	}

	public Employee login(Employee e) {
		
		Session session = null;
		Transaction tx = null;
		Employee emp = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where emailid=:emailid and mobileno=:mobileno";
			
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("emailid", e.getEmailid());
			query.setParameter("mobileno", e.getMobileno());
			
			emp = query.uniqueResult();
			tx.commit();
		}
		 catch (Exception e1) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e1.printStackTrace();
		 }
		 finally {
			 if (session != null) {
				 session.close();
			 }
		 }
		return emp;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where salary between :startSal and :endSal";
		try {	
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}		
		
		return list;
	}
}

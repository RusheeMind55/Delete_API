package com.jbk.SimpleProjectRestApl.Dao;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.SimpleProjectRestApl.entity.Country;
import com.jbk.SimpleProjectRestApl.entity.Employee;


@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 session.persist(c);
		 tx.commit();
		 msg="Data Addedd Succefully..";
		 
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String updateCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 Country country= session.get(Country.class,c.getCid() );
		 
		 country.setCname(c.getCname());
		 
		 session.merge(country);
		 tx.commit();
		 msg="Data is Updatated Successfully...";		 
		 
		
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
		
		return msg;
	}

	public String addEmployee(Employee e) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 session.persist(e);
		 tx.commit();
		 msg="Record is Addedd Successfully";
		 
		 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
		
		
	}
public String updateEmployee(Employee e) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 Employee employee= session.get(Employee.class,e.getId() );
		 
		 employee.setName(e.getName());
		 employee.setPhoneno(e.getPhoneno());
		 employee.setStatus(e.getStatus());
		 employee.setDepartment(e.getDepartment());
		 employee.setUpdatedby(e.getUpdatedby());
		 employee.setUpdateddtm(e.getUpdateddtm());
		
		 
		 session.merge(employee);
		 tx.commit();
		 msg="Data is Updatated Successfully...";		 
		 
		
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
public List<Country> getAllRecord() {
	
	Session session= factory.openSession();
	session.beginTransaction();
	
	String hqlQuery="from Country";
	
	org.hibernate.query.Query<Country> query= session.createQuery(hqlQuery,Country.class);
	
	List<Country> list= query.list();
	session.getTransaction().commit();
	session.close();	
	
	return list;		
	
}

public List<Employee> getAllRecordEmp(){
	
	 Session session=factory.openSession();
	 session.beginTransaction();
	 
	 String hqlQuery="from Employee";
	 
	 org.hibernate.query.Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
	
	 List<Employee> list=query.list();
	 session.getTransaction().commit();
	 session.close();
	 
	 return list;
}

//delete data for Employee

public String deleteData(Employee e) {
	Session session=null;
	 Transaction tx=null;
	 String msg=null;
	 Employee e1=null;
	 try {
		 	session= factory.openSession();
		 	
		tx=	session.beginTransaction();
			
			Employee emp=
			session.get(Employee.class,e.getId());
			session.remove(e1);
			
			 tx.commit();
			 msg="data deleted";
					
			

	} catch (Exception e2) {
		if(tx!=null) {
			tx.rollback();
			
		}
		e2.printStackTrace();


	}
	finally {
		if(session!=null) {
			session.close();
		}
	}
		 return msg;
	 }

//country
public Country getParticularRecord(Country c) {
	
 Session session=null;
 Transaction tx=null;
 String msg=null;
 Country c1=null;
 try {
	 	session= factory.openSession();
	 	
	tx=	session.beginTransaction();
		
		String hqlQuery="from Country where id=:myid";
		
		
		Query<Country> query=session.createQuery(hqlQuery,Country.class);
		query.setParameter("myid",c.getCid());
		
		c1= query.uniqueResult();
		session.getTransaction().commit();
		session.close();		
		return c1;		
		

} catch (Exception e) {
	if(tx!=null) {
		tx.rollback();
		
	}
	e.printStackTrace();


}
finally {
	if(session!=null) {
		session.close();
	}
}
	 return c1;
 }
public Employee getParticularRecord(Employee Emp) {
	
	 Session session=null;
	 Transaction tx=null;
	 String msg=null;
	 Employee Emp1=null;
	 try {
		 	session= factory.openSession();
		 	
		tx=	session.beginTransaction();
			
			String hqlQuery="from Employee where id=:myid";
			
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("myid",Emp.getId());
			
			Emp1= query.uniqueResult();
			session.getTransaction().commit();
			session.close();		
			return Emp1;		
			

	} catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
			
		}
		e.printStackTrace();


	}
	finally {
		if(session!=null) {
			session.close();
		}
	}
		 return Emp1;
}

public String deleteData(Country c) {
	Session session=null;
	 Transaction tx=null;
	 String msg=null;
	 Country c1=null;
	 try {
		 	session= factory.openSession();
		 	
		tx=	session.beginTransaction();
			
		Country c2=session.get(Country.class,c.getCid());
			session.remove(c2);
			
			 tx.commit();
			 msg="data deleted";
					
			

	} catch (Exception e2) {
		if(tx!=null) {
			tx.rollback();
			
		}
		e2.printStackTrace();


	}
	finally {
		if(session!=null) {
			session.close();
		}
	}
		 return msg;
	 }
}
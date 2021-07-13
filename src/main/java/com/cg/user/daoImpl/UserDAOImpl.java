package com.cg.user.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.user.dao.UserDAO;
import com.cg.user.domain.User;
import com.cg.user.util.JPAUtil;

public class UserDAOImpl implements UserDAO {

	JPAUtil jpa = new JPAUtil();
    EntityManager em = jpa.getEntityManager();
    User emp = new User();
	public void save(User user) {
   
    em.getTransaction().begin();
    em.persist(user);
    em.getTransaction().commit();
    jpa.closeEntityManager();
    
	}

	public void update(User user) {
		em.getTransaction().begin();
	    emp=em.find(User.class, user.getId());
		emp.setName(user.getName());
		emp.setCity(user.getCity());
		emp.setDept(user.getDept());
		em.getTransaction().commit();
		jpa.closeEntityManager();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
	em.getTransaction().begin();
	emp =em.find(User.class, id);
	em.remove(emp);
	em.getTransaction().commit();
		
		
    
    
	}

	public List<User> findall() {
	Query q = jpa.getEntityManager().createQuery("from User");
	List<User> emp =q.getResultList();
	jpa.closeEntityManager();
		return emp;
	}

}

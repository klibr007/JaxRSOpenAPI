package kanbandao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import kanbanjpa.User;





public class UserDao {
	
	private EntityManager manager;

    public UserDao() {
    	
        this.manager = EntityManagerHelper.getEntityManager();
    }
    
    

	public User findOne(Long id) {
		return manager.find(User.class, id);
	}

	public List<User> findAll() {
		return manager.createQuery("select e from " + User.class.getName() + " as e", User.class).getResultList();
	}

	public void save(User entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		manager.persist(entity);
		t.commit();

	}

	public User update(final User entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		User res = manager.merge(entity);
		t.commit();
		return res;

	}

	public void delete(User entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		manager.remove(entity);
		t.commit();

	}

	public void deleteById(Long entityId) {
		User entity = findOne(entityId);
		delete(entity);
	}
}

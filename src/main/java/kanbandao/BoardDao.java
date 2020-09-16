package kanbandao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import kanbanjpa.Board;





public class BoardDao {

	private EntityManager manager;

    public BoardDao(EntityManager manager) {
        this.manager = manager;
    }
    
    

	public Board findOne(Long id) {
		return manager.find(Board.class, id);
	}

	public List<Board> findAll() {
		return manager.createQuery("select e from " + Board.class.getName() + "as e",Board.class).getResultList();
	}

	public void save(Board entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		manager.persist(entity);
		t.commit();

	}

	public Board update(final Board entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		Board res = manager.merge(entity);
		t.commit();
		return res;

	}

	public void delete(Board entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		manager.remove(entity);
		t.commit();

	}

	public void deleteById(Long entityId) {
		Board entity = findOne(entityId);
		delete(entity);
	}
}

package kanbandao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import kanbanjpa.Card;


public class CardDao {
	
	private EntityManager manager;

    public CardDao(EntityManager manager) {
        this.manager = manager;
    }
    
    

	public Card findOne(Long id) {
		return manager.find(Card.class, id);
	}

	public List<Card> findAll() {
		return manager.createQuery("select e from " + Card.class.getName() + " as e",Card.class).getResultList();
	}

	public void save(Card entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		manager.persist(entity);
		t.commit();

	}

	public Card update(final Card entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		Card res = manager.merge(entity);
		t.commit();
		return res;

	}

	public void delete(Card entity) {
		EntityTransaction t = this.manager.getTransaction();
		t.begin();
		manager.remove(entity);
		t.commit();

	}

	public void deleteById(Long entityId) {
		Card entity = findOne(entityId);
		delete(entity);
	}

}

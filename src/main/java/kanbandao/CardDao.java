package kanbandao;


import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import kanbanjpa.Card;


public class CardDao extends AbstractJpaDao<Long, Card>{
	
	public CardDao() {
		this.setClazz(Card.class);
	}
	
}

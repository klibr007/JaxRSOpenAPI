package kanbandao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import kanbanjpa.Board;





public class BoardDao extends AbstractJpaDao<Long, Board>{
	
	public BoardDao() {
		this.setClazz(Board.class);
	}
	
}

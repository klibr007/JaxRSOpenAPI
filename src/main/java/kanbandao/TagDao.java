package kanbandao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import kanbanjpa.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag>{
	
	public TagDao() {
		this.setClazz(Tag.class);
	}
	
}
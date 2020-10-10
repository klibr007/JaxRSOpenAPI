package kanbandao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import kanbanjpa.Section;

public class SectionDao extends AbstractJpaDao<Long, Section>{
	
	public SectionDao() {
		this.setClazz(Section.class);
	}
	
}
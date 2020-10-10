package kanbandao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import kanbanjpa.User;

public class UserDao extends AbstractJpaDao<Long, User>{
	
	public UserDao() {
		this.setClazz(User.class);
	}
	
}
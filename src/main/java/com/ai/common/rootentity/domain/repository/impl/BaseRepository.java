package com.ai.common.rootentity.domain.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository {
	@Autowired
	SessionFactory sessionFactory;
	public BaseRepository(){
		
	}	
	public BaseRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}

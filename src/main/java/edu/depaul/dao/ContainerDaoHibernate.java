/**
 * 
 */
package edu.depaul.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.depaul.domain.Container;

/**
 * @author ptrzyna
 *
 */
@Repository
public class ContainerDaoHibernate implements ContainerDao<Container> {

	private SessionFactory sessionFactory;
	
	@Autowired
	public ContainerDaoHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see edu.depaul.dao.ContainerDao#store(edu.depaul.domain.Container)
	 */
	@Override
	public void store(Container container) {
		sessionFactory.getCurrentSession().saveOrUpdate(container);
	}
	
	
	
}

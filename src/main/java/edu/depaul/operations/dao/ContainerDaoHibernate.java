/**
 * 
 */
package edu.depaul.operations.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.depaul.operations.domain.Container;

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
	 * @see edu.depaul.operations.dao.ContainerDao#store(edu.depaul.operations.domain.Container)
	 */
	@Override
	public void store(Container container) {
		sessionFactory.getCurrentSession().saveOrUpdate(container);
	}
	
	
	
}

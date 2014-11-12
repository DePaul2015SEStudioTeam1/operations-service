/**
 * 
 */
package edu.depaul.operations.dao;

import java.util.List;

import org.hibernate.Query;
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

	/* (non-Javadoc)
	 * @see edu.depaul.operations.dao.ContainerDao#getAll()
	 */
	@Override
	public List<Container> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Container");
		return query.list();
	}

	/* (non-Javadoc)
	 * @see edu.depaul.operations.dao.ContainerDao#get(long, int)
	 */
	@Override
	public List<Container> get(long id, int count) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Container where id > :id");
		query.setLong("id", id);
		query.setMaxResults(count);
		return query.list();
	}
	
	
	
}

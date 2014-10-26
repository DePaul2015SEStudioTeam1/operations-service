/**
 * 
 */
package edu.depaul.service;

import org.springframework.transaction.annotation.Transactional;

import edu.depaul.dao.ContainerDao;
import edu.depaul.model.Container;

/**
 * Concrete implementation of the OperationsService
 * 
 * @author Paul A. Trzyna
 */
@Transactional
public class OperationsServiceImpl implements OperationsService<Container> {
	
	private ContainerDao<edu.depaul.domain.Container> containerDao;
	
	/**
	 * @param containerDao the containerDao to set
	 */
	public void setContainerDao(ContainerDao<edu.depaul.domain.Container> containerDao) {
		this.containerDao = containerDao;
	}

	/* (non-Javadoc)
	 * @see edu.depaul.service.OperationsService#store(edu.depaul.model.Container)
	 */
	public void store(Container container) {
		edu.depaul.domain.Container domain = new edu.depaul.domain.Container();
		// copy over
		containerDao.store(domain);
	}

}

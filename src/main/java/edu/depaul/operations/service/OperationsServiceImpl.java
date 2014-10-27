/**
 * 
 */
package edu.depaul.operations.service;

import org.springframework.transaction.annotation.Transactional;

import edu.depaul.operations.dao.ContainerDao;
import edu.depaul.operations.model.Container;

/**
 * Concrete implementation of the OperationsService
 * 
 * @author Paul A. Trzyna
 */
@Transactional
public class OperationsServiceImpl implements OperationsService<Container> {
	
	private ContainerDao<edu.depaul.operations.domain.Container> containerDao;
	
	/**
	 * @param containerDao the containerDao to set
	 */
	public void setContainerDao(ContainerDao<edu.depaul.operations.domain.Container> containerDao) {
		this.containerDao = containerDao;
	}

	/* (non-Javadoc)
	 * @see edu.depaul.operations.service.OperationsService#store(edu.depaul.operations.model.Container)
	 */
	public void store(Container container) {
		edu.depaul.operations.domain.Container domain = new edu.depaul.operations.domain.Container();
		// copy over
		containerDao.store(domain);
	}

}

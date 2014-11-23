/**
 * 
 */
package edu.depaul.operations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.depaul.operations.converter.DomainContainerConverter;
import edu.depaul.operations.converter.ModelContainerConverter;
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
	private DomainContainerConverter domainConverter;
	private ModelContainerConverter modelConverter;
	
	/**
	 * @param modelConverter the modelConverter to set
	 */
	public void setModelConverter(ModelContainerConverter modelConverter) {
		this.modelConverter = modelConverter;
	}
	
	/**
	 * @param domainConverter the domainConverter to set
	 */
	public void setDomainConverter(DomainContainerConverter domainConverter) {
		this.domainConverter = domainConverter;
	}
	
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
		// TODO add versioning of db records to let hibernate do this automatically
		edu.depaul.operations.domain.Container old = containerDao.findWithAgentId(container.getAgentId());
		edu.depaul.operations.domain.Container domain = modelConverter.convert(container);
		if(old != null) {
			domain.setId(old.getId());
		}
		containerDao.store(domain);
	}

	/* (non-Javadoc)
	 * @see edu.depaul.operations.service.OperationsService#getAll()
	 */
	@Override
	public List<Container> getAll() {
		
		List<edu.depaul.operations.domain.Container> domainContainers = containerDao.getAll(); 
		List<Container> modelContainers = new ArrayList<Container>();
		for(edu.depaul.operations.domain.Container domain : domainContainers) {
			modelContainers.add(domainConverter.convert(domain));
		}
		
		return modelContainers; 
	}

	/* (non-Javadoc)
	 * @see edu.depaul.operations.service.OperationsService#get(long, int)
	 */
	@Override
	public List<Container> get(long id, int count) {
		
		List<edu.depaul.operations.domain.Container> domainContainers = containerDao.get(id, count); 
		List<Container> modelContainers = new ArrayList<Container>();
		for(edu.depaul.operations.domain.Container domain : domainContainers) {
			modelContainers.add(domainConverter.convert(domain));
		}
		
		return modelContainers; 
	}

}

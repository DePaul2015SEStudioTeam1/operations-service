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
		
		domain.setAgentId(container.getAgentId());
		
		domain.setCpuCount(container.getCpuCount());
		domain.setCpuModel(container.getCpuModel());
		domain.setCpuVendor(container.getCpuVendor());
		
		domain.setMemTotal(container.getMemTotal());
		domain.setMemFree(container.getMemFree());
		domain.setMemUsed(container.getMemUsed());
		
		domain.setOsDescription(container.getOsDescription());
		domain.setOsDataModel(container.getOsDataModel());
		domain.setOsName(container.getOsName());
		
		domain.setPrimaryIpAddress(container.getPrimaryIpAddress());
		domain.setPrimaryMacAddress(container.getPrimaryMacAddress());
		
		domain.setHostName(container.getHostName());
		
		domain.setDiskSpaceTotal(container.getDiskSpaceTotal());
		domain.setDiskSpaceFree(container.getDiskSpaceFree());
		domain.setDiskSpaceUsed(container.getDiskSpaceUsed());
		
		containerDao.store(domain);
	}

}

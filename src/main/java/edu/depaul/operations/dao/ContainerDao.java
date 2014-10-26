/**
 * 
 */
package edu.depaul.operations.dao;


/**
 * @author ptrzyna
 */
public interface ContainerDao<Container> {

	/**
	 * Stores a container
	 * 
	 * @param container	container instance we want to store
	 */
	void store(Container container);
	
}

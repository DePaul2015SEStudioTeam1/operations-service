/**
 * 
 */
package edu.depaul;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.depaul.model.Container;
import edu.depaul.service.OperationsService;

/**
 * @author ptrzyna
 */
public class ServiceIntegrationTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans/operations-client.xml");
		OperationsService service = context.getBean("remoteOperationsService", OperationsService.class);
		service.store(new Container());
		
	}
	
}

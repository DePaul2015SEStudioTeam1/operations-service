/**
 * 
 */
package edu.depaul.operations.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.depaul.operations.model.Container;
import edu.depaul.operations.service.OperationsService;

/**
 * @author ptrzyna
 *
 */
@Controller
@RequestMapping("/containers")
public class OperationsController {

	private OperationsService<Container> operationsService;
	
	/**
	 * @param operationsService the operationsService to set
	 */
	public void setOperationsService(OperationsService<Container> operationsService) {
		this.operationsService = operationsService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Container> getAll() {
		return operationsService.getAll();
	}
	
	
}

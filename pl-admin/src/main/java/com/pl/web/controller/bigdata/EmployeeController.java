package com.pl.web.controller.bigdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pl.web.model.Employee;
import com.pl.web.service.impl.EmployeeServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class EmployeeController {
	@Autowired
    private EmployeeServiceIMP employeeServiceIMP;
	@ResponseBody
	@RequestMapping(value="listEmps")
	public String listDepartments(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		String department_id = request.getParameter("id");
		List<Employee> employees = employeeServiceIMP.getEmps(department_id);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(employees);	
		response.setContentType("text/javascript");
		return result;
	}
}

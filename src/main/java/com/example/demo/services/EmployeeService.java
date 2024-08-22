package com.example.demo.services;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.*;



import org.springframework.stereotype.Service;

import com.example.demo.pojos.EmployeePojo;

@Service
public class EmployeeService {
	private static Map<Long, EmployeePojo> empMap=new HashMap();
	private static AtomicLong atomic=new AtomicLong();
	
	public void create(EmployeePojo employeePojo) {
		employeePojo.setId(atomic.incrementAndGet());
		empMap.put(employeePojo.getId(), employeePojo);
		System.out.println(empMap);
		
	}
	public Collection<EmployeePojo>getAllEmp(){
		return empMap.values();
				}
	public void deleteEmp(Long id) {
		empMap.remove(id);
	}
	public EmployeePojo getEmpById(Long id) {
		return empMap.get(id);
	}
	public void updateEmp(Long id, EmployeePojo employeePojo) {
		empMap.put(id, employeePojo);
	}
	}



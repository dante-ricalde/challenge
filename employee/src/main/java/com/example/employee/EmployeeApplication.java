package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeType;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.EmployeeTypeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
        final EmployeeService employeeService = context.getBean(EmployeeService.class);
        final EmployeeTypeService employeeTypeService = context.getBean(EmployeeTypeService.class);
        final EmployeeType employeeType = new EmployeeType("full time", "10000");
        employeeTypeService.save(employeeType);

        Employee employee = new Employee();
        employee.setName("Juan");
        employee.setTelephone("12345");
        employee.setEmployeeType(employeeType);
        employeeService.save(employee);

        // find to check
        //employeeService.
    }

}

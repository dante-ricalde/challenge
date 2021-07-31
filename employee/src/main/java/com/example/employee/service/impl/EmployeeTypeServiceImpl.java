package com.example.employee.service.impl;

import com.example.employee.model.EmployeeType;
import com.example.employee.repository.EmployeeTypeRepository;
import com.example.employee.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link EmployeeTypeServiceImpl}<br/>
 *
 * @author dante<br />
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Dante Raphael Ricalde Delgado. (DRD)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Jul 06, 2021 (DRD) Creation class.</li>
 * </ul>
 * @version 1.0
 */
@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    @Override
    public EmployeeType save(EmployeeType employee) {
        return employeeTypeRepository.save(employee);
    }
}

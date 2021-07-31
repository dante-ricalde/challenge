package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link EmployeeRepository}<br/>
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
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}

package com.example.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link EmployeeType}<br/>
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
@Entity
@Data
@AllArgsConstructor
@Table
public class EmployeeType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private String salary;

    public EmployeeType(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }
}

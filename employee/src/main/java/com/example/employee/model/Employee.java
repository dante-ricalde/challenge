package com.example.employee.model;

import lombok.Data;

import javax.persistence.*;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link Employee}<br/>
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
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "employmentDate")
    private String employmentDate;

    @OneToOne
    @JoinColumn(name = "employeeTypeId")
    private EmployeeType employeeType;




}

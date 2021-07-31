//
Company
Employee
EmployeeType

how do you can relate that a employee worked in a company in a given date?
create an intermediate table between  company and employee named company_employee and add a field date.
insert a employee in cascade (it should persis the employee and employeeType)
//

DROP TABLE IF EXISTS employee_type;
DROP TABLE IF EXISTS employee;

CREATE TABLE employee_type (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               name VARCHAR(250) NOT NULL,
                               salary VARCHAR(250) NOT NULL
);

CREATE TABLE employee (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              type VARCHAR(250) NOT NULL,
                              telephone VARCHAR(250) DEFAULT NULL,
                              address VARCHAR(250) DEFAULT NULL,
                              employmentDate VARCHAR(250) DEFAULT NULL,
                              employeeTypeId INT,
                              foreign key (employeeTypeId) references employee_type(id)

);
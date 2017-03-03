CREATE SEQUENCE Employee_seq;

CREATE TABLE Employee (
  emp_id int check (emp_id > 0) NOT NULL DEFAULT NEXTVAL ('Employee_seq'),
  emp_name varchar(20) NOT NULL,
  emp_salary double precision NOT NULL DEFAULT '0',
  PRIMARY KEY (emp_id)
)  ;

ALTER SEQUENCE Employee_seq RESTART WITH 1;
 
CREATE TABLE Address (
  emp_id int check (emp_id > 0) NOT NULL,
  address_line1 varchar(50) NOT NULL DEFAULT '',
  zipcode varchar(10) DEFAULT NULL,
  city varchar(20) DEFAULT NULL,
  PRIMARY KEY (emp_id),
  CONSTRAINT emp_fk_1 FOREIGN KEY (emp_id) REFERENCES Employee (emp_id)
) ;

INSERT INTO Employee (emp_id, emp_name, emp_salary)
VALUES
	(1, 'Pankaj', 100),
	(2, 'David', 200),
	(3, 'Lisa', 300),
	(4, 'Jack', 400);


INSERT INTO Address (emp_id, address_line1, zipcode, city)
VALUES
	(1, 'Albany Dr', '95129', 'San Jose'),
	(2, 'Arques Ave', '95051', 'Santa Clara'),
	(3, 'BTM 1st Stage', '560100', 'Bangalore'),
	(4, 'City Centre', '100100', 'New Delhi');
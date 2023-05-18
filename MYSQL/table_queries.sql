CREATE DATABASE IF NOT EXISTS hr;

CREATE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(100)
);
CREATE TABLE employees (
    id int AUTO_INCREMENT primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    department_id int not null,
    FOREIGN KEY (department_id)
        REFERENCES departments (department_id)
);
INSERT INTO departments(dept_name)
VALUES('Sales'),('Markting'),('Finance'),('Accounting'),('Warehouses'),('Production');

INSERT INTO employees(first_name,last_name,department_id) 
VALUES('John','Doe',1),
		('Bush','Lily',2),
		('David','Dave',3),
		('Mary','Jane',4),
		('Jonatha','Josh',5),
		('Mateo','More',1);

 -- Referenced By VIEW

CREATE VIEW v_employee_info AS 
    SELECT 
        id,first_name,last_name,dept_name
    FROM
        employees
            INNER JOIN
        departments USING (department_id);

ALTER TABLE departments RENAME TO depts;


-- Checking constraint while deleting table rows
DELETE FROM depts where department_id = 1;

-- rename multiple tables
RENAME TABLE 
    depts TO department,
    people TO employees;

-- Rename table using ater table

ALTER TABLE table_name RENAME TO new_table_name;

-- Temporary Table
CREATE TEMPORARY TABLE lastNames
SELECT DISTINCT last_name from employees;

-- rename temporary table using
   i. RENAME TABLE lastNames TO unique_lastnames;
   -- Error 1146 : Table hr.lastnames doesnot exists 
   ii. ALTER TABLE lastNames RENAME TO unique_lastnames;
   -- Query OK, 6 rows affected


-- Adding column if exists or not exists
ALTER TABLE employees
    ADD COLUMN IF NOT EXISTS location varchar(100);

SELECT 
    IF(count(*)=1,'Exists','Not Exists') as result
FROM 
    information_schema.columns
WHERE   
    table_schema = 'hr'
    AND
    table_name = 'employees'
    AND
    column_name = 'first_name';


-- set table  schemas and pattern matching for the table;

CREATE TABLE test1();

CREATE TABLE IF NOT EXISTS test2 LIKE test1;
CREATE TABLE IF NOT EXISTS test3 LIKE test1;

SET @schema = 'database_name'
SET @pattern = 'test%'

SELECT CONCAT('DROP TABLE', GROUP_CONCAT(CONCAT(@schema,'.'table_name)),';')
INTO @dropLike 
FROM information_schema.tables 
WHERE @schema = database()
AND table_name LIKE @pattern;
SELECT @dropLike;


SELECT * from employees;


-- Generated Columns
CREATE TABLE IF NOT EXISTS contacts(
    id int AUTO_INCREMENT primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    fullname varchar(100) GENERATED ALWAYS AS (CONCAT(first_name,' ',last_name))
)[,virtual,stored];

ALTER TABLE products
    ADD COLUMN totalPrice int GENERATED ALWAYS AS (quantityInStock*buyPrice);
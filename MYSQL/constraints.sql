
-- creating task table
CREATE TABLE tasks(
    task_id INT PRIMARY KEY,  -- UNIQUE and NOT NULL
    task_name VARCHAR(100) NOT NULL,
    employee_id INT UNIQUE,
    days_assigned INT DEFAULT 2
); 

-- adding data without primary key

INSERT INTO tasks (task_name,employee_id,days_assigned) values('UI DESIGN',2,1);

INSERT INTO tasks (task_id,task_name,employee_id,days_assigned) values(1,'UI DESIGN',2,1);

-- repeating primary key
INSERT INTO tasks (task_id,task_name,employee_id,days_assigned) values(1,'Backend',2,1);

-- adding data without task_name and with same primary key
INSERT INTO tasks (task_id,employee_id,days_assigned) values(3,4,3);

INSERT INTO tasks (task_id,task_name,employee_id,days_assigned) values(2,'backend',3,1);

-- checking employee_id and default constraints
INSERT INTO tasks (task_id,task_name,employee_id) values(3,'frontend',4);

-- deleting employee
DELETE FROM employees WHERE id = 4;

ALTER TABLE tasks ADD CONSTRAINT fkey FOREIGN KEY (employee_id) REFERENCES employees(id)
ON DELETE RESTRICT;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME='STUDENT_INFO';
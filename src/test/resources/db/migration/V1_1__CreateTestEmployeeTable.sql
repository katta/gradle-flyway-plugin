CREATE TABLE employee(
    id serial NOT NULL,
    emp_name varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO employee (emp_name) VALUES ('katta');

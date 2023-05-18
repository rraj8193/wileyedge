-- return the employees who work in the offices located in the usa using subquery
SELECT
    lastname,
    firstname
FROM
    employees
WHERE
    officeCode IN (
        SELECT
            officeCode
        FROM
            offices
        WHERE
            country = "USA"
    );

-- MySQL subquery with Comparison Operators
-- return the customer who has the highest payment
SELECT
    customerNumber,
    checkNumber,
    amount
FROM
    payments
WHERE
    amount = (
        SELECT
            MAX(amount)
        FROM
            payments
    );

-- return the customer who has the payment higher than average payment 
SELECT
    customerNumber,
    checkNumber,
    amount
FROM
    payments
WHERE
    amount = (
        SELECT
            AVG(amount)
        FROM
            payments
    );

-- find the customer who haven't placed any order till date but is registered.
SELECT
    customerName
FROM
    customers
WHERE
    customerNumber NOT IN (
        SELECT
            DISTINCT(customerNumber)
        FROM
            Orders
    );

-- Find maximum, minimum and average number of itmes in sale orders with Subquery
SELECT
    MAX(items),
    MIN(items),
    FLOOR(AVG(items))
FROM
    (
        SELECT
            orderNumber,
            COUNT(orderNumber) AS items
        FROM
            orderdetails
        GROUP BY
            orderNumber
    ) as lineItems;

-- CORRELATED QUERIES
--select products whose buy prices re greater than average bu price of all products in each product line with correlated subquery
SELECT
    productName,
    buyprice
FROM
    products p1
WHERE
    buyprice > (
        SELECT
            AVG(buyprice)
        FROM
            products
        WHERE
            productline = p1.productline
    );

-- use the query above as a correlated subquery to find customers who placed at least one sales order with the total value greater than 60k by using the exists operator
SELECT
    customerNumber,
    customerName
FROM
    customers
WHERE
    EXISTS (
        SELECT
            orderNumber,
            SUM(priceEach * quantityOrdered)
        FROM
            orderdetails
            INNER JOIN orders USING (orderNumber)
        WHERE
            customerNumber = customers.customerNumber
        GROUP BY
            orderNumber
        HAVING
            SUM(priceEach * quantityOrdered) > 60000
    );

-- Get the top five products by sales revenue in 2003 
-- Exists
SELECT
    customerName,
    customerNumber
FROM
    customers c
WHERE
    EXISTS (
        SELECT
            customerNumber
        FROM
            orders
        WHERE
            c.customerNumber = customerNumber
    );

-- NOT EXISTS
SELECT
    customerName,
    customerNumber
FROM
    customers c
WHERE
    NOT EXISTS (
        SELECT
            customerNumber
        FROM
            orders
        WHERE
            c.customerNumber = customerNumber
    );

SELECT
    employeenumber,
    firstname,
    lastname,
    extension
FROM
    employees
WHERE
    EXISTS (
        SELECT
            2
        FROM
            offices
        WHERE
            city = 'San Francisco'
            AND offices.officeCode = employees.officeCode
    );

CREATE TABLE nosales
SELECT
    *
FROM
    customers c
WHERE
    NOT EXISTS (
        SELECT
            customerNumber
        FROM
            orders
        WHERE
            c.customerNumber = customerNumber
    );

SELECT
    CONCAT(firstname, " ", lastname) as fullname
from
    employees;

SELECT
    firstname
from
    employees
SELECT
    firstName,
    lastName
from
    employees
UNION
SELECT
    contactFirstName,
    contactLastName
FROM
    customers;

SELECT
    concat(firstName, " ", lastName) as fullname
FROM
    (
        SELECT
            firstName,
            lastName
        from
            employees
        UNION
        SELECT
            contactFirstName,
            contactLastName
        FROM
            customers
    ) as cdata;



SELECT
    concat(firstName, " ", lastName) as fullname
FROM
    (
        SELECT
            firstName,
            lastName
        from
            employees
        UNION
        SELECT
            contactFirstName,
            contactLastName
        FROM
            customers
    ) as cdata
ORDER BY
    fullname ASC;

SELECT
    concat(firstName, " ", lastName) as fullname,
    CASE
        WHEN EXISTS (
            SELECT
                1
            FROM
                employees
            WHERE
                cdata.firstName = employees.firstName
        ) THEN "EMPLOYEE"
        WHEN EXISTS (
            SELECT
                1
            FROM
                customers
            WHERE
                cdata.firstName = customers.contactFirstName
        ) THEN "CUSTOMER"
    END as contactType
FROM
    (
        SELECT
            firstName,
            lastName
        from
            employees
        UNION
        SELECT
            contactFirstName,
            contactLastName
        FROM
            customers
    ) as cdata
ORDER BY
    fullname ASC;
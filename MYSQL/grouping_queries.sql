-- Find all the orders that are already shipped and total amount greater than 1500
SELECT
    a.orderNumber,
    status,
    SUM(priceEach * quantityOrdered) AS total
FROM
    orderDetails a
    INNER JOIN orders b ON b.orderNumber = a.orderNumber
GROUP BY
    orderNumber,
    status
HAVING
    status = "Shipped"
    and total > 1500;

/* Creates a new table named sales thatstores the order values summarized by product lines and years.
 The data comes from the products, orders and orderDetails tables
 */
CREATE TABLE sales
SELECT
    productline,
    YEAR(orderDate) orderYear,
    SUM(priceEach * quantityOrdered) as orderValue
FROM
    orderDetails
    INNER JOIN orders USING(orderNumber)
    INNER JOIN products USING (productCode)
GROUP BY
    productline,
    orderYear;

-- Grouping ste uis a set of columns which we wanted to group
SELECT
    productline,
    SUM(orderValue) as totalOrderValue
FROM
    sales
GROUP BY
    productline;

-- two or more grouping sets together in one query UNION ALL
SELECT
    productline,
    SUM(orderValue) as totalOrderValue
FROM
    sales
GROUP BY
    productline
UNION
ALL
SELECT
    NULL,
    SUM(orderValue) totalOrderValue
FROM
    sales;

-- Using Roll up
SELECT
    productline,
    SUM(orderValue) as totalOrderValue
FROM
    sales
GROUP BY
    productline WITH ROLLUP;

-- Genereates following grouping set
C1 > C2 > C3
SELECT
    productline,
    orderYear,
    SUM(orderValue) as totalOrderValue
FROM
    sales
GROUP BY
    productline,
    orderYear WITH ROLLUP;

-- GROUPING():- Do super aggregate values has null in it's result or not.

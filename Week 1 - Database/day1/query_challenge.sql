-- 1.1
ALTER ROLE postgres SET search_path TO hr;

ALTER ROLE postgres SET search_path TO oe;

-- 2.1

SELECT c.category_id, c.category_name, COUNT(p.product_id) as total_category
FROM categories c JOIN products p ON c.category_id = p.category_id 
GROUP BY c.category_id, c.category_name ORDER BY c.category_id ASC;

-- 2.2
SELECT s.supplier_id, s.company_name, COUNT(p.product_id) as total_product
FROM suppliers s JOIN products p ON s.supplier_id = p.supplier_id
GROUP BY s.supplier_id, s.company_name ORDER BY total_product DESC;

-- 2.3
SELECT s.supplier_id, s.company_name, COUNT(p.product_id) as total_product,
TO_CHAR(AVG(p.unit_price), '999999.00') as avg_unit_price
FROM suppliers s JOIN products p ON s.supplier_id = p.supplier_id
GROUP BY s.supplier_id, s.company_name ORDER BY total_product DESC;

-- 2.4
select p.product_id, product_name, s.supplier_id, s.company_name, 
unit_price, units_in_stock, units_on_order, reorder_level
from products p
join suppliers s on p.supplier_id = s.supplier_id
where p.units_in_stock <= p.reorder_level
order by product_name asc;

-- 2.5
SELECT c.customer_id, c.company_name, COUNT(o.order_id) as total_order
FROM customers c JOIN orders o ON o.customer_id = c.customer_id
GROUP BY c.customer_id ORDER BY c.company_name ASC;

-- 2.6
SELECT order_id, customer_id, order_date, required_date, shipped_date, delivery_time
FROM
(SELECT order_id, customer_id, order_date, required_date,
shipped_date, (shipped_date - order_date) as delivery_time FROM orders) as query1
WHERE delivery_time > 10;

WITH query1 AS(
	SELECT order_id, customer_id, order_date, required_date,
	shipped_date, (shipped_date - order_date) as delivery_time FROM orders
)
SELECT * FROM query1 WHERE delivery_time > 10;

SELECT order_id, customer_id, order_date, required_date,
	shipped_date, (shipped_date - order_date) as delivery_time FROM orders
WHERE (shipped_date - order_date) > 10;

-- 2.7
SELECT p.product_id, p.product_name, SUM(od.quantity) as total_qty
FROM products p JOIN order_details od ON od.product_id = p.product_id
GROUP BY p.product_id ORDER BY total_qty DESC;

-- SELECT DISTINCT product_id, SUM(quantity) AS total_qty
-- FROM order_details GROUP BY product_id ORDER BY total_qty DESC;

SELECT product_id, SUM(quantity) AS total_qty
FROM order_details GROUP BY product_id ORDER BY total_qty DESC;

-- 2.8
SELECT p.category_id, c.category_name, SUM(od.quantity) as total_qty_ordered
FROM order_details od
JOIN products p ON od.product_id = p.product_id
JOIN categories c ON p.category_id = c.category_id
GROUP BY p.category_id, c.category_name ORDER BY total_qty_ordered DESC;

-- 2.9
WITH cte1 AS (
	SELECT p.category_id, c.category_name, SUM(od.quantity) as total_qty_ordered
	FROM order_details od
	JOIN products p ON od.product_id = p.product_id
	JOIN categories c ON p.category_id = c.category_id
	GROUP BY p.category_id, c.category_name ORDER BY total_qty_ordered DESC
)
SELECT * FROM cte1
WHERE total_qty_ordered = (SELECT MAX(cte1.total_qty_ordered) FROM cte1)
OR total_qty_ordered = (SELECT MIN(cte1.total_qty_ordered) FROM cte1);

-- 2.10
SELECT s.shipper_id, s.company_name,  p.product_id, p.product_name, SUM(od.quantity) as total_qty_ordered
FROM order_details od
JOIN products p ON od.product_id = p.product_id
JOIN orders o ON od.order_id = o.order_id
JOIN shippers s ON o.ship_via = s.shipper_id
GROUP BY s.company_name, p.product_name, s.shipper_id,  p.product_id
ORDER BY s.company_name ASC, p.product_name ASC;

-- 2.11
with total_per_category AS (
	select s.shipper_id, s.company_name, p.product_id, p.product_name, sum(od.quantity) AS total_qty_ordered
	from shippers s
	join orders o on s.shipper_id = o.ship_via
	join order_details od on o.order_id = od.order_id
	join products p on od.product_id = p.product_id
	group by p.product_name, s.shipper_id, s.company_name, p.product_id),
	ranked as (
	  select *, rank() over (partition by company_name order by total_qty_ordered desc) as rank_max,
			 rank() over (partition by company_name order by total_qty_ordered asc) as rank_min
	  from total_per_category
)
select shipper_id, company_name, product_id, product_name, total_qty_ordered
from ranked
where rank_max = 1 or rank_min = 1
order by shipper_id, total_qty_ordered;

-- 2.12
with recursive hirarki as (
	select
	e.employee_id,
	e.first_name||' '||last_name as full_name,
	e.manager_id,
	d.department_name,
	1 as level
	from hr.employees e join hr.departments d on e.department_id=d.department_id 
	where e.manager_id is null

	union all

	select
	p.employee_id,
	p.first_name||' '||last_name as full_name,
	p.manager_id,
	d.department_name,
	h.level + 1
	from hr.employees p
	join hr.departments d on p.department_id = d.department_id
	join hirarki h on p.manager_id=h.employee_id
)
select * from hirarki
order by employee_id;
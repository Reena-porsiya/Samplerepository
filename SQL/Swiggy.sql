select  customer.customer_name,orders.food_name
from orders,customer
where orders.customer_id = customer.customer_id;


update customer
set customer_name = 'JAS', city= 'MADURAI'
where customer_id = 1001;


delete from customer where customer_id=1002;

select  orders.order_no,customer.customer_name, orders.order_date
from orders
INNER JOIN customer ON orders.customer_id=customer.customer_id;


SELECT COUNT(customer_id), city
FROM customerordersorders
GROUP BY city
HAVING COUNT(customer_id) > 1;

select customer.customer_name from customer;
select customer.customer_id from customer;





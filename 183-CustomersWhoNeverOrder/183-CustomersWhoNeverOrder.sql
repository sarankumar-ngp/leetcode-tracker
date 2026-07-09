-- Last updated: 09/07/2026, 10:13:53
SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.id IS NULL;
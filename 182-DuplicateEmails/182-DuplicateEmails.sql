-- Last updated: 09/07/2026, 10:13:55
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;
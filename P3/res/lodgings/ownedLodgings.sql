SELECT *
FROM Lodgings L, Address A
WHERE L.aid = A.aid AND email = (?)

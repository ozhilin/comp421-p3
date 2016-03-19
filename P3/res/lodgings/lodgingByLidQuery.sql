SELECT *
FROM Lodgings L, Address A,
  (SELECT B.lid, AVG(rating) as avg_rating
    FROM Bookings B LEFT OUTER JOIN Reviews R ON B.bid = R.bid
    GROUP BY B.lid) AS lid_rating
WHERE L.aid = A.aid AND L.lid = ?;


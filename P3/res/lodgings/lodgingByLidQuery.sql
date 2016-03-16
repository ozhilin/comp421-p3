-- TODO use view if created
SELECT * FROM Lodgings L, Address A,
  (SELECT lid, AVG(rating) as avg_rating
    FROM Bookings B LEFT OUTER JOIN Reviews R ON B.bid = R.bid
    GROUP BY lid) AS lid_rating
WHERE L.aid = A.aid AND lid = ?;

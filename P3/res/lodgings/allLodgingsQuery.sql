SELECT * 
FROM Lodgings L
  JOIN 
    Address A 
    ON L.aid = A.aid
  LEFT OUTER JOIN
    (SELECT lid, AVG(rating) as avg_rating
      FROM Bookings B LEFT OUTER JOIN Reviews R ON B.bid = R.bid
      GROUP BY lid) AS lid_rating
    ON lid_rating.lid = L.lid;

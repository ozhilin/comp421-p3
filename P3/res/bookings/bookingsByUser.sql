SELECT *
FROM Bookings B 
  JOIN PaymentAccounts P 
    ON B.pid = P.pid AND P.email = (?)
  JOIN Lodgings L
    ON B.lid = L.lid
  JOIN Address A
    ON L.lid = A.lid
ORDER BY B.from_date DESC

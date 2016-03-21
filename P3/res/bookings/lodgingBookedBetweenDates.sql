SELECT lid
FROM Bookings B
WHERE B.lid = (?) AND (
  (?) BETWEEN from_date AND to_date OR 
  (?) BETWEEN from_date AND to_date)

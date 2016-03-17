SELECT * 
FROM Reviews R, Bookings B
WHERE R.bid = B.bid AND B.lid = (?)

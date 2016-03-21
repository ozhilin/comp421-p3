SELECT * 
FROM 
  PaymentAccounts P, 
  CreditCards C,
  Address A
WHERE 
  P.pid = C.pid AND 
  P.email = (?) AND
  C.aid = A.aid

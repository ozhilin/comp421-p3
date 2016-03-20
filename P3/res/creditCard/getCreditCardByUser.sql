SELECT * 
FROM PaymentAccounts P, CreditCards C
WHERE P.pid = C.pid AND P.email = (?);

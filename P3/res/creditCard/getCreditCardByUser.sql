SELECT * 
FROM PaymentAccounts P, CreditCards C
WHERE P.pid = C.cid AND P.email = (?);

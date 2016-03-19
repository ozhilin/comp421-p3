SELECT * 
FROM PaymentAccounts P, CreditCard C
WHERE P.pid = C.cid AND P.email = (?);

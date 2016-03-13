SELECT email, fname, lname, birthday, is_customer, is_host
FROM Users
WHERE email = (?) AND password = (?);

-- Users
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('john.doe@gmail.com', 'password', 'John', 'Doe', '1966-02-05', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('patricia.allman@gmail.com', '1234', 'Patricia', 'Allman', '1988-05-08', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('marcrussell@hotmail.com', 'tomato', 'Marc', 'Russell', '1995-05-06', '0', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('marthah@gmail.com', 'password', 'Martha', 'Herbert', '1994-09-25', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('suzyanglin@gmail.com', 'cauliflower', 'Susan', 'Anglin', '1976-03-20', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('jjsimpson@gmail.com', 'jellyfish', 'Johanne', 'Simpson', '1960-10-10', '0', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('leon.belanger@gmail.com', 'alpha', 'Leon', 'Belanger', '1991-11-01', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('rose.marshall@gmail.com', 'titanic', 'Rose', 'Marshall', '1972-04-07', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('pwozniak@gmail.com', 'apple', 'Paul', 'Wozniak', '1950-08-11', '1', '1');
INSERT into Users (email, password, fname, lname, birthday, is_customer, is_host) values ('adelaide.roberts@gmail.com', 'catfish', 'Adelaide', 'Roberts', '1979-12-14', '0', '1');

-- Address
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('101', 'University', '1', 'Canada', 'Quebec', 'Montreal', 'H0H 0H0');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('202', 'Sherbrooke', '2', 'Canada', 'Ontario', 'Toronto', 'H9H 1I1');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('2011', 'Main', '1', 'United States', 'New York', 'New York', '12323');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('3442', 'Bedford', '4', 'Canada', 'Alberta', 'Edmonton', 'H1H 0H0');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('1123', 'University', '5', 'Canada', 'Quebec', 'Mascouche','H2D 9S3');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('6238', 'Main Street North', '1', 'Canada', 'Quebec', 'Gatineau','H0H 0H1');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('746', 'Bridle Court', '6', 'United States', 'California', 'San Francisco','60452');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('4110', 'New Street', '9', 'Canada', 'Ontario', 'Ottawa','H5K 2S1');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('1989', 'Atwater', '2', 'Canada', 'Quebec', 'Laval','H1S 2S1');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('2931', 'Fairview Road', '7', 'United States', 'Misouri', 'St Louis','17109');
INSERT INTO Address(address_num, street, apt_num, country, province, city, postal_code) VALUES ('1845', 'Clintion Street', '7', 'United States', 'Arizona', 'Pheonix','95050');

-- Lodgings
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('john.doe@gmail.com','TOP SPOT NEAR EVRYTHING FREE PARKING', 'FREE PARKING! I REPLY FAST! Top trendy and young nghbrhood! Free parking in the street, metro station nearby with access to Montreal top attractions within minutes of metro ride! Big apt, lots of light and very quiet:) Big groups welcomed :)', 1, 'Appartment', 10, 2, 4, 6, 'I expect people to behave like roommates, with respect open communication about good and less good things or aspect of your stay. The apartment is very well isolated so it is OK to be a bit noisy inside. As for cleanliness, I have a standard clean as you go policy.', 200);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('patricia.allman@gmail.com','NEW LUXURY MODERN CONDO IN TORONTO', 'A walk score of 100 makes evident that this is definitely the best location in downtown Toronto, right next to Sherbrooke street. The building offers the best services and amenities. Bank of Montreal, Cafe Starbucks and Supermarket Adonis on the first floor.', 2, 'Appartment', 6, 1, 3, 3, 'Please note that the cleaning fee of $60 is included in the price and is for reservations up to 3 nights. Reservations of 4 nights or more will be charged an additional $20 and a price alteration will be done through the Airbnb system.', 300);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('marcrussell@hotmail.com','Elegant and sophisticated Townhouse', '4 beds + 2 couches. Impeccably maintained property. Steps away from parks, all services and public transportation. Beautiful quiet backyard with wooden deck and an outside spa. Stunning bathroom with a separate glass shower.', 3, 'House', 12, 3, 4, 6, 'No smoking allowed inside our home. No parties allowed inside our home. Please keep the noise level at low after 11pm. No shoes inside the house.', 400);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('marthah@gmail.com','Amazing 8BR Suites Waterview House', 'Inside the city of Edmonton, a beautiful large house with 8 bedrooms, 7 of them have their own private bathrooms. Large living room areas and fully equipped kitchen. Large river view terrace and garden with a nice and heated private swimming pool. ', 4, 'House', 20, 8, 8, 13, 'The customer must notify of any changes, damages or other abnormalities that may occurred during their stay.', 1500);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('suzyanglin@gmail.com','Jesses Garden Getaway', 'This apartment can accommodate up to 6 persons: kitchen, dining room, lounge with sofa bed(2) , 2 closed bedrooms, washer and dryer, cable, internet and a balcony which overlooks downtown Mascouche!', 5, 'Appartment', 6, 1, 3, 3, 'I would appreciate that you leave all the dirty laundry in one spot and that you leave the dishes clean.', 150);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('jjsimpson@gmail.com','Cozy place in Gatineau', 'Located on historic St Laurent and Prince Arthur, this spacious apartment has everything you need for entertainment: BBQ, 43-in Plasma TV, XBOX 360, Foosball table, right next to restaurants ,coffee shops and neighbours three clubs in Gatineau nightlife. Come experience Gatineau at the centre!', 6, 'Appartment', 8, 2, 3, 4, 'There is a zero tolerence for noisy partying late at night. Respect the neighboors and stay quiet in the common aeras, they can hear you talking in the staircase.', 300);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('leon.belanger@gmail.com','Sweet home +Metro near downtown', 'Completely furnished 6 person apartment with 3 bedroom near metro station. The location is close to Downton SF (15minutes to Downtown SF taking the metro), or by car taking the 225 highway. Private free tempo parking available.washer and dryer are in the basement.', 7, 'Appartment', 6, 2, 3, 3, 'My building was built in 1885. Please be very gentle with doors and especially the old windows. Hang your wet towels on a towel bar and please dont put your dirty luggage on my white duvets.', 250);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('rose.marshall@gmail.com','Beautiful and cosy oasis in Ottawa', 'This beautiful, comfy Victorian apartment ( 5 1/2 w 2 closed bedrooms) in Ottawa is seconds from Parc Victoria; a 20 min walk to downtown! It is a spacious, light, artistic and peaceful.', 8, 'Appartment', 6, 1, 2, 3, 'NO SMOKING. When you smoke on the outside porch or in the back garden please make sure to throw your cigarettes butts in the trash.', 200);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('pwozniak@gmail.com','Beautiful warm unique Laval home', 'Beautiful open air apartment in Laval, 1100sqft, working fireplace, quiet neighbourhood, sunny, big balconies, trees, near parks, boutiques, restaurants, best bakery in town, family butcher, wine/liquor store, flower shop', 9, 'Appartment', 5, 1, 2, 3, 'Please take your shoes off inside because #1 you are in Canada, #2 your shoes are dirty, and #3 it torments the neighbour downstairs.', 300);
INSERT into Lodgings(email, name, description, aid, lodging_type, num_guests, bathrooms, bedrooms, beds, custom_policy, day_price) VALUES ('adelaide.roberts@gmail.com','Stunning view, 28th floor Downtown', 'I got a large 550 sq. ft studio downtown St Louis. Awesome for couples but up to 6 persons can comfortably sleep and have a restful night after spending the day visiting or the night enjoying the citys unique nightlife', 10, 'Appartment', 6, 1, 3, 3, ' This is not the place if you are looking to celebrate someones birthday or graduation. Please minimal noise after 10PM. We mainly take couples or families or professionals here on business.', 350);


-- Amenities
INSERT INTO Amenities(lid, description) VALUES (1, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (1, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (1, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (1, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (1, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (1, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (1, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (1, 'Iron and Board');
INSERT INTO Amenities(lid, description) VALUES (1, 'BBQ');
INSERT INTO Amenities(lid, description) VALUES (1, 'WI-FI');

INSERT INTO Amenities(lid, description) VALUES (2, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (2, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (2, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (2, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (2, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (2, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (2, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (2, 'Iron and Board');
INSERT INTO Amenities(lid, description) VALUES (2, 'WI-FI');
INSERT INTO Amenities(lid, description) VALUES (2, 'Fireplace');

INSERT INTO Amenities(lid, description) VALUES (3, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (3, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (3, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (3, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (3, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (3, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (3, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (3, 'BBQ');

INSERT INTO Amenities(lid, description) VALUES (4, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (4, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (4, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (4, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (4, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (4, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (4, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (4, 'Iron and Board');
INSERT INTO Amenities(lid, description) VALUES (4, 'Pool Table');
INSERT INTO Amenities(lid, description) VALUES (4, 'BBQ');
INSERT INTO Amenities(lid, description) VALUES (4, 'WI-FI');

INSERT INTO Amenities(lid, description) VALUES (5, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (5, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (5, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (5, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (5, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (5, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (5, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (5, 'BBQ');
INSERT INTO Amenities(lid, description) VALUES (5, 'WI-FI');
INSERT INTO Amenities(lid, description) VALUES (5, 'Fireplace');

INSERT INTO Amenities(lid, description) VALUES (6, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (6, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (6, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (6, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (6, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (6, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (6, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (6, 'Iron and Board');
INSERT INTO Amenities(lid, description) VALUES (6, 'Pool Table');
INSERT INTO Amenities(lid, description) VALUES (6, 'WI-FI');

INSERT INTO Amenities(lid, description) VALUES (7, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (7, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (7, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (7, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (7, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (7, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (7, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (7, 'Iron and Board');
INSERT INTO Amenities(lid, description) VALUES (7, 'BBQ');

INSERT INTO Amenities(lid, description) VALUES (8, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (8, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (8, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (8, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (8, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (8, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (8, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (8, 'Pool Table');
INSERT INTO Amenities(lid, description) VALUES (8, 'WI-FI');

INSERT INTO Amenities(lid, description) VALUES (9, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (9, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (9, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (9, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (9, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (9, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (9, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (9, 'BBQ');
INSERT INTO Amenities(lid, description) VALUES (9, 'Fireplace');

INSERT INTO Amenities(lid, description) VALUES (10, 'Stove');
INSERT INTO Amenities(lid, description) VALUES (10, 'Fridge');
INSERT INTO Amenities(lid, description) VALUES (10, 'Microwave');
INSERT INTO Amenities(lid, description) VALUES (10, 'Dishwasher');
INSERT INTO Amenities(lid, description) VALUES (10, 'Cable TV');
INSERT INTO Amenities(lid, description) VALUES (10, 'Washer');
INSERT INTO Amenities(lid, description) VALUES (10, 'Dryer');
INSERT INTO Amenities(lid, description) VALUES (10, 'Iron and Board');
INSERT INTO Amenities(lid, description) VALUES (10, 'WI-FI');
INSERT INTO Amenities(lid, description) VALUES (10, 'Fireplace');

--INSERT INTO Amenities(lid, description) VALUES (1, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Iron and Board, BBQ, WI-FI');
--INSERT INTO Amenities(lid, description) VALUES (2, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Iron and Board, WI-FI, Fireplace');
--INSERT INTO Amenities(lid, description) VALUES (3, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, BBQ, WI-FI');
--INSERT INTO Amenities(lid, description) VALUES (4, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Iron and Board, Pool Table, BBQ, WI-FI, Fireplace');
--INSERT INTO Amenities(lid, description) VALUES (5, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, BBQ, WI-FI, Fireplace');
--INSERT INTO Amenities(lid, description) VALUES (6, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Iron and Board, Pool Table, WI-FI');
--INSERT INTO Amenities(lid, description) VALUES (7, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Iron and Board, BBQ, WI-FI');
--INSERT INTO Amenities(lid, description) VALUES (8, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Pool Table, WI-FI');
--INSERT INTO Amenities(lid, description) VALUES (9, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, BBQ, WI-FI, Fireplace');
--INSERT INTO Amenities(lid, description) VALUES (10, 'Stove, Fridge, Microwave, Dishwasher, Cable TV, Washer, Dryer, Iron and Board, WI-FI, Fireplace');

-- Payment Accounts
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1234653123423452134', 'john.doe@gmail.com', 'My credit card');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('3452309580138741023', 'patricia.allman@gmail.com', 'Mom''s credit card'); -- Escaping a quote done with another quote
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1340978345234591237', 'marcrussell@hotmail.com', 'Gift card 1');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1340871203413250987', 'marthah@gmail.com', 'Sister gift card');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1345897012340987132', 'suzyanglin@gmail.com', 'MasterCard');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1345523515270362910', 'jjsimpson@gmail.com', 'My first credit card');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1346011470778394329', 'jjsimpson@gmail.com', 'Christmas gift card');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1344716391062044029', 'leon.belanger@gmail.com', 'Visa');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1343738606261764202', 'rose.marshall@gmail.com', 'American Express');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1345451368023420916', 'pwozniak@gmail.com', 'Old gift card');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1346011293098555480', 'adelaide.roberts@gmail.com', 'Gift card 1000');
INSERT INTO PaymentAccounts(pid, email, name) VALUES ('1343773413121732823', 'adelaide.roberts@gmail.com', 'Gift card 900');

-- Credit cards
INSERT INTO CreditCards(pid, aid, expiration_date) VALUES ('1234653123423452134', '1', '2014-09-17');
INSERT INTO CreditCards(pid, aid, expiration_date) VALUES ('3452309580138741023', '2', '2017-05-25');
INSERT INTO CreditCards(pid, aid, expiration_date) VALUES ('1345897012340987132', '3', '2015-03-15');
INSERT INTO CreditCards(pid, aid, expiration_date) VALUES ('1345523515270362910', '4', '2016-06-06');
INSERT INTO CreditCards(pid, aid, expiration_date) VALUES ('1344716391062044029', '5', '2019-09-09');
INSERT INTO CreditCards(pid, aid, expiration_date) VALUES ('1343738606261764202', '6', '2016-05-29');

-- Gift cards
INSERT INTO GiftCards(pid, price_limit) VALUES('1340978345234591237', '2000');
INSERT INTO GiftCards(pid, price_limit) VALUES('1340871203413250987', '900');
INSERT INTO GiftCards(pid, price_limit) VALUES('1346011470778394329', '950');
INSERT INTO GiftCards(pid, price_limit) VALUES('1345451368023420916', '1500');
INSERT INTO GiftCards(pid, price_limit) VALUES('1346011293098555480', '1000');
INSERT INTO GiftCards(pid, price_limit) VALUES('1343773413121732823', '900');

--Bookings
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('150', '1234653123423452134', '1', '2015-04-20', '2015-04-27', 805.50);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('204', '1234653123423452134', '2', '2015-05-10', '2015-05-12', 268.65);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('3412', '3452309580138741023', '2', '2015-10-06', '2015-10-10', 500.00);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('134', '3452309580138741023', '1', '2016-02-13', '2016-02-14', 206.00);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('12', '1340978345234591237', '3', '2015-07-02', '2015-08-30', 2100.00);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('2434', '1340871203413250987', '4', '2015-08-20', '2015-08-29', 940.60);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('213', '1345897012340987132', '8', '2015-12-20', '2015-12-26', 1204.50);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('215', '1345897012340987132', '5', '2016-02-07', '2016-02-10', 230.00);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('854', '1340978345234591237', '6', '2016-02-13', '2016-02-17', 315.00);
INSERT into Bookings (bid, pid, lid, from_date, to_date, total_price) values('753', '1340978345234591237', '7', '2016-03-01', '2016-03-04', 550.50);

--Reviews
INSERT into Reviews (email, bid, review_date, review, rating) values ('adelaide.roberts@gmail.com', '150', '2015-03-20', 'I''ve very much enjoyed my stay at the apartment of Yordan. It wasn''t a problem to arrive late at night and was warmly welcomed by Yordan. It''s a very cozy place and it has lots of charm. The couch in front of the fireplace is just splendid. Showering is a little bit of a hassle but you can always opt for a bath. The apartment is situated in a really calm street even though you''re in the middle of old Québec. Just perfect.', '5');
INSERT into Reviews (email, bid, review_date, review, rating) values ('marcrussell@hotmail.com', '204', '2015-05-12', 'The listing was exactly like the photos! It is beautiful, well decorated, clean and has a great feel to it. It is located in a great area of old Montreal. This place is a keeper!', '4');
INSERT into Reviews (email, bid, review_date, review, rating) values ('leon.belanger@gmail.com', '3412', '2015-08-04', 'Stayed here for three nights and had a great time. The view from the apartment was great! Check in was easy with detailed instructions. The apartment was clean and comfortable, close to many downtown shopping/restaurants/amenities.', '5');
INSERT into Reviews (email, bid, review_date, review, rating) values ('pwozniak@gmail.com', '134', '2016-02-04', 'The room we rented from Cécile was just as advertised. It was clean and had enough room for our big suitcases. The apartment was also clean and comfortable. We didn''t meet Cécile, but she was helpful in arranging our arrival via her roommate.', '5');
INSERT into Reviews (email, bid, review_date, review, rating) values ('jjsimpson@gmail.com', '12', '2015-07-20', 'I was extremely happy with this room and the location. The view was beautiful and we were close to all of the attractions in Toronto. From the time that we were let into the building until we left, it felt like home.', '5');
INSERT into Reviews (email, bid, review_date, review, rating) values ('rose.marshall@gmail.com', '2434', '2015-10-11', 'Description was perfect very accommodating. The place was very clean, cleaners were amazing. The location was good. Overall I recommend this place.', '5');
INSERT into Reviews (email, bid, review_date, review, rating) values ('marthah@gmail.com', '213', '2015-12-02', 'My stay at the "Chic and comfy home" ....horrible. I didn''t even get to stay at the condo! The arrangements were that the door was to be left open with the key on the counter. I arrived with tons of groceries only to realize that the door was locked and there was almost no way of contacting the owners. Once I finally contacted them they told the man at the front desk to open the door. Once I stepped in I instantly seen a kitchen that was filthy , living room full of cigarettes, prescription pills, and tons of clothes. When I opened the blinds to look at the bed there was a laptop there and it looked as if someone had just stepped out of this place and I was almost breaking and entering !!! I instantly left , the owners girlfriend that I was communicating with decided to book me a hotel ( which I didn''t want hence the airbnb booking ). I ended up getting to the hotel at 11pm! And having to pay for parking downtown. Maybe this was a mistake on their behalf or Im not sure what exactly was going on but the condo was double booked and left me and my weekend with nothing but headache', '1');
INSERT into Reviews (email, bid, review_date, review, rating) values ('adelaide.roberts@gmail.com', '854', '2016-01-25', 'There was something wrong with this apartment in the day that we arrived but Elfie was more than helpful, efficient and kind to put us in a different one that was also in a great location with amazing view. Everything we needed was there!', '3');
INSERT into Reviews (email, bid, review_date, review, rating) values ('john.doe@gmail.com', '753', '2015-09-17', 'The flat is in a very good location with an incredible view. St Patrick station is really at few seconds from the flat. We stayed 3 nights and it was very comfortable.', '4');


-- Create tables here

-- Main entities
CREATE TABLE Users (
  email VARCHAR (255) PRIMARY KEY,
  password VARCHAR (255),
  fname VARCHAR (255),
  lname VARCHAR (255),
  birthday DATE,
  is_customer BOOLEAN,
  is_host BOOLEAN
);

CREATE TABLE Address (
  aid SERIAL PRIMARY KEY,
  address_num INTEGER,
  street VARCHAR (255),
  apt_num INTEGER DEFAULT 0, 
  country VARCHAR (255),
  province VARCHAR (50),
  city VARCHAR (50),
  postal_code VARCHAR (20)
  CONSTRAINT unique_address UNIQUE (aid, address_num, street, apt_num, country, province, city, postal_code)
);


CREATE TABLE PaymentAccounts (
  pid VARCHAR(128) PRIMARY KEY,
  email VARCHAR (255) REFERENCES Users ON DELETE CASCADE,
  name VARCHAR (255)
);
CREATE TABLE CreditCards (
  pid VARCHAR(128) PRIMARY KEY,
  aid SERIAL REFERENCES Address,
  expiration_date DATE,
  FOREIGN KEY (pid) REFERENCES PaymentAccounts ON DELETE CASCADE
);
CREATE TABLE GiftCards (
  pid VARCHAR(128) PRIMARY KEY,
  price_limit INTEGER,
  FOREIGN KEY (pid) REFERENCES PaymentAccounts ON DELETE CASCADE
);

CREATE TABLE Lodgings (
  lid SERIAL PRIMARY KEY,
  aid SERIAL REFERENCES Address ON DELETE CASCADE,
  email VARCHAR (255) REFERENCES Users ON DELETE CASCADE,
  name VARCHAR (255),
  description VARCHAR (300),
  lodging_type VARCHAR (255),
  num_guests INTEGER,
  bathrooms INTEGER,
  bedrooms INTEGER,
  beds INTEGER,
  custom_policy TEXT,
  day_price FLOAT
);

CREATE TABLE Bookings (
  bid SERIAL PRIMARY KEY,
  pid VARCHAR(128) REFERENCES PaymentAccounts ON DELETE CASCADE,
  lid INTEGER REFERENCES Lodgings ON DELETE CASCADE,
  from_date DATE,
  to_date DATE,
  total_price INTEGER
);
-- Weak entities
CREATE TABLE Amenities (
  lid INTEGER REFERENCES Lodgings ON DELETE CASCADE,
  description VARCHAR (150),
  CONSTRAINT unique_amenity PRIMARY KEY (lid, description)
);

-- relationships
CREATE TABLE Reviews (
  email VARCHAR (255) REFERENCES Users ON DELETE CASCADE,
  bid INTEGER REFERENCES Bookings ON DELETE CASCADE,
  review_date DATE,
  review TEXT,
  rating INTEGER,
  CONSTRAINT unique_review PRIMARY KEY(email, bid)
);

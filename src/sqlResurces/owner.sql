CREATE TABLE owner
(
    id      SERIAL PRIMARY KEY,
    first_name VARCHAR(10) NOT NULL,
    last_name VARCHAR(10) NOT NULL,
    phone_number INT,
    email VARCHAR(50)
);

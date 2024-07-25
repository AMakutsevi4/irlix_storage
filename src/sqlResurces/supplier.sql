CREATE TABLE supplie
(
    id      SERIAL PRIMARY KEY,
    company VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL
);

INSERT INTO supplie VALUES (1, 's','s');
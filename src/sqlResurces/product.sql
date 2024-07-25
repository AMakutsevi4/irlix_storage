CREATE TABLE product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    price       INTEGER NOT NULL,
    calories    INTEGER NOT NULL,
    supplie_id INTEGER REFERENCES supplie (id),
    structure   VARCHAR(255) NOT NULL
);


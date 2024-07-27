CREATE TABLE owner
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(10) NOT NULL,
    last_name    VARCHAR(10) NOT NULL,
    phone_number INTEGER,
    email        VARCHAR(50)
);

CREATE TABLE supplie
(
    id       SERIAL PRIMARY KEY,
    company  VARCHAR(50) NOT NULL,
    address  VARCHAR(50) NOT NULL,
    owner_id INTEGER,
    FOREIGN KEY (owner_id) REFERENCES owner
);

CREATE TABLE product
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(50)  NOT NULL,
    price      INTEGER      NOT NULL,
    calories   INTEGER      NOT NULL,
    supplie_id INTEGER REFERENCES supplie (id),
    structure  VARCHAR(255) NOT NULL
);


CREATE TABLE type
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE product_type
(
    product_id INTEGER NOT NULL REFERENCES product (id),
    type_id    INTEGER NOT NULL REFERENCES type (id),
    PRIMARY KEY (product_id, type_id)
);
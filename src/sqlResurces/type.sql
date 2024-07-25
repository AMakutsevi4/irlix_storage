CREATE TABLE type (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      description VARCHAR(255)
);

CREATE TABLE product_type (
                              product_id INTEGER NOT NULL REFERENCES product(id),
                              type_id INTEGER NOT NULL REFERENCES type(id),
                              PRIMARY KEY (product_id, type_id)
);

INSERT INTO owner(first_name, last_name, phone_number, email)
VALUES ('Александр', 'М', 88888888, 'alexandr@mail.ru');
INSERT INTO owner(first_name, last_name, phone_number, email)
VALUES ('Иван', 'И', 7777777, 'ivan@yandex.ru');
INSERT INTO owner(first_name, last_name, phone_number, email)
VALUES ('Пётр', 'П', 99999999, 'petr@gmail.ru');

INSERT INTO supplie(company, address, owner_id)
VALUES ('рис и тесто', 'г. Москва, улица Ленина, офис 7б', 1);
INSERT INTO supplie(company, address, owner_id)
VALUES ('Конфетная фабрика', 'г. Новосибирск, улица Попова, офис 12', 2);
INSERT INTO supplie(company, address, owner_id)
VALUES ('Салат', 'г. Барнаул, улица Красной армии, офис 56', 3);

INSERT INTO product(name, price, calories, supplie_id, structure)
VALUES ('Печенье', 150, 12, 1, 'Тут описывается состав печенья');
INSERT INTO product(name, price, calories, supplie_id, structure)
VALUES ('Красная шапочка', 80, 42, 2, 'Тут описывается состав конфеты');
INSERT INTO product(name, price, calories, supplie_id, structure)
VALUES ('Карамель', 540, 92, 3, 'Тут описывается состав конфеты');

INSERT INTO type(name, description)
VALUES ('шоколад', 'свежий');
INSERT INTO type(name, description)
VALUES ('карамель', 'свежий');
INSERT INTO type(name, description)
VALUES ('пастила', 'свежий');

INSERT INTO product_type(product_id, type_id)
VALUES (1, 1);
INSERT INTO product_type(product_id, type_id)
VALUES (2, 2);
INSERT INTO product_type(product_id, type_id)
VALUES (3, 3);
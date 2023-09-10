CREATE TABLE products (
	productId int PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL,
	description VARCHAR(400) NOT NULL,
	price float NOT NULL
);

INSERT INTO products VALUES (1, 'Apple', 'A fruit', 2.99);
INSERT INTO products VALUES (2, 'Banana', 'And another fruit', 2.49);
INSERT INTO products VALUES (3, 'Coconut', 'And another one', 5.99);
INSERT INTO products VALUES (4, 'Dragon Fruit', 'One more', 10.99);
INSERT INTO products VALUES (5, 'Eggplant', 'A Vegetable', 1.99);

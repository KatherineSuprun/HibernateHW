CREATE TABLE IF NOT EXISTS products (
                                        id serial NOT NULL PRIMARY KEY ,
                                        username text UNIQUE,
                                        price bigint,
                                        quantity Integer );

INSERT INTO products (username,price,quantity) values

                                                   ('lipstick', 287, 127),
                                                   ('ink', 259, 300),
                                                   ('lip gloss', 287, 300),
                                                   ('foundation', 305, 300),
                                                   ('concealer', 175, 300),
                                                   ('bb cream', 135, 300),
                                                   ('cc cream', 120, 0),
                                                   ('sponge', 65, 11),
                                                   ('shampoo', 199, 300),
                                                   ('gel', 79, 10),
                                                   ('sponge for body', 35, 50),
                                                   ('robe', 199, 300),
                                                   ('mask for the face', 33, 90),
                                                   ('gel polish', 80, 213),
                                                   ('scrunchy', 50, 1000);


CREATE TABLE IF NOT EXISTS users (
                                     id INTEGER NOT NULL PRIMARY KEY,
                                     username text unique,
                                     email text,
                                     role text,
                                     users_num int,
                                     users_fk INT );

INSERT INTO users (id, username, email, role) values
                                                  (11, 'Katherines Suprun', 'catesupr@gmail.com', 'employee'),
                                                  (9, 'Yura Mitchevich', 'yuramit@gmail.com', 'employee'),
                                                  (8, 'Daria Yajenko', 'yajenkoya@gmail.com', 'employee'),
                                                  (7, 'Viorika Mirish', 'vio@gmail.com', 'accountant'),
                                                  (6, 'Irina Jabovna', 'jopashniza@gmail.com', 'cleaner'),
                                                  (5, 'Marshall Rocosovskiy', 'rococo@gmail.com', 'employee'),
                                                  (4, 'Polina Vasilievna', 'polisha@gmail.com', 'employee'),
                                                  (3, 'Polina Cakes', 'plishac@ke.gmail.com', 'owner'),
                                                  (2, 'Vadim Curl', 'curly@gmail.com', 'employee');


CREATE TABLE IF NOT EXISTS orders (
                                      id serial NOT NULL PRIMARY KEY,
                                      username text,
                                      total_sum bigint,
                                      orders_fk INT );

INSERT INTO orders (id, username, total_sum) values
                                                 (11, 'orders 11', 1000),
                                                 (1, 'orders 11', 899),
                                                 (3, 'orders 11', 590),
                                                 (5, 'orders 11', 780),
                                                 (4, 'orders 11', 100),
                                                 (7, 'orders 11', 1400);

CREATE TABLE IF NOT EXISTS customers (
                                         id INTEGER NOT NULL PRIMARY KEY,  --(совпадать с сериал Юзера)
                                         username text,
                                         surname text,
                                         phone VARCHAR(20) NOT NULL UNIQUE,
                                         customers_id INT,
                                         customers_fk INT);

INSERT INTO customers (id, username, surname, phone) values
                                                         (2, 'Vadim', 'Curl', 1234567),
                                                         (3, 'Polina', 'Cakes', 7654321),
                                                         (4, 'Polina', 'Vasilievna', 7896327),
                                                         (5, 'Marshall', 'Rocosovskiy', 5412307),
                                                         (6, 'Irina', 'Jabovna', 7854130),
                                                         (7, 'Viorika', 'Mirish', 1258964),
                                                         (8, 'Daria', 'Yajenko', 8674913),
                                                         (9, 'Yura', 'Mitchevich', 8003275),
                                                         (11, 'Katherines', 'Suprun', 0123856);


CREATE TABLE IF NOT EXISTS orders_details (
                                              id INTEGER PRIMARY KEY,
                                              time_placed date,
                                              comment text,
                                              time_updated date );


INSERT INTO orders_details (id, time_placed, comment, time_updated) values
                                                                        (1, '2008-11-11', 'delivered', '2008-11-15'),
                                                                        (7, '2023-07-09', 'on way', '2023-07-10'),
                                                                        (11, '2023-06-09', 'on way', '2023-06-10'),
                                                                        (3, '2019-03-02', 'delivered', '2019-03-04'),
                                                                        (5, '2023-05-29', 'package', '2023-05-31'),
                                                                        (4, '2023-01-28', 'on way', '2023-01-30');


CREATE TABLE IF NOT EXISTS products_customers (
    products_id int REFERENCES customers(id),
    customers_id int REFERENCES products(id),
    CONSTRAINT products_customers_pk
    PRIMARY KEY (products_id, customers_id)
    );

CREATE TABLE IF NOT EXISTS products_orders (
    orders_id int REFERENCES products(id),
    products_id int REFERENCES orders(id),
    CONSTRAINT products_orders_pk
    PRIMARY KEY (orders_id, products_id)
    );

CREATE TABLE IF NOT EXISTS orders_orders_details (
    orders_details_id int REFERENCES orders_details(id),
    orders_id int REFERENCES orders(id),
    CONSTRAINT orders_o_details_pk
    PRIMARY KEY (orders_details_id, orders_id)
    );


ALTER TABLE users ADD CONSTRAINT users_fk FOREIGN KEY (users_fk) REFERENCES orders(id);
ALTER TABLE users ADD CONSTRAINT users_id FOREIGN KEY (users_fk) REFERENCES customers(id);

ALTER TABLE orders ADD CONSTRAINT orders_fk FOREIGN KEY (orders_fk) REFERENCES users(id);
ALTER TABLE orders ADD CONSTRAINT orders_id FOREIGN KEY (orders_fk) REFERENCES products(id);

ALTER TABLE customers ADD CONSTRAINT customers_id FOREIGN KEY (customers_id) REFERENCES orders(id);
ALTER TABLE customers ADD CONSTRAINT customers_fk FOREIGN KEY (customers_id) REFERENCES orders_details(id);
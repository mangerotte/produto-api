INSERT INTO user_db (login, email, phone, password) VALUES ('Ana Maria', 'ana@gmail.com', '98989898', '123')
INSERT INTO user_db (login, email, phone, password) VALUES ('Luiz', 'mangerotte@gmail.com', '97979797', '123456')
INSERT INTO user_db (login, email, phone, password) VALUES ('Cecilia', 'cecilia@gmail.com', '97486696', '123456452')
INSERT INTO user_db (login, email, phone, password) VALUES ('Eduarda', 'eduarda@gmail.com', '92887247', 'eduarda123')

INSERT INTO order_db (instant, order_status, client_id) VALUES ('2022-10-02T11:31:00Z', 1, 1)
INSERT INTO order_db (instant, order_status, client_id) VALUES ('2022-10-03T19:31:00Z', 1, 3)
INSERT INTO order_db (instant, order_status, client_id) VALUES ('2022-10-02T11:31:00Z', 2, 4)
INSERT INTO order_db (instant, order_status, client_id) VALUES ('2022-10-02T11:31:00Z', 3, 2)
INSERT INTO order_db (instant, order_status, client_id) VALUES ('2022-10-02T11:31:00Z', 4, 1)
INSERT INTO order_db (instant, order_status, client_id) VALUES ('2022-10-02T11:31:00Z', 2, 3)

INSERT INTO category_db(name) VALUES ('Computers')
INSERT INTO category_db(name) VALUES ('Eletronics')
INSERT INTO category_db(name) VALUES ('Books')

INSERT INTO product_db (name, description, price) VALUES ('The Lord of the Rings', 'Lorem ipsum dolor sit amet, consectetur.', 90.5)
INSERT INTO product_db (name, description, price) VALUES ('Smart TV', 'Nulla eu imperdiet purus. Maecenas ante.', 2190.0)
INSERT INTO product_db (name, description, price) VALUES ('Macbook Pro', 'Nam eleifend maximus tortor, at mollis.', 1250.0)
INSERT INTO product_db (name, description, price) VALUES ('PC Gamer', 'Donec aliquet odio ac rhoncus cursus.', 1200.0)
INSERT INTO product_db (name, description, price) VALUES ('Rails for Dummies', 'Cras fringilla convallis sem vel faucibus.', 100.99)

INSERT INTO product_category_db (product_id, category_id) VALUES (1, 2)
INSERT INTO product_category_db (product_id, category_id) VALUES (2, 1)
INSERT INTO product_category_db (product_id, category_id) VALUES (2, 3)
INSERT INTO product_category_db (product_id, category_id) VALUES (3, 3)
INSERT INTO product_category_db (product_id, category_id) VALUES (4, 3)
INSERT INTO product_category_db (product_id, category_id) VALUES (5, 2)


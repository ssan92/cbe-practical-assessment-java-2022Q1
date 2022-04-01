drop table if exists order_detail;
drop table if exists order_shop;
drop table if exists product;
drop table if exists shop;
drop table if exists shop_user;

-- Create tables
CREATE TABLE if not exists shop_user
(
    identification VARCHAR(15) PRIMARY KEY NOT NULL,
    user_name      VARCHAR(50),
    created_on     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if not exists shop
(
    id                   VARCHAR(10) PRIMARY KEY NOT NULL,
    shop_name            VARCHAR(50),
    category             VARCHAR(50),
    identification_owner VARCHAR(15),
    FOREIGN KEY (identification_owner) REFERENCES shop_user (identification)
);

CREATE TABLE if not exists product
(
    id      INTEGER PRIMARY KEY,
    cod     VARCHAR(50),
    name    VARCHAR(50),
    price   DOUBLE PRECISION,
    stock   INTEGER,
    id_shop VARCHAR(10),
    FOREIGN KEY (id_shop) REFERENCES shop (id)
);

CREATE TABLE if not exists order_shop
(
    id                  SERIAL,
    identification_user VARCHAR(50),
    name_user           VARCHAR(50),
    created_on          TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (identification_user) REFERENCES shop_user (identification)
);

CREATE TABLE if not exists order_detail
(
    id         SERIAL,
    order_id   INTEGER,
    product_id INTEGER,
    stock      INTEGER,
    FOREIGN KEY (order_id) REFERENCES order_shop (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);

-- Insert data test
-- USER
INSERT INTO shop_user (identification, user_name)
VALUES ('1724585763', 'Freddy Test');
INSERT INTO shop_user (identification, user_name)
VALUES ('1724585762', 'Mauricio Test');
INSERT INTO shop_user (identification, user_name)
VALUES ('1724585761', 'Tacuri Test');

-- SHOP
INSERT INTO shop (id, shop_name, category, identification_owner)
VALUES ('01', 'SuperMaxi', '01', '1724585761');
INSERT INTO shop (id, shop_name, category, identification_owner)
VALUES ('02', 'MegaMaxi', '01', '1724585762');
INSERT INTO shop (id, shop_name, category, identification_owner)
VALUES ('03', 'AKI', '01', '1724585763');
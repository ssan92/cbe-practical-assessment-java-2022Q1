CREATE TABLE stores (
   store_id BIGINT PRIMARY KEY NOT NULL,
   name VARCHAR(50),
   category VARCHAR(20) NOT NULL,
   proprietary_user_id VARCHAR(20) NOT NULL
);

CREATE TABLE users (
   user_id BIGINT PRIMARY KEY NOT NULL,
   user_name VARCHAR(50) NOT NULL,
   creation_date DATE
);
DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE IF NOT EXISTS category(category_id SERIAL PRIMARY KEY,category_name VARCHAR NOT NULL UNIQUE);
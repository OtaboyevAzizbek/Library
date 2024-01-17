DROP TABLE IF EXISTS user_table CASCADE;
CREATE TABLE IF NOT EXISTS user_table(user_id SERIAL PRIMARY KEY,username VARCHAR NOT NULL UNIQUE,password VARCHAR NOT NULL,role_name INT NOT NULL);
INSERT INTO user_table(username,password,role_name) VALUES('Admin','123',1);
INSERT INTO user_table(username,password,role_name) VALUES('User','123',2);
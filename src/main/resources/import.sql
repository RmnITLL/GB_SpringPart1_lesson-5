DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, name VARCHAR(255), score int,  PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);

-- DROP TABLE items IF EXISTS;
-- CREATE TABLE IF NOT EXISTS items (id bigserial, title VARCHAR(255), PRIMARY KEY (id));
-- INSERT INTO items (title) VALUES ('box');
USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

INSERT INTO users (username, email, password)
VALUES ('correy', 'corry@codeup.com', '$2a$12$OaTf9mPgW.RncK7PoYnciOG6su7AeNZfBGHXdkr5QePytNAOOySg.'),
       ('ethan', 'ethan@codeup.com', 'password'),
       ('evan', 'evan@codeup.com', 'password');

INSERT INTO ads (title, user_id, description)
VALUES ('Something Interesting', 1, 'You are really going to enjoy reading this'),
       ('Something Really Cool', 1, 'You guessed right, Really Cool');
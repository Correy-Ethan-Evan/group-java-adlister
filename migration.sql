USE adlister_db;

DROP TABLE IF EXISTS bondsman;
DROP TABLE IF EXISTS bounty;
DROP TABLE IF EXISTS bounty_hunter;

CREATE TABLE user
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id  INT(10) UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    UNIQUE (username)
);

CREATE TABLE bounty
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    bounty_id   INT UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    priority    INT          NOT NULL,
    risk        VARCHAR(10)  NOT NULL,
    payout      INT,
    PRIMARY KEY (id),
    FOREIGN KEY (bounty_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE role
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)
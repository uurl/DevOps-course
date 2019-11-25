CREATE TABLE people
(
    id         SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255)       NOT NULL,
    last_name  VARCHAR(255)       NOT NULL
);

CREATE TABLE user_roles
(
    id          VARCHAR(255) PRIMARY KEY,

    name        VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255)        NOT NULL,

    person_id   BIGINT              NOT NULL REFERENCES people (id)
);
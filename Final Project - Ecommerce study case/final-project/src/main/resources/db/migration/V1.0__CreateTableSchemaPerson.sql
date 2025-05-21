CREATE SCHEMA IF NOT EXISTS person;

CREATE TABLE IF NOT EXISTS person.users
(
    user_id serial NOT NULL,
    user_name character varying(15),
    user_email character varying(80),
    user_password character varying(125),
    user_handphone character varying(25),
    created_on timestamp without time zone,
    CONSTRAINT pk_user_id PRIMARY KEY (user_id),
    CONSTRAINT uq_user_email UNIQUE (user_email),
    CONSTRAINT uq_user_handphone UNIQUE (user_handphone)
);
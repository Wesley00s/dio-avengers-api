CREATE TABLE avenger
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nick        VARCHAR(255)                            NOT NULL,
    person      VARCHAR(255)                            NOT NULL,
    description VARCHAR(255),
    history     VARCHAR(255),
    CONSTRAINT pk_avenger PRIMARY KEY (id)
);

ALTER TABLE avenger
    ADD CONSTRAINT uc_avenger_nick UNIQUE (nick);
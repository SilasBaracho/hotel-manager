CREATE TABLE hotel_address (
    id_hotel_address       UUID                      PRIMARY KEY,
    id_hotel               UUID         UNIQUE       NOT NULL,
    postal_code            VARCHAR(20)               NOT NULL,
    street                 VARCHAR(255)              NOT NULL,
    complement             VARCHAR(255)              NULL,
    neighborhood           VARCHAR(255)              NOT NULL,
    locale                 VARCHAR(255)              NOT NULL,
    uf                     VARCHAR(2)                NOT NULL,
    created_at             TIMESTAMP                 NOT NULL,
    updated_at             TIMESTAMP                 NULL,
    FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel)
);

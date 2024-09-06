CREATE TABLE room (
    id_room                UUID                      PRIMARY KEY,
    id_hotel               UUID                      NOT NULL,
    price_per_night        NUMERIC(10, 2)            NOT NULL,
    room_type              VARCHAR(50)               NOT NULL,
    number_guests          INTEGER                   NOT NULL,
    floor                  INTEGER                   NOT NULL,
    room_number            VARCHAR(10)               NOT NULL,
    created_at             TIMESTAMP                 NOT NULL,
    updated_at             TIMESTAMP                 NULL,
    FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel)
);

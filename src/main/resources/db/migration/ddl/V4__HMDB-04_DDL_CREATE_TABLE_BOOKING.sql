CREATE TABLE booking (
    id_booking             UUID         PRIMARY KEY,
    id_guest               UUID         NOT NULL,
    id_room                UUID         NOT NULL,
    id_hotel               UUID         NOT NULL,
    guest_email            VARCHAR(255) NOT NULL,
    guest_phone            VARCHAR(15)  NOT NULL,
    status                 VARCHAR(50)  NOT NULL,
    check_in_date          DATE         NOT NULL,
    check_out_date         DATE         NOT NULL,
    created_at             TIMESTAMP    NOT NULL,
    updated_at             TIMESTAMP    NULL,
    FOREIGN KEY (id_room)  REFERENCES room(id_room),
    FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel)
);


CREATE TABLE hotel (
    id_hotel              UUID         PRIMARY KEY,
    name                  VARCHAR(255) NOT NULL,
    check_in_time         TIME         NOT NULL,
    check_out_time        TIME         NOT NULL,
    created_at            TIMESTAMP    NOT NULL,
    updated_at            TIMESTAMP    NULL
);
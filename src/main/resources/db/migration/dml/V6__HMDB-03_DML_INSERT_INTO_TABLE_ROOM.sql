INSERT INTO room (
    id_room, id_hotel, price_per_night, room_type, number_guests, floor, room_number, is_available, created_at, updated_at
) VALUES (
    '7d4a25d3-39fa-43b5-9f3a-734f51ebde0f', 'bff206a0-2c4e-4b71-9e3f-28dd8cb35b9e', 150.00, 'DOUBLE', 2, 1, '101', TRUE, NOW(), NULL
), (
    '893abf4e-f765-4e73-a8bb-7f6b6054876b', 'bff206a0-2c4e-4b71-9e3f-28dd8cb35b9e', 200.00, 'SUITE', 4, 2, '202', TRUE, NOW(), NULL
);

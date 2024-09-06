INSERT INTO room (
    id_room, id_hotel, price_per_night, room_type, number_guests, floor, room_number, created_at, updated_at
) VALUES (
    '7d4a25d3-39fa-43b5-9f3a-734f51ebde0f', 'bff206a0-2c4e-4b71-9e3f-28dd8cb35b9e', 150.00, 'SINGLE_ROOM', 2, 1, '101', NOW(), NULL
), (
    '893abf4e-f765-4e73-a8bb-7f6b6054876b', 'bff206a0-2c4e-4b71-9e3f-28dd8cb35b9e', 200.00, 'DOUBLE_ROOM', 4, 2, '202', NOW(), NULL
), (
   'ad03597c-a903-4fae-982f-11dd18277edd', '2d5c0e4b-444c-44b3-87fd-ba870f877595', 180.00, 'SINGLE_ROOM', 2, 1, '101', NOW(), NULL
), (
   'd31a060d-6dca-4775-874e-b68147422265', '2d5c0e4b-444c-44b3-87fd-ba870f877595', 220.50, 'DOUBLE_ROOM', 4, 2, '202', NOW(), NULL
);

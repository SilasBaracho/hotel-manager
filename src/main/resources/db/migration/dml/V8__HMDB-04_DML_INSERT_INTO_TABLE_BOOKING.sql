INSERT INTO booking (
    id_booking,
    id_guest,
    id_room,
    id_hotel,
    status,
    check_in_date,
    check_out_date,
    created_at,
    updated_at
) VALUES (
    'e23d9f5d-b5d7-4e83-8e07-fb79234304b3',  -- id_booking
    'a8c3f1b6-bc4f-4b0f-ae3d-8a39d242df39',  -- id_guest
    'ad03597c-a903-4fae-982f-11dd18277edd',  -- id_room
    '2d5c0e4b-444c-44b3-87fd-ba870f877595',  -- id_hotel
    'PENDING',                               -- status
    '2024-09-10',                            -- check_in_date
    '2024-09-15',                            -- check_out_date
    NOW(),                                   -- created_at
    NULL                                     -- updated_at
), (
    '645a54b0-d9dc-47b8-9d23-ad2498b4a52e',  -- id_booking
    'bc940bdb-f776-4336-8b1a-2addeba8378f',  -- id_guest
    'd31a060d-6dca-4775-874e-b68147422265',  -- id_room
    '2d5c0e4b-444c-44b3-87fd-ba870f877595',  -- id_hotel
    'PENDING',                               -- status
    '2024-09-10',                            -- check_in_date
    '2024-09-15',                            -- check_out_date
    NOW(),                                   -- created_at
    NULL                                     -- updated_at
);

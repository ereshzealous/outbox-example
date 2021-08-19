START TRANSACTION;

CREATE EXTENSION if not exists "uuid-ossp";

CREATE TABLE users (
    id  TEXT PRIMARY KEY DEFAULT uuid_generate_v4(),
    full_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    mobile_number TEXT NOT NULL UNIQUE,
    gender TEXT,
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE outbox (
    id  TEXT PRIMARY KEY DEFAULT uuid_generate_v4(),
    aggregate_name TEXT,
    aggregate_id TEXT,
    event_type TEXT,
    event_name TEXT,
    payload TEXT,
    created_on TIMESTAMP DEFAULT now()
);

COMMIT;
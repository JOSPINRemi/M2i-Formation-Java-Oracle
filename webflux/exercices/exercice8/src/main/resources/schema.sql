CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    total_amount VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    created_at TIMESTAMP
);
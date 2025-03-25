CREATE TABLE students_java (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    birth_date DATE NOT NULL,
    gradebook_number VARCHAR(20) UNIQUE NOT NULL
);

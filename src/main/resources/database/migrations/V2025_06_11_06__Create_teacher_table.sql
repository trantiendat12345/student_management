CREATE TABLE teacher (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    major_id BIGINT UNSIGNED DEFAULT NULL,
    full_name VARCHAR(255) NOT NULL,
    gender ENUM('Male', 'Female', 'Other'),
    date_of_birth DATE DEFAULT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE,
    national_id VARCHAR(20) DEFAULT NULL,
    address VARCHAR(255) DEFAULT NULL,
    image VARCHAR(255) DEFAULT NULL,
    status ENUM('Active', 'On leave', 'Retired', 'Resigned') NOT NULL DEFAULT 'Active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_teacher_major FOREIGN KEY (major_id) REFERENCES major(id)
    ON DELETE SET NULL
);
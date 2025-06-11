CREATE TABLE student (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    class_id BIGINT UNSIGNED DEFAULT NULL,
    full_name VARCHAR(255) NOT NULL,
    gender ENUM('Male', 'Female', 'Other'),
    date_of_birth DATE DEFAULT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE,
    national_id VARCHAR(20) DEFAULT NULL,
    address VARCHAR(255) DEFAULT NULL,
    image VARCHAR(255) DEFAULT NULL,
    academic_year VARCHAR(9) DEFAULT NULL,
    status ENUM('Enrolled', 'On leave', 'Graduated') NOT NULL DEFAULT 'Enrolled',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_student_class FOREIGN KEY (class_id) REFERENCES class(id)
    ON DELETE SET NULL
);
CREATE TABLE class (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    major_id BIGINT UNSIGNED DEFAULT NULL,
    class_name VARCHAR(50) NOT NULL,
    academic_year VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_class_major FOREIGN KEY (major_id) REFERENCES major(id)
    ON DELETE SET NULL
);
CREATE TABLE teaching (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    teacher_id BIGINT UNSIGNED DEFAULT NULL,
    subject_id BIGINT UNSIGNED DEFAULT NULL,
    semester VARCHAR(20),
    academic_year VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_teaching_teacher FOREIGN KEY (teacher_id) REFERENCES teacher(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_teaching_subject FOREIGN KEY (subject_id) REFERENCES subject(id)
    ON DELETE SET NULL
);
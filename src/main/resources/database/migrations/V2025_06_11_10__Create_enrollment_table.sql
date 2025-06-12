CREATE TABLE enrollment (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT UNSIGNED DEFAULT NULL,
    subject_id BIGINT UNSIGNED DEFAULT NULL,  -- bỏ UNIQUE ở đây
    teacher_id BIGINT UNSIGNED DEFAULT NULL,
    semester VARCHAR(20),
    academic_year VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_enrollment_student FOREIGN KEY (student_id) REFERENCES student(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_enrollment_subject FOREIGN KEY (subject_id) REFERENCES subject(id)
    ON DELETE SET NULL,
    CONSTRAINT fk_enrollment_teacher FOREIGN KEY (teacher_id) REFERENCES teacher(id)
    ON DELETE SET NULL
);
CREATE TABLE employees(
    title VARCHAR(255) NOT NULL,
    user_id INT NOT NULL UNIQUE,
    company_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (company_id) REFERENCES companies(id)
);

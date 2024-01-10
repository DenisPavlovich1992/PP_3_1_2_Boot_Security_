CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     password VARCHAR(255),
    username VARCHAR(255),
    surname VARCHAR(255),
    roles VARCHAR(255)
    );

-- Пароль test
INSERT INTO users (password, username, surname, roles) VALUES
                                                           ('$2a$10$SzkJr3Fv6TgIClvhzOiN3.ztMlddW3hiZbZG2tBWjPtbglwE3f3Wu', 'user1', 'surname1', 'ROLE_ADMIN'),
                                                           ('$2a$10$SzkJr3Fv6TgIClvhzOiN3.ztMlddW3hiZbZG2tBWjPtbglwE3f3Wu', 'user2', 'surname2', 'ROLE_USER');

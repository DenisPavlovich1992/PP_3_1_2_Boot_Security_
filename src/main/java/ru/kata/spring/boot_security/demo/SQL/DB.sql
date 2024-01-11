CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     password VARCHAR(255),
    username VARCHAR(255),
    surname VARCHAR(255),
    roles VARCHAR(255)
    );

-- Пароль adm: admin | user: user
INSERT INTO users (password, username, surname, roles) VALUES
                                                           ('$2a$10$Cua9LSzdqBv.Zdll5dSLf.gE7y1HaJ4cQIxKqmQjg6rwfsUDL149C', 'user1', 'surname1', 'ROLE_ADMIN'),
                                                           ('$2a$10$KKV8reViwo97gebUWbRrzu2YQ0.BrzU/UdgDOFnSbg10oCfKvMbxe', 'user2', 'surname2', 'ROLE_USER');

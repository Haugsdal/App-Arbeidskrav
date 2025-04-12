-- First, clean up existing data (if any) in reverse order of dependencies
DELETE FROM users;

-- Sample data for User entity
SELECT * FROM users ORDER BY id;

TRUNCATE TABLE users;
INSERT INTO users ( id, username, email, password) VALUES
    ('0', 'tester', 'testing@test.com', 'password'),
    ('1', 'malinator', 'malin@mail.com', '123'),
    ('2', 'oscarinho', 'oscar@mail.com', '234'),
    ('3', 'sarasaurus', 'sara@mail.com', '345'),
    ('4', 'bertimusprime', 'albert@mail.com', '456');

SELECT * FROM users ORDER BY id;
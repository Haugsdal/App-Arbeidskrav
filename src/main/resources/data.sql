-- First, clean up existing data (if any) in reverse order of dependencies
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
                       userid INT PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(50),
                       email_address VARCHAR(100),
                       password VARCHAR(100),
                       date_of_birth DATE

);



-- Sample data for User entity
SELECT * FROM users ORDER BY userid;

TRUNCATE TABLE users;
INSERT INTO users ( userid, first_name, last_name, email_address, password, date_of_birth) VALUES
    ('0', 'tester','tester', 'testing@test.com', 'password','1999-12-12'),
    ('1', 'malinator','tester', 'malin@mail.com', '123','1999-12-12'),
    ('2', 'oscarinho','tester', 'oscar@mail.com', '234','1999-12-12'),
    ('3', 'sarasaurus','tester', 'sara@mail.com', '345','1999-12-12'),
    ('4', 'bertimusprime','tester', 'albert@mail.com', '456','1999-12-12');

SELECT * FROM users ORDER BY userid;
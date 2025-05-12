-- First, clean up existing data (if any) in reverse order of dependencies
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
                       user_id INT PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(50),
                       email_address VARCHAR(100),
                       password VARCHAR(100),
                       date_of_birth VARCHAR(100)

);



-- Sample data for User entity
SELECT * FROM users ORDER BY user_id;

TRUNCATE TABLE users;
INSERT INTO users ( user_id, first_name, last_name, email_address, password, date_of_birth) VALUES
    ('0', 'tester','tester', 'testing@test.com', 'password','1999-12-12'),
    ('1', 'malinator','tester', 'malin@mail.com', '123','1999-12-12'),
    ('2', 'oscarinho','tester', 'oscar@mail.com', '234','1999-12-12'),
    ('3', 'sarasaurus','tester', 'sara@mail.com', '345','1999-12-12'),
    ('4', 'bertimusprime','tester', 'albert@mail.com', '456','1999-12-12');

SELECT * FROM users ORDER BY user_id;

DROP TABLE IF EXISTS activity CASCADE;

TRUNCATE TABLE activity;
CREATE TABLE activity (
                          activity_id INT PRIMARY KEY,
                          description VARCHAR(255),
                          duration INT,
                          accessibility VARCHAR(10),
                          published DATE,
                          publisher INT,
                          CONSTRAINT fk_activity FOREIGN KEY(publisher) REFERENCES users(user_id) ON DELETE CASCADE
);

INSERT INTO activity (activity_id, description, duration, accessibility, published, publisher) VALUES
    (21,'yolo',32,'true','2010-10-10',1),
    (22,'yolo',32,'true','2010-10-10',2),
    (23,'yolo',32,'true','2010-10-10',3);

SELECT * FROM activity;
-- First, clean up existing data (if any) in reverse order of dependencies
DELETE FROM app_user;

-- Sample data for User entity
INSERT INTO app_user ( id, username, email, password) VALUES
    ('1', 'malinator', 'malin@mail.com', '123'),
    ('2', 'oscarinho', 'oscar@mail.com', '234'),
    ('3', 'sarasaurus', 'sara@mail.com', '345'),
    ('4', 'bertimusprime', 'albert@mail.com', '456');
DROP TABLE IF EXISTS role;

CREATE TABLE role (
  role_id INT AUTO_INCREMENT  PRIMARY KEY,
  role_title VARCHAR(250) NOT NULL,
  role_description VARCHAR(250) NOT NULL
);

INSERT INTO role (role_title, role_description) VALUES
  ('HR Manager', 'HR Manager'),
  ('recruitment Responsable', 'Responsible of recruitment')


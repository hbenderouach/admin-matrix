DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS account;

CREATE TABLE role (
  role_id INT AUTO_INCREMENT  PRIMARY KEY,
  role_title VARCHAR(250) NOT NULL,
  role_description VARCHAR(250) NOT NULL
);

INSERT INTO role (role_title, role_description) VALUES
  ('HR Manager', 'HR Manager'),
  ('recruitment Responsable', 'Responsible of recruitment');


CREATE TABLE account (
  account_id INT AUTO_INCREMENT  PRIMARY KEY,
  account_first_name VARCHAR(250) NOT NULL,
  account_last_name VARCHAR(250) NOT NULL,
  role_id INT NOT NULL
);

INSERT INTO account (account_first_name, account_last_name,role_id) VALUES
  ('Yassine', 'Elouardi',1),
  ('Zakaria', 'El Jazouli',1),
  ('Khalid', 'Labib',2),
  ('Khalil', 'Kouiss',2),
  ('Hamza', 'Benderouach',2);
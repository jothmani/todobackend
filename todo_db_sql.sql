select * from users;

CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1;

ALTER TABLE users RENAME COLUMN id TO user_id;

ALTER TABLE users ALTER COLUMN user_id SET DEFAULT nextval('users_seq'::regclass);

ALTER SEQUENCE users_SEQ INCREMENT BY 1;




# --- !Ups

ALTER TABLE preparation_step 
    ALTER COLUMN description	varchar(4000) NOT NULL;
	
CREATE TABLE users (
    id 			serial PRIMARY KEY,
	email		varchar(255) NOT NULL
);	
	
ALTER TABLE recipe
	ADD COLUMN user_id integer NOT NULL;
ALTER TABLE recipe
	ADD FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE meal
	ADD COLUMN user_id integer NOT NULL;	
ALTER TABLE meal
	ADD FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
	
# --- !Downs

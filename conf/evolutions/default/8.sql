
# --- !Ups

ALTER TABLE preparation_step 
    ALTER COLUMN description TYPE varchar(4000);

ALTER TABLE preparation_step
   ALTER COLUMN description SET NOT NULL;
	
CREATE TABLE users (
    id 			serial PRIMARY KEY,
	email		varchar(255) NOT NULL
);	
	
ALTER TABLE recipe
	ADD COLUMN userId integer;
	
ALTER TABLE recipe
	ALTER COLUMN userId SET NOT NULL;

ALTER TABLE recipe
	ADD FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE meal
	ADD COLUMN userId integer;

ALTER TABLE meal
	ALTER COLUMN userId SET NOT NULL;	

ALTER TABLE meal
	ADD FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE;
	
# --- !Downs
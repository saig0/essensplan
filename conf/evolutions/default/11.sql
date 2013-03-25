
# --- !Ups

ALTER TABLE tag
	ADD COLUMN userId integer;

DELETE FROM tag
	WHERE userId is null;
	
ALTER TABLE tag
	ALTER COLUMN userId SET NOT NULL;

ALTER TABLE tag
	ADD FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE;
 
   
# --- !Downs
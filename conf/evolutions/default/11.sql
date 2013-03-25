
# --- !Ups

DELETE FROM tag
	WHERE userId is null;

ALTER TABLE tag
	ADD COLUMN userId integer;
	
ALTER TABLE tag
	ALTER COLUMN userId SET NOT NULL;

ALTER TABLE tag
	ADD FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE;
 
   
# --- !Downs
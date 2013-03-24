
# --- !Ups

ALTER TABLE recipe
	ADD COLUMN source varchar(255);	 
   
# --- !Downs
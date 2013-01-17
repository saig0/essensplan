
# --- !Ups

CREATE TABLE preparation_step (
    id 			integer AUTO_INCREMENT PRIMARY KEY,
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    step 		integer NOT NULL,
	description	varchar(255) NOT NULL,
	imageRef	varchar(255) NOT NULL
);
 
# --- !Downs

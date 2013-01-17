
# --- !Ups

CREATE TABLE preparation_step (
    id 			serial PRIMARY KEY,
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    step 		integer NOT NULL,
	description	varchar(255) NOT NULL,
	imageRef	varchar(255) NOT NULL
);
 
# --- !Downs

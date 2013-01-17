
# --- !Ups

CREATE TABLE ingredient (
    id 			integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    amount 		integer NOT NULL,
	unit	 	varchar(255) NOT NULL,
	name 		varchar(255) NOT NULL
);

# --- !Downs

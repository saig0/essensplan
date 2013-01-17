
# --- !Ups

CREATE TABLE meal (
    id 			integer AUTO_INCREMENT PRIMARY KEY,
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    date 		date NOT NULL
);
 
# --- !Downs

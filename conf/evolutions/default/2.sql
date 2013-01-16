
# --- !Ups

CREATE SEQUENCE ingredient_id_seq;
CREATE TABLE ingredient (
    id 			integer NOT NULL DEFAULT nextval('ingredient_id_seq'),
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    amount 		integer NOT NULL,
	unit	 	varchar(255) NOT NULL,
	name 		varchar(255) NOT NULL
);

# --- !Downs

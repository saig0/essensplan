
# --- !Ups

CREATE SEQUENCE meal_id_seq;
CREATE TABLE meal (
    id 			integer NOT NULL DEFAULT nextval('meal_id_seq'),
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    date 		date NOT NULL
);
 
# --- !Downs

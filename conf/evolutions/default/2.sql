
# --- !Ups

CREATE SEQUENCE recipe_id_seq;
CREATE TABLE recipe (
    id 			integer NOT NULL DEFAULT nextval('recipe_id_seq'),
    name 		varchar(255) NOT NULL,
	rating 		integer NOT NULL,
	imageRef 	varchar(255),
	tags 		varchar(255)
);

CREATE SEQUENCE ingredient_id_seq;
CREATE TABLE ingredient (
    id 			integer NOT NULL DEFAULT nextval('ingredient_id_seq'),
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    amount 		integer NOT NULL,
	unit	 	varchar(255) NOT NULL,
	name 		varchar(255) NOT NULL
);

CREATE SEQUENCE preparation_step_id_seq;
CREATE TABLE preparation_step (
    id 			integer NOT NULL DEFAULT nextval('preparation_step_id_seq'),
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    step 		integer NOT NULL,
	description	varchar(255) NOT NULL,
	imageRef	varchar(255) NOT NULL
);
 
# --- !Downs

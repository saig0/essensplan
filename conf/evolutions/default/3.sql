
# --- !Ups

CREATE SEQUENCE preparation_step_id_seq;
CREATE TABLE preparation_step (
    id 			integer NOT NULL DEFAULT nextval('preparation_step_id_seq'),
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    step 		integer NOT NULL,
	description	varchar(255) NOT NULL,
	imageRef	varchar(255) NOT NULL
);
 
# --- !Downs

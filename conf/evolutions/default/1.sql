
# --- !Ups

CREATE SEQUENCE recipe_id_seq;
CREATE TABLE recipe (
    id 			integer NOT NULL DEFAULT nextval('recipe_id_seq'),
    name 		varchar(255) NOT NULL,
	rating 		integer NOT NULL,
	imageRef 	varchar(255)
);

# --- !Downs

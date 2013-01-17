
# --- !Ups

CREATE TABLE recipe (
    id 			serial PRIMARY KEY,
    name 		varchar(255) NOT NULL,
	rating 		integer NOT NULL,
	imageRef 	varchar(255)
);

# --- !Downs

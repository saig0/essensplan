
# --- !Ups

CREATE TABLE recipe (
    id 			integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name 		varchar(255) NOT NULL,
	rating 		integer NOT NULL,
	imageRef 	varchar(255)
);

# --- !Downs

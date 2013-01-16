
# --- !Ups

CREATE SEQUENCE tag_id_seq;
CREATE TABLE tag (
    id 			integer NOT NULL DEFAULT nextval('tag_id_seq'),
    name 		varchar(255) NOT NULL
);

# --- !Downs

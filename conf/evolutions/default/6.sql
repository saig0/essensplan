
# --- !Ups

CREATE SEQUENCE recipe_tag_id_seq;
CREATE TABLE recipe_tag (
    id 			integer NOT NULL DEFAULT nextval('recipe_tag_id_seq'),
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    tagId 		integer NOT NULL REFERENCES tag(id) ON DELETE CASCADE
);
 
# --- !Downs
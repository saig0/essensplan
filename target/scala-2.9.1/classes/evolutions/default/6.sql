
# --- !Ups

CREATE TABLE recipe_tag (
    id 			serial PRIMARY KEY,
	recipeId	integer NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    tagId 		integer NOT NULL REFERENCES tag(id) ON DELETE CASCADE
);
 
# --- !Downs

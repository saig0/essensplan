
# --- !Ups

ALTER TABLE preparation_step 
    ALTER COLUMN description TYPE varchar(4000);

ALTER TABLE preparation_step
   ALTER COLUMN description SET NOT NULL;

# --- !Downs
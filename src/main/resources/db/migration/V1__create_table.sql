DROP TABLE IF EXISTS sample_svc.sample CASCADE;

CREATE TABLE sample_svc.sample(
   shape_id INTEGER NOT NULL,
   shape_name VARCHAR,
   number_sides INTEGER,
   shape_color VARCHAR,
   PRIMARY KEY(shape_id)
);
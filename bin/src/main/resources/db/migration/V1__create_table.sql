DROP TABLE IF EXISTS sample_svc.sample CASCADE;
CREATE SEQUENCE sample_seq;
CREATE TABLE sample_svc.sample(
   shape_id INTEGER,
   shape_name VARCHAR,
   number_sides INTEGER,
   shape_color VARCHAR,
   PRIMARY KEY(shape_id)
);
DROP SEQUENCE IF EXISTS sample_svc.sample_seq;
CREATE SEQUENCE sample_svc.sample_seq;

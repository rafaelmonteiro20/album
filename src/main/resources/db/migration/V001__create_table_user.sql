CREATE SEQUENCE IF NOT EXISTS seq_user;

CREATE TABLE IF NOT EXISTS "user" (
	id_user INT8 NOT NULL,
	name VARCHAR(80) NOT NULL,
	email VARCHAR(80) NOT NULL,
	username VARCHAR(80) NOT NULL,
	password VARCHAR(80) NOT NULL,
	create_date TIMESTAMP NOT NULL DEFAULT now(),
	
	CONSTRAINT pk_user PRIMARY KEY (id_user)
);

ALTER TABLE "user" ALTER COLUMN id_user SET DEFAULT NEXTVAL('seq_user');
CREATE UNIQUE INDEX idx_user_username ON "user" USING btree (username);

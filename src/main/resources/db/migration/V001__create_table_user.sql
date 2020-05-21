CREATE SEQUENCE IF NOT EXISTS seq_user;

CREATE TABLE IF NOT EXISTS "user" (
	id_user INT8 NOT NULL,
	email VARCHAR(80) NOT NULL,
	full_name VARCHAR(50) NOT NULL,
	user_name VARCHAR(30) NOT NULL,
	password VARCHAR(80) NOT NULL,
	creation_date TIMESTAMP NOT NULL DEFAULT now(),
	
	CONSTRAINT pk_user PRIMARY KEY (id_user)
);

ALTER TABLE "user" ALTER COLUMN id_user SET DEFAULT NEXTVAL('seq_user');
CREATE UNIQUE INDEX idx_user_user_name ON "user" USING btree (user_name);

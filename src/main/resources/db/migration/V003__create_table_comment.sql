CREATE SEQUENCE IF NOT EXISTS seq_comment;

CREATE TABLE IF NOT EXISTS comment (
	id_comment INT8 NOT NULL,
	text VARCHAR(300) NOT NULL,
	creation_date TIMESTAMP NOT NULL DEFAULT now(),
	id_photo INT8 NOT NULL,
	id_user INT8 NOT NULL, 
	
	CONSTRAINT pk_comment PRIMARY KEY (id_comment),
	CONSTRAINT fk_comment_photo FOREIGN KEY (id_photo) REFERENCES photo (id_photo),
	CONSTRAINT fk_comment_user FOREIGN KEY (id_user) REFERENCES "user" (id_user)
);

ALTER TABLE comment ALTER COLUMN id_comment SET DEFAULT NEXTVAL('seq_comment');

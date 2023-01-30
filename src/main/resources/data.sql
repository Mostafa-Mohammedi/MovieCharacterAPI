

INSERT INTO tb_characters ("fullName",alias,gender,picture,movies_id) VALUES ('Dwayne Johnson', 'The Rock','Male',lo_import('Images\TheRock.png'),1);
INSERT INTO tb_characters VALUES ('Sarah Shahi', 'Sarah','Female',lo_import('Images\Sarah.png'),1);
INSERT INTO tb_characters VALUES ('Pierce Bronsnan', 'James Bond','Male',lo_import('Images\Bond.png'),1);
INSERT INTO tb_characters VALUES ('Sam Worthington', 'Jake Sully','Male',lo_import('Images\Jack.png'),2);
INSERT INTO tb_characters VALUES ('Zoe Saldna', 'Neytri','Female',lo_import('Images\Zoe.png'),2);
INSERT INTO tb_characters VALUES ('Kate Elizabeth', 'Kate','Female',lo_import('Images\Kate.png'),2);
INSERT INTO tb_characters VALUES ('Robert Pattinson', 'Batman','Male',lo_import('Images\Batman.png'),3);
INSERT INTO tb_characters VALUES ('Zoe Isabella', 'Zoe','Female',lo_import('Images\ZIsabella.png'),3);
INSERT INTO tb_characters VALUES ('Paul Dano', 'Paul','Male',lo_import('Images\Paul.png'),3);


INSERT INTO tb_movies (title,genre,releaseYear,director,picture,trailer,franchise_id) VALUES ('Black Adam', 'Sci-Fi',2022,'Jaume Collet-Serra',lo_import('Images\BlackAdam.png'),lo_import('Images\BlackAdam.png'),3);
INSERT INTO tb_movies VALUES ('Avatar 2', 'Sci-Fi',2022,'James Cameron',lo_import('Images\Avtar.png'),lo_import('Images\BlackAdam.png'),2);
INSERT INTO tb_movies VALUES ('The Batman', 'Sci-Fi',2022,'Matt Reeves',lo_import('Images\TheBatman.png'),lo_import('Images\BlackAdam.png'),1);

INSERT INTO tb_franchise (name,description) VALUES ( 'Warner Bros', 'American Film production company');
INSERT INTO tb_franchise VALUES ('Lightstorm Entertainment', 'American indipendent film production company');
INSERT INTO tb_franchise VALUES ('New Line Cinema', 'Kate','American film production company');

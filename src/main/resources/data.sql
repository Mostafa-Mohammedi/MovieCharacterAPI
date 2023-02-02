INSERT INTO franchise (name,description) VALUES ( 'Warner Bros', 'American Film production company');
INSERT INTO franchise (name,description) VALUES ('Lightstorm Entertainment', 'American indipendent film production company');
INSERT INTO franchise (name,description) VALUES ('New Line Cinema', 'American film production company');

INSERT INTO movie (title,genre,year,director,picture,trailer,franchise_id) VALUES ('Black Adam', 'Sci-Fi','2022','Jaume Collet-Serra','https://images.hdqwalls.com/download/black-adam-4k-artwork-2021-js-2932x2932.jpg','https://www.youtube.com/watch?v=X0tOpBuYasI',3);
INSERT INTO movie (title,genre,year,director,picture,trailer,franchise_id) VALUES ('Avatar 2', 'Sci-Fi','2022','James Cameron','https://i.ytimg.com/vi/111hKlHq0W4/maxresdefault.jpg','https://www.youtube.com/watch?v=d9MyW72ELq0',2);
INSERT INTO movie (title,genre,year,director,picture,trailer,franchise_id) VALUES ('The Batman', 'Sci-Fi','2022','Matt Reeves','https://preview.redd.it/aaxeqnn7g9j61.jpg?auto=webp&s=dda96be18fe15453a99c94fb50698b17b1f70b08','https://www.youtube.com/watch?v=mqqft2x_Aa4',1);

INSERT INTO character (fullname,alias,gender,picture) VALUES ('Dwayne Johnson', 'The Rock','Male','https://www.simplemost.com/wp-content/uploads/2018/04/887815620_Dwayne-Johnson.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Sarah Shahi', 'Sarah','Female','https://www.hawtcelebs.com/wp-content/uploads/2018/05/sarah-shahi-at-2018-environmental-media-awards-in-beverly-hills-05-22-2018-1.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Pierce Bronsnan', 'James Bond','Male','https://images.amcnetworks.com/bbcamerica.com/wp-content/uploads/2020/07/Pierce-Brosnan-1.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Sam Worthington', 'Jake Sully','Male','https://www.networthlists.com/wp-content/uploads/2020/09/Sam-Worthington-Net-Worth-scaled.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Zoe Saldna', 'Neytri','Female','https://celebmafia.com/wp-content/uploads/2020/02/zoe-saldana-cadillac-celebrates-the-92nd-annual-academy-awards-5.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Kate Elizabeth', 'Kate','Female','https://c1.staticflickr.com/9/8189/8110270152_ca2d19b8ee_b.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Robert Pattinson', 'Batman','Male','https://ksassets.timeincuk.net/wp/uploads/sites/55/2019/05/Robert-Pattinson.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Zoe Isabella', 'Zoe','Female','https://www.celebplasticsurgeryonline.com/wp-content/uploads/2015/03/27.jpg');
INSERT INTO character (fullname,alias,gender,picture) VALUES ('Paul Dano', 'Paul','Male','https://vignette.wikia.nocookie.net/dcmovies/images/0/02/Paul_Dano.jpg/revision/latest?cb=20191017183813');

INSERT INTO movie_character (movie_id,character_id) VALUES (1,1);
INSERT INTO movie_character (movie_id,character_id) VALUES (2,2);
INSERT INTO movie_character (movie_id,character_id) VALUES (3,3);



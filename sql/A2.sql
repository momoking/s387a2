DROP table IF EXISTS players;

CREATE TABLE players (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
	discriminator CHAR(1) NOT NULL,
	club VARCHAR(25) DEFAULT NULL,
	batting_average int(11) unsigned DEFAULT NULL,
	bowling_average int(11) unsigned DEFAULT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO players (name, discriminator) VALUES ('Joe','P');
INSERT INTO players (name, discriminator, club) VALUES ('Isabelle',  'F', 'Five Stars');
INSERT INTO players (name, discriminator, batting_average) VALUES ('Alyssa', 'C', 50);
INSERT INTO players (name, discriminator, batting_average, bowling_average) VALUES ('David', 'B', 47, 68);


DROP TABLE IF EXISTS `persons`;

CREATE TABLE `persons` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `persons` (`id`, `name`)
VALUES
	(1,'Bob'),
	(2,'Chris'),
	(3,'Fitzgerald Hobbs'),
	(4,'Stewart Lang'),
	(5,'Iola Love'),
	(6,'Quon Fowler'),
	(7,'Aurora Mcintosh'),
	(8,'Paki Graham'),
	(9,'Sage Schmidt'),
	(10,'Noel Fox'),
	(11,'Isadora Foreman'),
	(12,'Julian Singleton'),
	(13,'Kaitlin Oneill'),
	(14,'Gloria Strickland'),
	(15,'Darryl Carver'),
	(16,'Harrison Mcfarland'),
	(17,'Basil Wallace'),
	(18,'Camilla Harrell'),
	(19,'Paki Baker'),
	(20,'Timon Clark'),
	(21,'Larissa Odom'),
	(22,'Jerome Mullins'),
	(23,'Duncan Curtis'),
	(24,'Adena Brooks'),
	(25,'Alyssa Peterson'),
	(26,'Honorato Joyce'),
	(27,'Alea Tyson'),
	(28,'Fuller Lester'),
	(29,'Lillian Osborn'),
	(30,'Howard Silva');

	
CREATE TABLE IF NOT EXISTS `persondetails` (
  `val1` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP table IF EXISTS artists;

CREATE TABLE artists (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO artists (name)
VALUES
    ('Monkey Majik'),
    ('YUI'),
    ('Tomatsu Haruka'),
    ('Aqua Timez');
    
DROP TABLE IF EXISTS album;

CREATE TABLE album (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title VARCHAR(25) DEFAULT NULL,
    artID int(11) unsigned NOT NULL,
    PRIMARY KEY (id),    
    CONSTRAINT adsad FOREIGN KEY (artID) REFERENCES artists (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO album (title, artID)
VALUES
    ('Yume Sekai', 3),
    ('Somewhere Out There',1),
    ('Westview', 1),
    ('From Me to You', 2),
    ('Because You Are You', 4),
    ('Muted Singing Flower', 4);

COMMIT; 
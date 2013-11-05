DROP table IF EXISTS players;

CREATE TABLE players (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
	discriminator CHAR(1) NOT NULL,
	club VARCHAR(25) DEFAULT NULL,
	batting_average int(11) unsigned DEFAULT NULL,
	bowling_average int(11) unsigned DEFAULT NULL,
	PRIMARY KEY (id)
);



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

COMMIT; 
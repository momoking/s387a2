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


COMMIT; 
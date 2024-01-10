CREATE TABLE IF NOT EXISTS room(
    id INT AUTO_INCREMENT PRIMARY KEY,
    capacity INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    picture VARCHAR(255) NOT NULL,
    price INT NOT NULL
);

INSERT INTO room(capacity,description,name,picture,price) VALUES(3,'trokrevetna','Soba 207','asfsafsa',102);

CREATE TABLE IF NOT EXISTS credentials(
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255),
    type_guest BIGINT
);

INSERT INTO credentials(username, password, type_guest) VALUES ('vukman','vukman00',0);

CREATE TABLE IF NOT EXISTS guest(
    jmbg VARCHAR(13) PRIMARY KEY,
    date_of_birth DATETIME NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255),
    CONSTRAINT credentials_fk FOREIGN KEY (username) REFERENCES credentials(username)
);

INSERT INTO guest(jmbg, date_of_birth, lastname, name, username) VALUES ('2106000722219','2000-06-21 12:11:59.000000','Manojlovic','Vuk','vukman');

CREATE TABLE IF NOT EXISTS promo_code(
    id INT,
    jmbg VARCHAR(13) NOT NULL,
    discount INT NOT NULL,
    used BIT,
    CONSTRAINT promoCode_pk PRIMARY KEY(id,jmbg),
    CONSTRAINT promoCode_fk FOREIGN KEY(jmbg) REFERENCES guest(jmbg)
);

INSERT INTO promo_code(id,jmbg, discount, used) VALUES (210251,'2106000722219',20,1);

CREATE TABLE IF NOT EXISTS reservation(
    id INT NOT NULL,
    jmbg VARCHAR(13) NOT NULL,
    date_from DATETIME NOT NULL,
    date_to DATETIME NOT NULL,
    email VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    CONSTRAINT reservation_pk PRIMARY KEY (id,jmbg),
    CONSTRAINT reservation_fk1 FOREIGN KEY (id) REFERENCES room(id),
    CONSTRAINT reservation_fk2 FOREIGN KEY (jmbg) REFERENCES guest(jmbg)
);

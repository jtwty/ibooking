CREATE TABLE IF NOT EXISTS student(
                                      id int AUTO_INCREMENT,
                                      password varchar(128) NOT NULL,
                                      stu_name varchar(150) NOT NULL,
                                      phone int(11) NOT NULL,
                                      email varchar(254) NOT NULL,
                                      date_joined datetime(6) NOT NULL,
                                      PRIMARY KEY (id),
                                      UNIQUE KEY stu_name(stu_name)
);

CREATE TABLE IF NOT EXISTS admin(
                                    id int NOT NULL AUTO_INCREMENT,
                                    password varchar(128) NOT NULL,
                                    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS classroom(
                                        id int NOT NULL,
                                        campus ENUM('邯郸校区', '江湾校区', '枫林校区', '张江校区'),
                                        building varchar(256) NOT NULL,
                                        PRIMARY KEY (id, campus, building)
);

CREATE TABLE IF NOT EXISTS seat (
                                    id INT PRIMARY KEY,
                                    class_id INT NOT NULL,
                                    class_campus ENUM('邯郸校区', '江湾校区', '枫林校区', '张江校区') NOT NULL,
                                    class_building VARCHAR(256) NOT NULL,
                                    FOREIGN KEY (class_id, class_campus, class_building) REFERENCES classroom(id, campus, building)
);
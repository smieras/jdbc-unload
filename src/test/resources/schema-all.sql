DROP TABLE Customer IF EXISTS;
DROP TABLE Product IF EXISTS;

CREATE TABLE Customer(
ID INTEGER PRIMARY KEY,
FirstName VARCHAR(20),
LastName VARCHAR(30),
Street VARCHAR(50),
City VARCHAR(25));

CREATE TABLE Product(
ID INTEGER PRIMARY KEY,
Name VARCHAR(30),
Price DECIMAL);

INSERT INTO Customer VALUES(0,'Laura','Steel','429| Seventh Av.','Dallas');
INSERT INTO Product VALUES(0,'Iron Iron',54);
INSERT INTO Customer VALUES(1,'Susanne','King','366 - 20th Ave.','Olten');
INSERT INTO Product VALUES(1,'Chair Shoe',248);
INSERT INTO Customer VALUES(2,'Anne','Miller','20 Upland Pl.','Lyon');
INSERT INTO Product VALUES(2,'Telephone Clock',248);
INSERT INTO Customer VALUES(3,'Michael','Clancy','542 Upland Pl.','San Francisco');
INSERT INTO Product VALUES(3,'Chair Chair',254);
INSERT INTO Customer VALUES(4,'Sylvia','Ringer','365 College Av.','Dallas');
INSERT INTO Product VALUES(4,'Ice Tea Shoe',128);
INSERT INTO Customer VALUES(5,'Laura','Miller','294 Seventh Av.','Paris');
INSERT INTO Product VALUES(5,'Clock Clock',236);
INSERT INTO Customer VALUES(6,'Laura','White','506 Upland Pl.','Palo Alto');
INSERT INTO Product VALUES(6,'Ice Tea Chair',98);
INSERT INTO Customer VALUES(7,'James','Peterson','231 Upland Pl.','San Francisco');
INSERT INTO Product VALUES(7,'Telephone Shoe',84);
INSERT INTO Customer VALUES(8,'Andrew','Miller','288 - 20th Ave.','Seattle');
INSERT INTO Product VALUES(8,'Ice Tea Clock',226);
INSERT INTO Customer VALUES(9,'James','Schneider','277 Seventh Av.','Berne');
INSERT INTO Product VALUES(9,'Clock Telephone',172);
INSERT INTO Customer VALUES(10,'Anne','Fuller','135 Upland Pl.','Dallas');
INSERT INTO Product VALUES(10,'Telephone Ice Tea',204);
INSERT INTO Customer VALUES(11,'Julia','White','412 Upland Pl.','Chicago');
INSERT INTO Product VALUES(11,'Telephone Iron',88);
INSERT INTO Customer VALUES(12,'George','Ott','381 Upland Pl.','Palo Alto');
INSERT INTO Product VALUES(12,'Clock Ice Tea',168);
INSERT INTO Customer VALUES(13,'Laura','Ringer','38 College Av.','New York');
INSERT INTO Product VALUES(13,'Telephone Clock',180);
INSERT INTO Customer VALUES(14,'Bill','Karsen','53 College Av.','Oslo');
INSERT INTO Product VALUES(14,'Telephone Iron',124);
INSERT INTO Customer VALUES(15,'Bill','Clancy','319 Upland Pl.','Seattle');
INSERT INTO Product VALUES(15,'Ice Tea Chair',94);
INSERT INTO Customer VALUES(16,'John','Fuller','195 Seventh Av.','New York');
INSERT INTO Product VALUES(16,'Ice Tea Shoe',194);
INSERT INTO Customer VALUES(17,'Laura','Ott','443 Seventh Av.','Lyon');
INSERT INTO Product VALUES(17,'Clock Ice Tea',220);
INSERT INTO Customer VALUES(18,'Sylvia','Fuller','158 - 20th Ave.','Paris');
INSERT INTO Product VALUES(18,'Chair Clock',172);
INSERT INTO Customer VALUES(19,'Susanne','Heiniger','86 - 20th Ave.','Dallas');
INSERT INTO Product VALUES(19,'Ice Tea Ice Tea',110);
INSERT INTO Customer VALUES(20,'Janet','Schneider','309 - 20th Ave.','Oslo');
INSERT INTO Product VALUES(20,'Ice Tea Telephone',200);
INSERT INTO Customer VALUES(21,'Julia','Clancy','18 Seventh Av.','Seattle');
INSERT INTO Product VALUES(21,'Chair Chair',114);
INSERT INTO Customer VALUES(22,'Bill','Ott','250 - 20th Ave.','Berne');
INSERT INTO Product VALUES(22,'Iron Iron',66);
INSERT INTO Customer VALUES(23,'Julia','Heiniger','358 College Av.','Boston');
INSERT INTO Product VALUES(23,'Shoe Chair',76);
INSERT INTO Customer VALUES(24,'James','Sommer','333 Upland Pl.','Olten');
INSERT INTO Product VALUES(24,'Chair Shoe',72);
INSERT INTO Customer VALUES(25,'Sylvia','Steel','269 College Av.','Paris');
INSERT INTO Product VALUES(25,'Shoe Shoe',162);
INSERT INTO Customer VALUES(26,'James','Clancy','195 Upland Pl.','Oslo');
INSERT INTO Product VALUES(26,'Shoe Shoe',252);
INSERT INTO Customer VALUES(27,'Bob','Sommer','509 College Av.','Seattle');
INSERT INTO Product VALUES(27,'Telephone Iron',230);
INSERT INTO Customer VALUES(28,'Susanne','White','74 - 20th Ave.','Lyon');
INSERT INTO Product VALUES(28,'Clock Iron',30);
INSERT INTO Customer VALUES(29,'Andrew','Smith','254 College Av.','New York');
INSERT INTO Product VALUES(29,'Chair Telephone',112);
INSERT INTO Customer VALUES(30,'Bill','Sommer','362 - 20th Ave.','Olten');
INSERT INTO Product VALUES(30,'Shoe Iron',232);
INSERT INTO Customer VALUES(31,'Bob','Ringer','371 College Av.','Olten');
INSERT INTO Product VALUES(31,'Ice Tea Telephone',48);
INSERT INTO Customer VALUES(32,'Michael','Ott','339 College Av.','Boston');
INSERT INTO Product VALUES(32,'Clock Iron',190);
INSERT INTO Customer VALUES(33,'Mary','King','491 College Av.','Oslo');
INSERT INTO Product VALUES(33,'Iron Chair',182);
INSERT INTO Customer VALUES(34,'Julia','May','33 Upland Pl.','Seattle');
INSERT INTO Product VALUES(34,'Chair Iron',256);
INSERT INTO Customer VALUES(35,'George','Karsen','412 College Av.','Chicago');
INSERT INTO Product VALUES(35,'Telephone Shoe',76);
INSERT INTO Customer VALUES(36,'John','Steel','276 Upland Pl.','Dallas');
INSERT INTO Product VALUES(36,'Ice Tea Iron',32);
INSERT INTO Customer VALUES(37,'Michael','Clancy','19 Seventh Av.','Dallas');
INSERT INTO Product VALUES(37,'Clock Shoe',94);
INSERT INTO Customer VALUES(38,'Andrew','Heiniger','347 College Av.','Lyon');
INSERT INTO Product VALUES(38,'Clock Ice Tea',216);
INSERT INTO Customer VALUES(39,'Mary','Karsen','202 College Av.','Chicago');
INSERT INTO Product VALUES(39,'Ice Tea Shoe',154);
INSERT INTO Customer VALUES(40,'Susanne','Miller','440 - 20th Ave.','Dallas');
INSERT INTO Product VALUES(40,'Shoe Clock',28);
INSERT INTO Customer VALUES(41,'Bill','King','546 College Av.','New York');
INSERT INTO Product VALUES(41,'Clock Ice Tea',206);
INSERT INTO Customer VALUES(42,'Robert','Ott','503 Seventh Av.','Oslo');
INSERT INTO Product VALUES(42,'Iron Chair',198);
INSERT INTO Customer VALUES(43,'Susanne','Smith','2 Upland Pl.','Dallas');
INSERT INTO Product VALUES(43,'Telephone Clock',94);
INSERT INTO Customer VALUES(44,'Sylvia','Ott','361 College Av.','New York');
INSERT INTO Product VALUES(44,'Ice Tea Ice Tea',96);
INSERT INTO Customer VALUES(45,'Janet','May','396 Seventh Av.','Oslo');
INSERT INTO Product VALUES(45,'Iron Ice Tea',180);
INSERT INTO Customer VALUES(46,'Andrew','May','172 Seventh Av.','New York');
INSERT INTO Product VALUES(46,'Ice Tea Clock',62);
INSERT INTO Customer VALUES(47,'Janet','Fuller','445 Upland Pl.','Dallas');
INSERT INTO Product VALUES(47,'Ice Tea Iron',178);
INSERT INTO Customer VALUES(48,'Robert','White','549 Seventh Av.','San Francisco');
INSERT INTO Product VALUES(48,'Clock Clock',210);
INSERT INTO Customer VALUES(49,'George','Fuller','534 - 20th Ave.','Olten');
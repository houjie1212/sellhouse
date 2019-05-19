CREATE TABLE `user_b` (
`id`  varchar(40) NOT NULL ,
`username`  varchar(50) NOT NULL ,
`mobile`  varchar(11) NOT NULL ,
`create_time`  datetime NOT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `mobile_unq_idx` (`mobile`) 
);
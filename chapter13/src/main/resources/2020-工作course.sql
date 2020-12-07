/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.28 : Database - course
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `course`;

/*Table structure for table `addusercase` */

DROP TABLE IF EXISTS `addusercase`;

CREATE TABLE `addusercase` (
  `id` int(10) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `age` varchar(30) DEFAULT NULL,
  `permission` varchar(30) DEFAULT NULL,
  `isDelete` varchar(30) DEFAULT NULL,
  `expected` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `addusercase` */

insert  into `addusercase`(`id`,`userName`,`password`,`sex`,`age`,`permission`,`isDelete`,`expected`) values (1,'wangwu2','456','1','23','1','0','1');

/*Table structure for table `getuserinfocase` */

DROP TABLE IF EXISTS `getuserinfocase`;

CREATE TABLE `getuserinfocase` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `expected` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `getuserinfocase` */

insert  into `getuserinfocase`(`id`,`expected`) values (1,'1'),(2,'22');

/*Table structure for table `getuserlistcase` */

DROP TABLE IF EXISTS `getuserlistcase`;

CREATE TABLE `getuserlistcase` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `age` varchar(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `expected` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `getuserlistcase` */

insert  into `getuserlistcase`(`id`,`userName`,`age`,`sex`,`expected`) values (1,'zhangsan','23','1','1');

/*Table structure for table `logincase` */

DROP TABLE IF EXISTS `logincase`;

CREATE TABLE `logincase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `expected` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `logincase` */

insert  into `logincase`(`id`,`userName`,`password`,`expected`) values (1,'zhangsan','123456','true'),(2,'lisi','111','false');

/*Table structure for table `updateuserinfocase` */

DROP TABLE IF EXISTS `updateuserinfocase`;

CREATE TABLE `updateuserinfocase` (
  `id` int(10) DEFAULT NULL,
  `userId` int(10) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `age` varchar(30) DEFAULT NULL,
  `permission` varchar(30) DEFAULT NULL,
  `isDelete` varchar(30) DEFAULT NULL,
  `expected` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `updateuserinfocase` */

insert  into `updateuserinfocase`(`id`,`userId`,`userName`,`sex`,`age`,`permission`,`isDelete`,`expected`) values (1,10,'aaaa','2','3','4','1','1'),(2,2,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `permission` varchar(30) DEFAULT NULL,
  `isDelete` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`,`age`,`sex`,`permission`,`isDelete`) values (1,'zhangsan','123456','23','1','1','0'),(2,'Lucy','123','25','0','1','0'),(10,'aaaa','456','3','2','4','1'),(13,'wangwu','456','23','1','1','0'),(16,'wangwu2','456','23','1','1','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

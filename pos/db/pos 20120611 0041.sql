-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.8


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pos
--

CREATE DATABASE IF NOT EXISTS pos;
USE pos;

--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `USER_NAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `USER_ID` bigint(20) unsigned NOT NULL,
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`USER_NAME`,`PASSWORD`,`USER_ID`,`ID`) VALUES 
 ('testing','testing',106,106);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `order_payments`
--

DROP TABLE IF EXISTS `order_payments`;
CREATE TABLE `order_payments` (
  `PAYMENT_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ORDER_ID` bigint(20) unsigned NOT NULL,
  `PAYMENT_AMOUNT` decimal(10,0) NOT NULL,
  `PAYMENT_TYPE_ID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`PAYMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_payments`
--

/*!40000 ALTER TABLE `order_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_payments` ENABLE KEYS */;


--
-- Definition of table `order_products`
--

DROP TABLE IF EXISTS `order_products`;
CREATE TABLE `order_products` (
  `ORDER_ID` bigint(20) NOT NULL,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `ORDER_QUANTITY` decimal(19,2) DEFAULT '0.00',
  `PRODUCT_SALE_PRICE` decimal(19,2) DEFAULT '0.00',
  `DISCOUNT` decimal(19,2) DEFAULT '0.00',
  PRIMARY KEY (`ORDER_ID`,`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_products`
--

/*!40000 ALTER TABLE `order_products` DISABLE KEYS */;
INSERT INTO `order_products` (`ORDER_ID`,`PRODUCT_ID`,`ORDER_QUANTITY`,`PRODUCT_SALE_PRICE`,`DISCOUNT`) VALUES 
 (163,1,'4.00','100.00','0.00'),
 (163,3,'1.00','121.00','0.00');
/*!40000 ALTER TABLE `order_products` ENABLE KEYS */;


--
-- Definition of table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_status`
--

/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` (`ID`,`NAME`,`DESCRIPTION`) VALUES 
 (0,NULL,NULL),
 (1,'Completed','Completed'),
 (2,'Suspended','Draft'),
 (3,'Paid','Fully Paid '),
 (4,'Shipped','Order Shipped'),
 (5,'Cancelled','Order Cancelled');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;


--
-- Definition of table `order_status_history`
--

DROP TABLE IF EXISTS `order_status_history`;
CREATE TABLE `order_status_history` (
  `ID` bigint(20) NOT NULL DEFAULT '0',
  `ORDER_ID` bigint(20) NOT NULL,
  `STATUS_ID` bigint(20) NOT NULL,
  `NOTE` varchar(45) DEFAULT NULL,
  `CREATED` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_status_history`
--

/*!40000 ALTER TABLE `order_status_history` DISABLE KEYS */;
INSERT INTO `order_status_history` (`ID`,`ORDER_ID`,`STATUS_ID`,`NOTE`,`CREATED`) VALUES 
 (1,100,1,NULL,333333333333),
 (2,100,2,NULL,444444444444);
/*!40000 ALTER TABLE `order_status_history` ENABLE KEYS */;


--
-- Definition of table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ORDER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` bigint(20) DEFAULT NULL,
  `EMPLOYEE_ID` bigint(20) NOT NULL,
  `SHIPPING_AMOUNT` decimal(19,2) DEFAULT NULL,
  `TAX_AMOUNT` decimal(19,2) DEFAULT NULL,
  `OTHER_AMOUNT` decimal(19,2) DEFAULT NULL,
  `DISCOUNT` decimal(19,2) DEFAULT NULL,
  `NOTE` varchar(100) DEFAULT NULL,
  `ORDER_DATE` bigint(20) DEFAULT NULL,
  `SHIPPING_DATE` bigint(20) DEFAULT NULL,
  `ORDER_STATUS` bigint(20) DEFAULT NULL,
  `TOTAL_AMOUNT` decimal(19,2) DEFAULT '0.00',
  `DUE_AMOUNT` decimal(19,2) DEFAULT '0.00',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`ORDER_ID`,`CUSTOMER_ID`,`EMPLOYEE_ID`,`SHIPPING_AMOUNT`,`TAX_AMOUNT`,`OTHER_AMOUNT`,`DISCOUNT`,`NOTE`,`ORDER_DATE`,`SHIPPING_DATE`,`ORDER_STATUS`,`TOTAL_AMOUNT`,`DUE_AMOUNT`) VALUES 
 (163,106,106,'100.00',NULL,NULL,'200.00','test',1339298902980,1339298902980,1,'421.00','0.00');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


--
-- Definition of table `payment_types`
--

DROP TABLE IF EXISTS `payment_types`;
CREATE TABLE `payment_types` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_types`
--

/*!40000 ALTER TABLE `payment_types` DISABLE KEYS */;
INSERT INTO `payment_types` (`ID`,`NAME`,`DESCRIPTION`) VALUES 
 (1,'Cash',NULL),
 (2,'Check',NULL),
 (3,'Bank Transfer',NULL),
 (4,'Account Payee','Debited to User Account');
/*!40000 ALTER TABLE `payment_types` ENABLE KEYS */;


--
-- Definition of table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `PAYMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` bigint(20) DEFAULT NULL,
  `PAYMENT_AMOUNT` decimal(15,2) NOT NULL,
  `PAYMENT_DATE` bigint(20) DEFAULT NULL,
  `EMPLOYEE_ID` bigint(20) DEFAULT NULL,
  `NOTE` varchar(100) DEFAULT NULL,
  `PAYMENT_TYPE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PAYMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` (`PAYMENT_ID`,`CUSTOMER_ID`,`PAYMENT_AMOUNT`,`PAYMENT_DATE`,`EMPLOYEE_ID`,`NOTE`,`PAYMENT_TYPE_ID`) VALUES 
 (15,106,'421.00',1339298895830,106,NULL,1);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;


--
-- Definition of table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_category`
--

/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` (`ID`,`NAME`,`DESCRIPTION`,`PARENT_ID`) VALUES 
 (1,'CEMENTS','Cements',0),
 (2,'ROD','Rods',0);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;


--
-- Definition of table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `LAST_PURCHASE_PRICE` decimal(10,2) DEFAULT NULL,
  `PRODUCT_CATEGORY_ID` bigint(20) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `LAST_UPDATED` bigint(20) DEFAULT NULL,
  `SALE_PRICE` decimal(10,2) DEFAULT NULL,
  `STOCK_QUANTITY` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`ID`,`NAME`,`DESCRIPTION`,`LAST_PURCHASE_PRICE`,`PRODUCT_CATEGORY_ID`,`STATUS`,`LAST_UPDATED`,`SALE_PRICE`,`STOCK_QUANTITY`) VALUES 
 (1,'ACC CEMENT 11','CEMENTS','340.00',1,2,323232232,'450.00','700.00'),
 (2,'KC SUPER','CEMENTS',NULL,1,0,3232,'1212.00','3232.00'),
 (3,'LAFARGE','Cements',NULL,1,0,3232,'121.00','2323.00'),
 (4,'TATA STEEL 10MM','ROD',NULL,2,0,3232,'2212.00','23.00'),
 (5,'TATA STEEL 12MM','ROD',NULL,2,0,323232,'32323.00','2232.00'),
 (6,'LOCAL ROD','ROD',NULL,2,0,32323,'2323.00','2232.00');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


--
-- Definition of table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`ID`,`NAME`,`DESCRIPTION`) VALUES 
 (100,'ROLE_ADMIN_EMPLOYEES','Add, Update, Delete, and Search customers'),
 (101,'ROLE_ADMIN_ITEMS','Add, Update, Delete, and Search items'),
 (102,'ROLE_ADMIN_REPORTS','View and generate reports'),
 (103,'ROLE_ADMIN_SALES','Process sales and returns'),
 (104,'ROLE_ADMIN_CONFIG','Change the store\'s configuration'),
 (105,'ROLE_ADMIN_CUSTOMERS','Add, Update, Delete, and Search customers'),
 (106,'ROLE_ADMIN_PAYMENT',NULL),
 (107,'ROLE_ADMIN_PURCHASE',NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


--
-- Definition of table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `status`
--

/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`ID`,`NAME`,`DESCRIPTION`) VALUES 
 (1,'DRAFT','Order Saved'),
 (2,'Cash Paid','Paid with Cash'),
 (3,'Credit Account','Credited to Account'),
 (4,'Check Paid','Paid By Check'),
 (5,'Exchange Paid','Paid By Exchanging'),
 (6,'Shipped','Paid And Shippied'),
 (7,'Shipping Required','Paid But Shipping Required'),
 (8,'Partial Shipping But Paid','Paid But Partially Shipped ');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;


--
-- Definition of table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `USER_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  `CREATED` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_roles`
--

/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`USER_ID`,`ROLE_ID`,`CREATED`) VALUES 
 (0,0,54454),
 (106,100,4334343434),
 (106,101,4534343),
 (106,102,344343),
 (106,103,334434),
 (106,104,443434),
 (106,105,32333333),
 (106,106,45545),
 (106,107,45454);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `MIDDLE_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `USER_NAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `PRIMARY_CELL` varchar(11) DEFAULT NULL,
  `SECONDARY_CELL` varchar(11) DEFAULT NULL,
  `ADDRESS` varchar(250) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `ZIP_CODE` varchar(8) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `COUNTRY` varchar(45) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATED` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED` bigint(20) DEFAULT NULL,
  `NOTE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`,`FIRST_NAME`,`MIDDLE_NAME`,`LAST_NAME`,`USER_NAME`,`PASSWORD`,`EMAIL`,`PRIMARY_CELL`,`SECONDARY_CELL`,`ADDRESS`,`CITY`,`ZIP_CODE`,`STATE`,`COUNTRY`,`STATUS`,`CREATED`,`LAST_MODIFIED`,`NOTE`) VALUES 
 (100,NULL,NULL,NULL,NULL,NULL,'shekher1983@gmail.com',NULL,NULL,NULL,'Ban',NULL,'','',0,1338190140901,1338190640901,NULL),
 (101,'SDSDSDSDSD',NULL,'SDSDSDSD',NULL,NULL,'DSSDSD',NULL,NULL,NULL,'',NULL,NULL,NULL,0,1337927282839,1337927282839,NULL),
 (102,'aaaaaa',NULL,'bbbbbbbb',NULL,NULL,'shikhajaiswal2008@yahoo.com',NULL,NULL,NULL,'chennai',NULL,NULL,NULL,0,1337927519412,1337927519412,NULL),
 (103,'aaaaaa',NULL,'bbbbbbbb',NULL,NULL,'shikhajaiswal2008@yahoo.com',NULL,NULL,NULL,'chennai',NULL,NULL,NULL,0,1337927633329,1337927633329,NULL),
 (104,'dddddddd',NULL,'ffffffffffffffff','ddddddd',NULL,'barathie@gmail.com','8531081565',NULL,'New Bel Road','Bangalore','600090','Karnatka','india',0,1338197285084,1338197285084,NULL),
 (105,'11111',NULL,'33333333333','111111111',NULL,'shekher1983@gmail.com','8531081565',NULL,'New Bel Road','','600090','Karnatka','india',0,1338197649364,1338198654320,'testing'),
 (106,'chandra',NULL,'kumar','testing','testing','shikhajaiswal2008@yahoo.com','8531081565',NULL,'New Bel Road','Bangalore','600090','Karnatka','india',1,1338200457668,1338200575271,'testing'),
 (107,'chandra',NULL,'bbbbbbbb','111111111',NULL,'shekher1983','8531081565',NULL,'New Bel Road','Bangalore','600090','Karnatka','india',0,1338549962981,1338549962981,'dsssssssssss');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

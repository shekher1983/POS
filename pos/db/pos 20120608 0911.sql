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
  `USER_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `order_payments`
--

DROP TABLE IF EXISTS `order_payments`;
CREATE TABLE `order_payments` (
  `ORDER_ID` bigint(20) unsigned NOT NULL,
  `PAYMENT_ID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`ORDER_ID`,`PAYMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_payments`
--

/*!40000 ALTER TABLE `order_payments` DISABLE KEYS */;
INSERT INTO `order_payments` (`ORDER_ID`,`PAYMENT_ID`) VALUES 
 (157,12),
 (158,13);
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
 (100,100,'1.00','12000.00','0.00'),
 (100,101,'2.00','200.00','0.00'),
 (143,1,'1.00','100.00','0.00'),
 (144,1,'2.00','100.00','0.00'),
 (144,4,'1.00','2212.00','0.00'),
 (145,1,'100.00','400.00','0.00'),
 (145,4,'10.00','2212.00','0.00'),
 (146,1,'100.00','400.00','0.00'),
 (146,4,'10.00','2212.00','0.00'),
 (146,6,'1.00','2323.00','0.00'),
 (147,1,'100.00','400.00','0.00'),
 (147,4,'10.00','2212.00','0.00'),
 (147,5,'10.00','32323.00','0.00'),
 (147,6,'1.00','2323.00','0.00'),
 (148,1,'1.00','100.00','0.00'),
 (148,3,'1.00','121.00','0.00'),
 (148,4,'1.00','2212.00','0.00'),
 (148,6,'1.00','2323.00','0.00'),
 (149,1,'1.00','100.00','0.00'),
 (149,4,'1.00','2212.00','0.00'),
 (149,5,'1.00','32323.00','0.00'),
 (156,1,'3.00','100.00','0.00'),
 (156,4,'1.00','2212.00','0.00'),
 (157,1,'2.00','100.00','0.00'),
 (157,4,'1.00','2212.00','0.00'),
 (157,5,'1.00','32323.00','0.00'),
 (158,1,'1.00','100.00','0.00'),
 (158,3,'1.00','121.00','0.00'),
 (158,4,'1.00','2212.00','0.00'),
 (158,5,'1.00','32323.00','0.00'),
 (158,6,'1.00','2323.00','0.00');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_status`
--

/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` (`ID`,`NAME`,`DESCRIPTION`) VALUES 
 (1,NULL,'23232');
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
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`ORDER_ID`,`CUSTOMER_ID`,`EMPLOYEE_ID`,`SHIPPING_AMOUNT`,`TAX_AMOUNT`,`OTHER_AMOUNT`,`DISCOUNT`,`NOTE`,`ORDER_DATE`,`SHIPPING_DATE`,`ORDER_STATUS`,`TOTAL_AMOUNT`,`DUE_AMOUNT`) VALUES 
 (121,106,106,'300.00',NULL,NULL,'400.00','sdsdsdsdsdsdsdsd',1338976661647,1338976661647,1,'0.00','0.00'),
 (124,106,106,'300.00',NULL,NULL,'400.00','hhhhhh',1338977089145,1338977089145,1,'0.00','0.00'),
 (125,106,106,'300.00',NULL,NULL,'400.00','hhhhhh',1338977175804,1338977175804,1,'0.00','0.00'),
 (126,106,106,'300.00',NULL,NULL,'400.00','hhhhhh',1338977257387,1338977257387,1,'0.00','0.00'),
 (127,106,106,'200.00',NULL,NULL,'400.00',NULL,1338978810790,1338978810790,2,'0.00','0.00'),
 (143,106,106,'200.00',NULL,NULL,'50.00','testing',1339018179271,1339018179271,1,'0.00','0.00'),
 (144,106,106,'200.00',NULL,NULL,'100.00','testing',1339084372982,1339084372982,1,'0.00','0.00'),
 (145,106,106,'300.00',NULL,NULL,'400.00','NEW TESTING WITH PAYMENTS',1339085509471,1339085509471,1,'62020.00','62020.00'),
 (146,106,106,'300.00',NULL,NULL,'400.00','NEW TESTING WITH PAYMENTS',1339085692260,1339085692260,1,'64343.00','64343.00'),
 (147,106,106,'300.00',NULL,NULL,'400.00','NEW TESTING WITH new PAYMENTS',1339085790482,1339085790482,1,'387573.00','300000.00'),
 (148,106,106,'200.00',NULL,NULL,'400.00','testing finally',1339088153489,1339088153489,1,'4556.00','4000.00'),
 (149,106,106,'200.00',NULL,NULL,'400.00','final testing hope',1339088468791,1339088468791,1,'34435.00','20000.00'),
 (156,106,106,'200.00',NULL,NULL,'100.00','hope works',1339095374557,1339095374557,1,'2612.00','2612.00'),
 (157,106,106,'100.00',NULL,NULL,'300.00','final testing  with payments',1339097596781,1339097596781,1,'34535.00','30000.00'),
 (158,106,106,'100.00',NULL,NULL,'300.00','',1339098326933,1339098326933,1,'36879.00','10000.00');
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
 (1,'Cash',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` (`PAYMENT_ID`,`CUSTOMER_ID`,`PAYMENT_AMOUNT`,`PAYMENT_DATE`,`EMPLOYEE_ID`,`NOTE`,`PAYMENT_TYPE_ID`) VALUES 
 (5,106,'3323.00',1338977282224,106,NULL,100),
 (6,106,'19000.00',1338977283846,106,NULL,100),
 (7,106,'10000.00',1338977284911,106,NULL,100),
 (8,106,'512.00',1339084379515,106,NULL,100),
 (9,106,'87573.00',1339085795032,106,NULL,100),
 (10,106,'556.00',1339088157844,106,NULL,100),
 (11,106,'14435.00',1339088475732,106,NULL,100),
 (12,0,'4535.00',1339097506802,0,NULL,1),
 (13,0,'26879.00',1339098055478,106,NULL,1);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;


--
-- Definition of table `phppos_app_config`
--

DROP TABLE IF EXISTS `phppos_app_config`;
CREATE TABLE `phppos_app_config` (
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_app_config`
--

/*!40000 ALTER TABLE `phppos_app_config` DISABLE KEYS */;
INSERT INTO `phppos_app_config` (`key`,`value`) VALUES 
 ('address','123 Nowhere street'),
 ('company','PHP Point Of Sale, Inc'),
 ('default_tax_rate','8'),
 ('email','admin@phppointofsale.com'),
 ('fax',''),
 ('phone','555-555-5555'),
 ('return_policy','Test'),
 ('version','10.0'),
 ('website','');
/*!40000 ALTER TABLE `phppos_app_config` ENABLE KEYS */;


--
-- Definition of table `phppos_customers`
--

DROP TABLE IF EXISTS `phppos_customers`;
CREATE TABLE `phppos_customers` (
  `person_id` int(10) NOT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `taxable` int(1) NOT NULL DEFAULT '1',
  `deleted` int(1) NOT NULL DEFAULT '0',
  UNIQUE KEY `account_number` (`account_number`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `phppos_customers_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `phppos_people` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_customers`
--

/*!40000 ALTER TABLE `phppos_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_customers` ENABLE KEYS */;


--
-- Definition of table `phppos_employees`
--

DROP TABLE IF EXISTS `phppos_employees`;
CREATE TABLE `phppos_employees` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `person_id` int(10) NOT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  UNIQUE KEY `username` (`username`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `phppos_employees_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `phppos_people` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_employees`
--

/*!40000 ALTER TABLE `phppos_employees` DISABLE KEYS */;
INSERT INTO `phppos_employees` (`username`,`password`,`person_id`,`deleted`) VALUES 
 ('admin','439a6de57d475c1a0ba9bcb1c39f0af6',1,0);
/*!40000 ALTER TABLE `phppos_employees` ENABLE KEYS */;


--
-- Definition of table `phppos_inventory`
--

DROP TABLE IF EXISTS `phppos_inventory`;
CREATE TABLE `phppos_inventory` (
  `trans_id` int(11) NOT NULL AUTO_INCREMENT,
  `trans_items` int(11) NOT NULL DEFAULT '0',
  `trans_user` int(11) NOT NULL DEFAULT '0',
  `trans_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `trans_comment` text NOT NULL,
  `trans_inventory` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trans_id`),
  KEY `phppos_inventory_ibfk_1` (`trans_items`),
  KEY `phppos_inventory_ibfk_2` (`trans_user`),
  CONSTRAINT `phppos_inventory_ibfk_1` FOREIGN KEY (`trans_items`) REFERENCES `phppos_items` (`item_id`),
  CONSTRAINT `phppos_inventory_ibfk_2` FOREIGN KEY (`trans_user`) REFERENCES `phppos_employees` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_inventory`
--

/*!40000 ALTER TABLE `phppos_inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_inventory` ENABLE KEYS */;


--
-- Definition of table `phppos_items`
--

DROP TABLE IF EXISTS `phppos_items`;
CREATE TABLE `phppos_items` (
  `name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `cost_price` double(15,2) NOT NULL,
  `unit_price` double(15,2) NOT NULL,
  `quantity` double(15,2) NOT NULL DEFAULT '0.00',
  `reorder_level` double(15,2) NOT NULL DEFAULT '0.00',
  `item_id` int(10) NOT NULL AUTO_INCREMENT,
  `allow_alt_description` tinyint(1) NOT NULL,
  `is_serialized` tinyint(1) NOT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `item_number` (`item_number`),
  KEY `phppos_items_ibfk_1` (`supplier_id`),
  CONSTRAINT `phppos_items_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `phppos_suppliers` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_items`
--

/*!40000 ALTER TABLE `phppos_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_items` ENABLE KEYS */;


--
-- Definition of table `phppos_items_taxes`
--

DROP TABLE IF EXISTS `phppos_items_taxes`;
CREATE TABLE `phppos_items_taxes` (
  `item_id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `percent` double(15,2) NOT NULL,
  PRIMARY KEY (`item_id`,`name`,`percent`),
  CONSTRAINT `phppos_items_taxes_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `phppos_items` (`item_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_items_taxes`
--

/*!40000 ALTER TABLE `phppos_items_taxes` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_items_taxes` ENABLE KEYS */;


--
-- Definition of table `phppos_modules`
--

DROP TABLE IF EXISTS `phppos_modules`;
CREATE TABLE `phppos_modules` (
  `name_lang_key` varchar(255) NOT NULL,
  `desc_lang_key` varchar(255) NOT NULL,
  `sort` int(10) NOT NULL,
  `module_id` varchar(255) NOT NULL,
  PRIMARY KEY (`module_id`),
  UNIQUE KEY `desc_lang_key` (`desc_lang_key`),
  UNIQUE KEY `name_lang_key` (`name_lang_key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_modules`
--

/*!40000 ALTER TABLE `phppos_modules` DISABLE KEYS */;
INSERT INTO `phppos_modules` (`name_lang_key`,`desc_lang_key`,`sort`,`module_id`) VALUES 
 ('module_config','module_config_desc',8,'config'),
 ('module_customers','module_customers_desc',1,'customers'),
 ('module_employees','module_employees_desc',7,'employees'),
 ('module_items','module_items_desc',2,'items'),
 ('module_receivings','module_receivings_desc',5,'receivings'),
 ('module_reports','module_reports_desc',3,'reports'),
 ('module_sales','module_sales_desc',6,'sales'),
 ('module_suppliers','module_suppliers_desc',4,'suppliers');
/*!40000 ALTER TABLE `phppos_modules` ENABLE KEYS */;


--
-- Definition of table `phppos_people`
--

DROP TABLE IF EXISTS `phppos_people`;
CREATE TABLE `phppos_people` (
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address_1` varchar(255) NOT NULL,
  `address_2` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `zip` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `comments` text NOT NULL,
  `person_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_people`
--

/*!40000 ALTER TABLE `phppos_people` DISABLE KEYS */;
INSERT INTO `phppos_people` (`first_name`,`last_name`,`phone_number`,`email`,`address_1`,`address_2`,`city`,`state`,`zip`,`country`,`comments`,`person_id`) VALUES 
 ('John','Doe','555-555-5555','admin@phppointofsale.com','Address 1','','','','','','',1);
/*!40000 ALTER TABLE `phppos_people` ENABLE KEYS */;


--
-- Definition of table `phppos_permissions`
--

DROP TABLE IF EXISTS `phppos_permissions`;
CREATE TABLE `phppos_permissions` (
  `module_id` varchar(255) NOT NULL,
  `person_id` int(10) NOT NULL,
  PRIMARY KEY (`module_id`,`person_id`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `phppos_permissions_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `phppos_employees` (`person_id`),
  CONSTRAINT `phppos_permissions_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `phppos_modules` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_permissions`
--

/*!40000 ALTER TABLE `phppos_permissions` DISABLE KEYS */;
INSERT INTO `phppos_permissions` (`module_id`,`person_id`) VALUES 
 ('config',1),
 ('customers',1),
 ('employees',1),
 ('items',1),
 ('receivings',1),
 ('reports',1),
 ('sales',1),
 ('suppliers',1);
/*!40000 ALTER TABLE `phppos_permissions` ENABLE KEYS */;


--
-- Definition of table `phppos_receivings`
--

DROP TABLE IF EXISTS `phppos_receivings`;
CREATE TABLE `phppos_receivings` (
  `receiving_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `supplier_id` int(10) DEFAULT NULL,
  `employee_id` int(10) NOT NULL DEFAULT '0',
  `comment` text NOT NULL,
  `receiving_id` int(10) NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`receiving_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `phppos_receivings_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `phppos_employees` (`person_id`),
  CONSTRAINT `phppos_receivings_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `phppos_suppliers` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_receivings`
--

/*!40000 ALTER TABLE `phppos_receivings` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_receivings` ENABLE KEYS */;


--
-- Definition of table `phppos_receivings_items`
--

DROP TABLE IF EXISTS `phppos_receivings_items`;
CREATE TABLE `phppos_receivings_items` (
  `receiving_id` int(10) NOT NULL DEFAULT '0',
  `item_id` int(10) NOT NULL DEFAULT '0',
  `description` varchar(30) DEFAULT NULL,
  `serialnumber` varchar(30) DEFAULT NULL,
  `line` int(3) NOT NULL,
  `quantity_purchased` int(10) NOT NULL DEFAULT '0',
  `item_cost_price` decimal(15,2) NOT NULL,
  `item_unit_price` double(15,2) NOT NULL,
  `discount_percent` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`receiving_id`,`item_id`,`line`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `phppos_receivings_items_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `phppos_items` (`item_id`),
  CONSTRAINT `phppos_receivings_items_ibfk_2` FOREIGN KEY (`receiving_id`) REFERENCES `phppos_receivings` (`receiving_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_receivings_items`
--

/*!40000 ALTER TABLE `phppos_receivings_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_receivings_items` ENABLE KEYS */;


--
-- Definition of table `phppos_sales`
--

DROP TABLE IF EXISTS `phppos_sales`;
CREATE TABLE `phppos_sales` (
  `sale_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customer_id` int(10) DEFAULT NULL,
  `employee_id` int(10) NOT NULL DEFAULT '0',
  `comment` text NOT NULL,
  `sale_id` int(10) NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `customer_id` (`customer_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `phppos_sales_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `phppos_employees` (`person_id`),
  CONSTRAINT `phppos_sales_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `phppos_customers` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_sales`
--

/*!40000 ALTER TABLE `phppos_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_sales` ENABLE KEYS */;


--
-- Definition of table `phppos_sales_items`
--

DROP TABLE IF EXISTS `phppos_sales_items`;
CREATE TABLE `phppos_sales_items` (
  `sale_id` int(10) NOT NULL DEFAULT '0',
  `item_id` int(10) NOT NULL DEFAULT '0',
  `description` varchar(30) DEFAULT NULL,
  `serialnumber` varchar(30) DEFAULT NULL,
  `line` int(3) NOT NULL DEFAULT '0',
  `quantity_purchased` double(15,2) NOT NULL DEFAULT '0.00',
  `item_cost_price` decimal(15,2) NOT NULL,
  `item_unit_price` double(15,2) NOT NULL,
  `discount_percent` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sale_id`,`item_id`,`line`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `phppos_sales_items_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `phppos_items` (`item_id`),
  CONSTRAINT `phppos_sales_items_ibfk_2` FOREIGN KEY (`sale_id`) REFERENCES `phppos_sales` (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_sales_items`
--

/*!40000 ALTER TABLE `phppos_sales_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_sales_items` ENABLE KEYS */;


--
-- Definition of table `phppos_sales_items_taxes`
--

DROP TABLE IF EXISTS `phppos_sales_items_taxes`;
CREATE TABLE `phppos_sales_items_taxes` (
  `sale_id` int(10) NOT NULL,
  `item_id` int(10) NOT NULL,
  `line` int(3) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `percent` double(15,2) NOT NULL,
  PRIMARY KEY (`sale_id`,`item_id`,`line`,`name`,`percent`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `phppos_sales_items_taxes_ibfk_1` FOREIGN KEY (`sale_id`) REFERENCES `phppos_sales_items` (`sale_id`),
  CONSTRAINT `phppos_sales_items_taxes_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `phppos_sales_items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_sales_items_taxes`
--

/*!40000 ALTER TABLE `phppos_sales_items_taxes` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_sales_items_taxes` ENABLE KEYS */;


--
-- Definition of table `phppos_sessions`
--

DROP TABLE IF EXISTS `phppos_sessions`;
CREATE TABLE `phppos_sessions` (
  `session_id` varchar(40) NOT NULL DEFAULT '0',
  `ip_address` varchar(16) NOT NULL DEFAULT '0',
  `user_agent` varchar(50) NOT NULL,
  `last_activity` int(10) unsigned NOT NULL DEFAULT '0',
  `user_data` text NOT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_sessions`
--

/*!40000 ALTER TABLE `phppos_sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_sessions` ENABLE KEYS */;


--
-- Definition of table `phppos_suppliers`
--

DROP TABLE IF EXISTS `phppos_suppliers`;
CREATE TABLE `phppos_suppliers` (
  `person_id` int(10) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  UNIQUE KEY `account_number` (`account_number`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `phppos_suppliers_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `phppos_people` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phppos_suppliers`
--

/*!40000 ALTER TABLE `phppos_suppliers` DISABLE KEYS */;
/*!40000 ALTER TABLE `phppos_suppliers` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`ID`,`NAME`,`DESCRIPTION`,`LAST_PURCHASE_PRICE`,`PRODUCT_CATEGORY_ID`,`STATUS`,`LAST_UPDATED`,`SALE_PRICE`,`STOCK_QUANTITY`) VALUES 
 (1,'ACC CEMENT 11','CEMENTS',NULL,1,0,323,'100.00','322332.00'),
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
 (100,'ROLE_ADMIN_CUSTOMER','Add, Update, Delete, and Search customers'),
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

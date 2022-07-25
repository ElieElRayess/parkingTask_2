-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 30, 2022 at 10:36 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking_task`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `cc_info` varchar(250) DEFAULT NULL,
  `car_type` varchar(5) NOT NULL,
  `main_parking` varchar(20) NOT NULL,
  `parking_slot` int(4) NOT NULL,
  `arrival_time` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `main_parking` (`main_parking`),
  KEY `parking_slot` (`parking_slot`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
-- --------------------------------------------------------
--
-- Table structure for table `client_key`
--
DROP TABLE IF EXISTS `client_key`;
CREATE TABLE IF NOT EXISTS `client_key` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `public_key` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
-- --------------------------------------------------------



--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
CREATE TABLE IF NOT EXISTS `parking` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price_per_hour` float DEFAULT NULL,
  `fixed_price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


--
-- Table structure for table `parking_slot`
--
DROP TABLE IF EXISTS `parking_slot`;
CREATE TABLE IF NOT EXISTS `parking_slot` (
  `main_parking` varchar(20) NOT NULL,
  `slot_id` int(4) NOT NULL AUTO_INCREMENT,
  `type` varchar(5) NOT NULL,
  `isFree` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`slot_id`),
  KEY `main_parking` (`main_parking`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

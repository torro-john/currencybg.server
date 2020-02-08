SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE `cbg_apikeys` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `KEY_VALUE` varchar(64) NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT '1' COMMENT '0-Active, 1-Inactive',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cbg_currencies` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(10) NOT NULL,
  `RATIO` int(11) NOT NULL,
  `BUY` varchar(10) NOT NULL,
  `SELL` varchar(10) NOT NULL,
  `DATE` datetime NOT NULL,
  `SOURCE` int(3) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `date_idx` (`DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cbg_sources` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOURCE_ID` int(3) NOT NULL,
  `NAME` varchar(150) NOT NULL,
  `STATUS` int(1) NOT NULL DEFAULT '1' COMMENT '0-Active/1-Inactive',
  `UPDATE_PERIOD` int(11) NOT NULL DEFAULT '360' COMMENT 'Update interval in seconds',
  `UPDATE_RESTRICTIONS` varchar(1000) DEFAULT '{ 	"wdNotBefore": "06:00", 	"wdNotAfter": "23:00", 	"weNotBefore": "06:00", 	"weNotAfter": "23:00",	 	"weekends": true, 	"sundays": false }',
  `LAST_UPDATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

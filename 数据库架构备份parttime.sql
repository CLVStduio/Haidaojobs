-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: parttime
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(10) NOT NULL,
  `permissions` int(2) NOT NULL,
  `adminPassword` char(33) NOT NULL,
  `adminPhoneNo` char(120) NOT NULL,
  `securityKey` char(33) NOT NULL,
  `complementKey` char(33) NOT NULL,
  `headPortritPath` varchar(23) NOT NULL DEFAULT 'headPortrait.png',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ();
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` char(12) NOT NULL,
  `code` char(6) NOT NULL,
  `time` char(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES ();
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signin_2017`
--

DROP TABLE IF EXISTS `my_signin_2017`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signin_2017` (
  `signIn_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` char(2) NOT NULL,
  `signIn_date` char(10) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`signIn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signin_2017`
--

LOCK TABLES `my_signin_2017` WRITE;
/*!40000 ALTER TABLE `my_signin_2017` DISABLE KEYS */;
INSERT INTO `my_signin_2017` VALUES ();
/*!40000 ALTER TABLE `my_signin_2017` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signin_2018`
--

DROP TABLE IF EXISTS `my_signin_2018`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signin_2018` (
  `signIn_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` char(2) NOT NULL,
  `signIn_date` char(10) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`signIn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signin_2018`
--

LOCK TABLES `my_signin_2018` WRITE;
/*!40000 ALTER TABLE `my_signin_2018` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_signin_2018` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signin_2019`
--

DROP TABLE IF EXISTS `my_signin_2019`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signin_2019` (
  `signIn_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` char(2) NOT NULL,
  `signIn_date` char(10) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`signIn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signin_2019`
--

LOCK TABLES `my_signin_2019` WRITE;
/*!40000 ALTER TABLE `my_signin_2019` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_signin_2019` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signin_coumulative`
--

DROP TABLE IF EXISTS `my_signin_coumulative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signin_coumulative` (
  `comulativeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `comulativeDay` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`comulativeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signin_coumulative`
--

LOCK TABLES `my_signin_coumulative` WRITE;
/*!40000 ALTER TABLE `my_signin_coumulative` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_signin_coumulative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signingift_2017`
--

DROP TABLE IF EXISTS `my_signingift_2017`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signingift_2017` (
  `signIn_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` char(3) NOT NULL,
  `signInGift_date` char(9) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`signIn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signingift_2017`
--

LOCK TABLES `my_signingift_2017` WRITE;
/*!40000 ALTER TABLE `my_signingift_2017` DISABLE KEYS */;
INSERT INTO `my_signingift_2017` VALUES ();
/*!40000 ALTER TABLE `my_signingift_2017` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signingift_2018`
--

DROP TABLE IF EXISTS `my_signingift_2018`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signingift_2018` (
  `signIn_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` char(3) NOT NULL,
  `signInGift_date` char(9) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`signIn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signingift_2018`
--

LOCK TABLES `my_signingift_2018` WRITE;
/*!40000 ALTER TABLE `my_signingift_2018` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_signingift_2018` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_signingift_2019`
--

DROP TABLE IF EXISTS `my_signingift_2019`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_signingift_2019` (
  `signIn_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` char(3) NOT NULL,
  `signInGift_date` char(9) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`signIn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_signingift_2019`
--

LOCK TABLES `my_signingift_2019` WRITE;
/*!40000 ALTER TABLE `my_signingift_2019` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_signingift_2019` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parttime_Information`
--

DROP TABLE IF EXISTS `parttime_Information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parttime_Information` (
  `partTimeId` int(11) NOT NULL AUTO_INCREMENT,
  `photoName` varchar(30) NOT NULL DEFAULT 'default.jpg',
  `type` int(3) NOT NULL,
  `settlementMethod` varchar(20) NOT NULL,
  `salary` varchar(20) NOT NULL,
  `deadline` varchar(30) NOT NULL,
  `workDate` varchar(30) NOT NULL,
  `locationProvince` varchar(9) NOT NULL,
  `locationCity` varchar(20) NOT NULL,
  `locationDistrict` varchar(20) NOT NULL,
  `locationDetailed` varchar(100) NOT NULL,
  `companyId` int(11) NOT NULL,
  `needNumber` varchar(10) NOT NULL,
  `numberOfApplicants` varchar(10) NOT NULL,
  `claim` varchar(200) NOT NULL,
  `jobDescription` varchar(300) NOT NULL,
  `lastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `partTimeStatus` int(3) NOT NULL,
  `partTimeQualification` int(3) NOT NULL,
  `title` varchar(30) NOT NULL,
  `publisherId` int(11) NOT NULL,
  PRIMARY KEY (`partTimeId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parttime_Information`
--

LOCK TABLES `parttime_Information` WRITE;
/*!40000 ALTER TABLE `parttime_Information` DISABLE KEYS */;
INSERT INTO `parttime_Information` VALUES ();
/*!40000 ALTER TABLE `parttime_Information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parttime_answer`
--

DROP TABLE IF EXISTS `parttime_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parttime_answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT,
  `problemId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `answerContent` varchar(200) NOT NULL,
  PRIMARY KEY (`answerId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parttime_answer`
--

LOCK TABLES `parttime_answer` WRITE;
/*!40000 ALTER TABLE `parttime_answer` DISABLE KEYS */;
INSERT INTO `parttime_answer` VALUES ();
/*!40000 ALTER TABLE `parttime_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parttime_description`
--

DROP TABLE IF EXISTS `parttime_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parttime_description` (
  `descriptionId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(16) NOT NULL,
  `content` varchar(200) NOT NULL,
  `partTimeId` int(11) NOT NULL,
  PRIMARY KEY (`descriptionId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parttime_description`
--

LOCK TABLES `parttime_description` WRITE;
/*!40000 ALTER TABLE `parttime_description` DISABLE KEYS */;
INSERT INTO `parttime_description` VALUES ();
/*!40000 ALTER TABLE `parttime_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parttime_problem`
--

DROP TABLE IF EXISTS `parttime_problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parttime_problem` (
  `problemId` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(100) NOT NULL,
  `type` int(3) NOT NULL,
  `content` varchar(200) NOT NULL,
  `partTimeId` int(11) NOT NULL,
  PRIMARY KEY (`problemId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parttime_problem`
--

LOCK TABLES `parttime_problem` WRITE;
/*!40000 ALTER TABLE `parttime_problem` DISABLE KEYS */;
INSERT INTO `parttime_problem` VALUES ();
/*!40000 ALTER TABLE `parttime_problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parttime_registration`
--

DROP TABLE IF EXISTS `parttime_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parttime_registration` (
  `registration` int(11) NOT NULL AUTO_INCREMENT,
  `registrationType` int(3) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  `parttimeId` int(11) NOT NULL,
  PRIMARY KEY (`registration`),
  UNIQUE KEY `uc_PersonId` (`userId`,`parttimeId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parttime_registration`
--

LOCK TABLES `parttime_registration` WRITE;
/*!40000 ALTER TABLE `parttime_registration` DISABLE KEYS */;
INSERT INTO `parttime_registration` VALUES ();
/*!40000 ALTER TABLE `parttime_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL DEFAULT 'user666',
  `userPassword` char(33) NOT NULL,
  `userPhoneNo` char(12) NOT NULL,
  `securityKey` char(33) NOT NULL,
  `complementKey` char(33) NOT NULL,
  `registeredDate` date NOT NULL,
  `headPortraitName` varchar(23) NOT NULL DEFAULT 'headPortrait.png',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ();
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_Identity`
--

DROP TABLE IF EXISTS `user_Identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_Identity` (
  `identityId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` char(3) NOT NULL,
  `auditType` int(3) NOT NULL,
  `idNum` char(19) NOT NULL,
  `dateBirth` char(11) NOT NULL,
  `adminId` int(11) DEFAULT NULL,
  PRIMARY KEY (`identityId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_Identity`
--

LOCK TABLES `user_Identity` WRITE;
/*!40000 ALTER TABLE `user_Identity` DISABLE KEYS */;
INSERT INTO `user_Identity` VALUES ();
/*!40000 ALTER TABLE `user_Identity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_Information`
--

DROP TABLE IF EXISTS `user_Information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_Information` (
  `InformationId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` char(3) DEFAULT '男',
  `height` char(4) DEFAULT '170',
  `dateBirth` char(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT '***@clvstudio.cn',
  PRIMARY KEY (`InformationId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_Information`
--

LOCK TABLES `user_Information` WRITE;
/*!40000 ALTER TABLE `user_Information` DISABLE KEYS */;
INSERT INTO `user_Information` VALUES ();
/*!40000 ALTER TABLE `user_Information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_resume_skill`
--

DROP TABLE IF EXISTS `user_resume_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_resume_skill` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `skill_content` varchar(30) NOT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_resume_skill`
--

LOCK TABLES `user_resume_skill` WRITE;
/*!40000 ALTER TABLE `user_resume_skill` DISABLE KEYS */;
INSERT INTO `user_resume_skill` VALUES ();
/*!40000 ALTER TABLE `user_resume_skill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-05  4:00:02

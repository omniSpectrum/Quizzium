-- MySQL dump 10.14  Distrib 5.5.36-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: quizziumdb2
-- ------------------------------------------------------
-- Server version	5.5.36-MariaDB-log

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
-- Current Database: `quizziumdb2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `quizziumdb2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `quizziumdb2`;

--
-- Table structure for table `Alternative`
--

DROP TABLE IF EXISTS `Alternative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alternative` (
  `alternativeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `description` text NOT NULL,
  `Question_questionId` int(11) NOT NULL,
  PRIMARY KEY (`alternativeId`),
  KEY `fk_Alternative_Question1_idx` (`Question_questionId`),
  CONSTRAINT `fk_Alternative_Question1` FOREIGN KEY (`Question_questionId`) REFERENCES `Question` (`questionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alternative`
--

LOCK TABLES `Alternative` WRITE;
/*!40000 ALTER TABLE `Alternative` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alternative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CorrectAnswer`
--

DROP TABLE IF EXISTS `CorrectAnswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CorrectAnswer` (
  `Question_questionId` int(11) NOT NULL,
  `Alternative_alternativeId` int(11) NOT NULL,
  PRIMARY KEY (`Question_questionId`,`Alternative_alternativeId`),
  KEY `fk_CorrectAnswer_Question1_idx` (`Question_questionId`),
  KEY `fk_CorrectAnswer_Alternative1_idx` (`Alternative_alternativeId`),
  CONSTRAINT `fk_CorrectAnswer_Question1` FOREIGN KEY (`Question_questionId`) REFERENCES `Question` (`questionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CorrectAnswer_Alternative1` FOREIGN KEY (`Alternative_alternativeId`) REFERENCES `Alternative` (`alternativeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CorrectAnswer`
--

LOCK TABLES `CorrectAnswer` WRITE;
/*!40000 ALTER TABLE `CorrectAnswer` DISABLE KEYS */;
/*!40000 ALTER TABLE `CorrectAnswer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Question` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `Quizz_quizzId` int(11) NOT NULL,
  PRIMARY KEY (`questionId`),
  KEY `fk_Question_Quizz1_idx` (`Quizz_quizzId`),
  CONSTRAINT `fk_Question_Quizz1` FOREIGN KEY (`Quizz_quizzId`) REFERENCES `Quizz` (`quizzId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Question`
--

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Quizz`
--

DROP TABLE IF EXISTS `Quizz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Quizz` (
  `quizzId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `createdAt` datetime NOT NULL,
  `state` bit(1) NOT NULL,
  `Teacher_createdBy` int(11) NOT NULL,
  PRIMARY KEY (`quizzId`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_Quizz_Teacher1_idx` (`Teacher_createdBy`),
  CONSTRAINT `fk_Quizz_Teacher1` FOREIGN KEY (`Teacher_createdBy`) REFERENCES `Teacher` (`teacherId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Quizz`
--

LOCK TABLES `Quizz` WRITE;
/*!40000 ALTER TABLE `Quizz` DISABLE KEYS */;
/*!40000 ALTER TABLE `Quizz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `studentNumber` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`studentNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentAnswers`
--

DROP TABLE IF EXISTS `StudentAnswers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StudentAnswers` (
  `StudentAttempt_StudentAttemptId` int(11) NOT NULL,
  `Alternative_alternativeId` int(11) NOT NULL,
  PRIMARY KEY (`StudentAttempt_StudentAttemptId`,`Alternative_alternativeId`),
  KEY `fk_StudentAnswers_StudentAttempt1_idx` (`StudentAttempt_StudentAttemptId`),
  KEY `fk_StudentAnswers_Alternative1_idx` (`Alternative_alternativeId`),
  CONSTRAINT `fk_StudentAnswers_Alternative1` FOREIGN KEY (`Alternative_alternativeId`) REFERENCES `Alternative` (`alternativeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_StudentAnswers_StudentAttempt1` FOREIGN KEY (`StudentAttempt_StudentAttemptId`) REFERENCES `StudentAttempt` (`StudentAttemptId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentAnswers`
--

LOCK TABLES `StudentAnswers` WRITE;
/*!40000 ALTER TABLE `StudentAnswers` DISABLE KEYS */;
/*!40000 ALTER TABLE `StudentAnswers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentAttempt`
--

DROP TABLE IF EXISTS `StudentAttempt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StudentAttempt` (
  `Student_studentNumber` varchar(45) NOT NULL,
  `attemptDate` datetime NOT NULL,
  `Quizz_quizzId` int(11) NOT NULL,
  `StudentAttemptId` int(11) NOT NULL AUTO_INCREMENT,
  `Result` int(11) NOT NULL,
  PRIMARY KEY (`StudentAttemptId`),
  KEY `fk_StudentAttempt_Student_idx` (`Student_studentNumber`),
  KEY `fk_StudentAttempt_Quizz1` (`Quizz_quizzId`),
  CONSTRAINT `fk_StudentAttempt_Quizz1` FOREIGN KEY (`Quizz_quizzId`) REFERENCES `Quizz` (`quizzId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_StudentAttempt_Student` FOREIGN KEY (`Student_studentNumber`) REFERENCES `Student` (`studentNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentAttempt`
--

LOCK TABLES `StudentAttempt` WRITE;
/*!40000 ALTER TABLE `StudentAttempt` DISABLE KEYS */;
/*!40000 ALTER TABLE `StudentAttempt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-21 14:47:38

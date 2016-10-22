
--
-- Table structure for table `internal_user`
--

DROP TABLE IF EXISTS `internal_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internal_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FULL_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `PATIENT_ID` int(11) NOT NULL,
  `FULL_NAME` varchar(45)  NOT NULL,
  `DATE_OF_BIRTH` date NOT NULL,
  `ADDRESS` varchar(100)  NOT NULL,
  `BLOOD_GROUP` varchar(5)  NOT NULL,
  `GENDER` varchar(10)  NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `MOBILE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`PATIENT_ID`),
  UNIQUE KEY `PATIENT_ID_UNIQUE` (`PATIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user_credential`
--

DROP TABLE IF EXISTS `user_credential`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_credential` (
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  KEY `FK_USER_ID_idx` (`USER_ID`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `internal_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `patient_appointment`
--

DROP TABLE IF EXISTS `patient_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_appointment` (
  `APPOINTMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PATIENT_ID` int(11) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `APPOINTMENT_DATE` datetime NOT NULL,
  PRIMARY KEY (`APPOINTMENT_ID`),
  UNIQUE KEY `APPOINTMENT_ID_UNIQUE` (`APPOINTMENT_ID`),
  KEY `FK_PATIENT_ID_idx` (`PATIENT_ID`),
  KEY `FK_APP_USERNAME_idx` (`USERNAME`),
  CONSTRAINT `FK_APP_USERNAME` FOREIGN KEY (`USERNAME`) REFERENCES `user_credential` (`USERNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PATIENT_ID` FOREIGN KEY (`PATIENT_ID`) REFERENCES `patient` (`PATIENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) DEFAULT NULL,
  `ROLE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `UNIQUE_KEY` (`USERNAME`,`ROLE`),
  KEY `FK_USERNAME_idx` (`USERNAME`),
  CONSTRAINT `FK_USERNAME` FOREIGN KEY (`USERNAME`) REFERENCES `user_credential` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--

--
-- Dumping data for table `internal_user`
--

LOCK TABLES `internal_user` WRITE;
/*!40000 ALTER TABLE `internal_user` DISABLE KEYS */;
INSERT INTO `internal_user` VALUES (1,'Vivek Nahata'),(2,'Manog Babar');
/*!40000 ALTER TABLE `internal_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Vivek Malhotra','1988-01-23','plot 312, gagan apt, palam vihar, Gurgaon','B+','MALE',NULL,NULL),(2,'Varun Malhotra','1989-06-04','3, sunview apt, Dwarka, Delhi','O+','MALE',NULL,NULL),(3,'Stephene Narang','1988-05-23','m-372, Punjabi bagh, New delhi','B+','FEMALE',NULL,NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient_appointment`
--

LOCK TABLES `patient_appointment` WRITE;
/*!40000 ALTER TABLE `patient_appointment` DISABLE KEYS */;
INSERT INTO `patient_appointment` VALUES (1,1,'manog','2016-10-15 17:30:00'),(2,3,'manog','2016-10-16 15:30:00');
/*!40000 ALTER TABLE `patient_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_credential`
--

LOCK TABLES `user_credential` WRITE;
/*!40000 ALTER TABLE `user_credential` DISABLE KEYS */;
INSERT INTO `user_credential` VALUES ('admin','password',1),('manog','password',2);
/*!40000 ALTER TABLE `user_credential` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'admin','ROLE_DOCTOR'),(2,'manog','ROLE_DOCTOR');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
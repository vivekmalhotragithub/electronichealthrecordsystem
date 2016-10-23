--
-- Dumping data for table `internal_user`
--
INSERT INTO `internal_user` VALUES (1,'Vivek Nahata'),(2,'Manoj Mehra');

--
-- Dumping data for table `user_credential`
--

INSERT INTO `user_credential` VALUES ('vivekmalh','password',1),('manojmehra','password',2);

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` VALUES (1,'Vivek Malhotra','1988-01-23','plot 312, gagan apt, palam vihar, Gurgaon','B+','MALE','abc@ymail.com','9654615544'),(2,'Varun Malhotra','1989-06-04','3, sunview apt, Dwarka, Delhi','O+','MALE','varun@ymail.com','9654312312'),(3,'Stephene Narang','1988-05-23','m-372, Punjabi bagh, New delhi','B+','FEMALE','steph@gmail.com','9878776886');

--
-- Dumping data for table `patient_appointment`
--

INSERT INTO `patient_appointment` VALUES (1,1,'manojmehra','2016-10-15 17:30:00',''),(2,3,'manojmehra','2016-10-16 15:30:00',''),(3,1,'manojmehra','2016-04-06 15:56:00',''),(4,2,'vivekmalh','2016-03-08 17:09:00',''),(5,1,'manojmehra','2016-04-08 17:05:00',''),(6,3,'manojmehra','2016-05-07 15:03:00','hello how are you?'),(7,2,'manojmehra','2016-10-27 17:20:00','Patient has been advised to visit again after a week of prescription');

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` VALUES (1,'vivekmalh','ROLE_DOCTOR'),(2,'manojmehra','ROLE_DOCTOR');
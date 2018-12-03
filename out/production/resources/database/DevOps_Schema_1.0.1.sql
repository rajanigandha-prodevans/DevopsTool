-- ------------------------------------------------------
-- Host: 127.0.0.1    Database: devops_assessment
-- version : 1.0.1
-- ------------------------------------------------------
--
-- Table structure for table `assessment`
--

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment` (
  `assessment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `assessment_status_id` int(11) NOT NULL,
  `assessment_name` varchar(45) DEFAULT NULL,
  `assessment_description` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`assessment_id`),
  KEY `assessment_status_id_idx` (`assessment_status_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `assessment_status_id` FOREIGN KEY (`assessment_status_id`) REFERENCES `assessment_status` (`assessment_status_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assessment_answer_table`
--

DROP TABLE IF EXISTS `assessment_answer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_answer_table` (
  `assessment_process_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_option_id` int(11) DEFAULT NULL,
  KEY `Assessment_idx` (`assessment_process_id`),
  KEY `question_answer_idx` (`question_option_id`),
  CONSTRAINT `Assessment` FOREIGN KEY (`assessment_process_id`) REFERENCES `assessment_process` (`assessment_process_id`),
  CONSTRAINT `question_answer` FOREIGN KEY (`question_option_id`) REFERENCES `question_option` (`question_option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assessment_process`
--

DROP TABLE IF EXISTS `assessment_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_process` (
  `assessment_process_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `assessment_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`assessment_process_id`),
  KEY `question_id_idx` (`question_id`),
  KEY `Assessment_id_idx` (`assessment_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `fk_Assessment_id` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`assessment_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `question_category` (`category_id`),
  CONSTRAINT `fk_question_id` FOREIGN KEY (`question_id`) REFERENCES `assessment_question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assessment_question`
--

DROP TABLE IF EXISTS `assessment_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(250) NOT NULL,
  `category_id` int(11) NOT NULL,
  `question_type_id` int(11) NOT NULL,
  `question_option_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `category_id_idx` (`category_id`),
  KEY `question_type_id_idx` (`question_type_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `question_category` (`category_id`),
  CONSTRAINT `question_type_id` FOREIGN KEY (`question_type_id`) REFERENCES `question_type` (`question_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assessment_result`
--

DROP TABLE IF EXISTS `assessment_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_result` (
  `assessment_result_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_total_score` float NOT NULL,
  `assessment_id` int(11) NOT NULL,
  `result_maturity_id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`assessment_result_id`),
  KEY `assessment_id_idx` (`assessment_id`),
  KEY `result_maturity_id_idx` (`result_maturity_id`),
  KEY `fk_category_id_idx` (`category_id`),
  CONSTRAINT `assessment_id` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`assessment_id`),
  CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `question_category` (`category_id`),
  CONSTRAINT `result_maturity_id` FOREIGN KEY (`result_maturity_id`) REFERENCES `result_maturity` (`result_maturity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assessment_status`
--

DROP TABLE IF EXISTS `assessment_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_status` (
  `assessment_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`assessment_status_id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `company_size`
--

DROP TABLE IF EXISTS `company_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company_size` (
  `company_size_id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(45) NOT NULL,
  PRIMARY KEY (`company_size_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`country_id`),
  UNIQUE KEY `country_name_UNIQUE` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `industry_type`
--

DROP TABLE IF EXISTS `industry_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `industry_type` (
  `industry_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `industry_name` varchar(45) NOT NULL,
  PRIMARY KEY (`industry_type_id`),
  UNIQUE KEY `industry_name_UNIQUE` (`industry_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question_category`
--

DROP TABLE IF EXISTS `question_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `catagory_name_UNIQUE` (`category_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question_option`
--

DROP TABLE IF EXISTS `question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question_option` (
  `question_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_option` varchar(250) NOT NULL,
  `weightage` float NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`question_option_id`),
  KEY `question_id_idx` (`question_id`),
  CONSTRAINT `question_id` FOREIGN KEY (`question_id`) REFERENCES `assessment_question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question_type`
--

DROP TABLE IF EXISTS `question_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question_type` (
  `question_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_type` varchar(80) NOT NULL,
  PRIMARY KEY (`question_type_id`),
  UNIQUE KEY `type_UNIQUE` (`question_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `result_maturity`
--

DROP TABLE IF EXISTS `result_maturity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `result_maturity` (
  `result_maturity_id` int(11) NOT NULL AUTO_INCREMENT,
  `maturity_level` varchar(45) NOT NULL,
  PRIMARY KEY (`result_maturity_id`),
  UNIQUE KEY `maturity_level_UNIQUE` (`maturity_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `company_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `country_id` int(11) NOT NULL,
  `industry_type_id` int(11) NOT NULL,
  `company_size_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_id_UNIQUE` (`user_email`),
  KEY `country_id_idx` (`country_id`),
  KEY `fk_industry_id_idx` (`industry_type_id`),
  KEY `company_size_id_idx` (`company_size_id`),
  CONSTRAINT `company_size_id` FOREIGN KEY (`company_size_id`) REFERENCES `company_size` (`company_size_id`),
  CONSTRAINT `fk_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `fk_industry_id` FOREIGN KEY (`industry_type_id`) REFERENCES `industry_type` (`industry_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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
  KEY `user_id_idx` (`user_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
INSERT INTO `assessment` VALUES (1,1,'2018-09-07 14:10:31',1,NULL,NULL),(2,1,'2018-09-07 14:10:43',1,NULL,NULL),(3,1,'2018-09-07 14:12:11',1,NULL,NULL),(4,1,'2018-09-07 14:14:11',1,NULL,NULL),(5,1,'2018-09-07 14:17:19',1,NULL,NULL),(6,1,'2018-09-07 14:18:49',1,'sv','dfb'),(7,1,'2018-09-07 14:39:51',1,'siddu','hi guyz'),(8,1,'2018-09-07 16:15:07',2,'RK','Hey Der'),(9,1,'2018-09-07 16:22:22',1,'Test','Testing 1234'),(10,1,'2018-09-07 16:31:11',1,'nandish','ajsdoijqwodfjiwue'),(11,1,'2018-09-07 16:35:04',2,'RK','hhhjh'),(12,1,'2018-09-07 16:41:30',1,'a','1233'),(13,1,'2018-09-07 16:43:24',1,'121311','131313'),(14,1,'2018-09-07 16:44:03',1,'`12131','qredasfass'),(15,1,'2018-09-07 16:45:31',1,'yuquyeq','asfsdtyasgyg'),(16,1,'2018-09-07 16:46:08',1,'qwqwew','erwrfttfr'),(17,1,'2018-09-07 16:50:54',1,'ashgduas','agadyuw'),(18,1,'2018-09-07 16:56:46',1,'wqwqeqe','qwqqdq'),(19,1,'2018-09-07 17:08:46',1,'xfghjl;/','fdfgjokpl;\'\n'),(20,1,'2018-09-07 17:11:01',1,'siddu','qrwdrdwtydyu'),(21,1,'2018-09-10 15:50:49',1,'siddu','wdefger'),(22,1,'2018-10-05 18:15:52',2,'PK','Devops Works'),(23,1,'2018-10-13 16:17:08',1,'amit8959','new test');
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_answer_table`
--

DROP TABLE IF EXISTS `assessment_answer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_answer_table` (
  `assessment_process_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `question_option_id` int(11) DEFAULT NULL,
  KEY `Assessment_idx` (`assessment_process_id`),
  KEY `question_answer_idx` (`question_option_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_answer_table`
--

LOCK TABLES `assessment_answer_table` WRITE;
/*!40000 ALTER TABLE `assessment_answer_table` DISABLE KEYS */;
INSERT INTO `assessment_answer_table` VALUES (202,1),(202,2),(202,3),(202,4),(202,5),(203,6),(203,7),(203,8),(203,9),(203,10),(204,11),(204,12),(204,13),(204,14),(204,15),(205,16),(205,17),(205,18),(205,19),(205,20),(206,21),(206,22),(181,23),(181,24),(182,25),(182,26),(182,27),(182,28),(183,29),(183,30),(184,31),(184,32),(185,33),(185,34),(185,35),(186,36),(186,37),(186,38),(186,39),(186,40),(187,41),(187,42),(188,43),(188,44),(188,45),(188,46),(189,47),(189,48),(190,49),(190,50),(190,51),(190,52),(190,53),(191,54),(191,55),(191,56),(191,57),(191,58),(191,59),(322,1),(322,2),(322,3),(322,4),(322,5),(323,6),(323,7),(323,8),(323,9),(323,10),(324,11),(324,12),(324,13),(324,14),(324,15),(325,16),(325,17),(325,18),(325,19),(325,20),(326,21),(326,22),(301,23),(301,24),(302,25),(302,26),(302,27),(302,28),(303,29),(303,30),(304,31),(304,32),(305,33),(305,34),(305,35),(306,36),(306,37),(306,38),(306,39),(306,40),(307,41),(307,42),(308,43),(308,44),(308,45),(308,46),(309,47),(309,48),(310,49),(310,50),(310,51),(310,52),(310,53),(311,54),(311,55),(311,56),(311,57),(311,58),(311,59),(312,60),(312,61),(313,62),(313,63),(314,64),(314,65),(315,66),(315,67),(315,68),(315,69),(316,70),(316,71),(316,72),(327,73),(327,74),(327,75),(328,76),(328,77),(328,78),(328,79),(328,80),(329,81),(329,82),(330,83),(330,84),(317,85),(317,86),(318,87),(318,88),(319,89),(319,90),(320,91),(320,92),(321,93),(321,94),(262,1),(263,7),(264,12),(265,18),(266,21),(241,23),(242,25),(242,26),(243,29),(244,31),(245,33),(246,36),(246,37),(247,41),(248,44),(249,47),(250,49),(250,50),(250,51),(250,52),(251,54),(251,55),(252,60),(253,62),(254,64),(255,66),(255,67),(256,70),(267,74),(268,77),(268,78),(269,82),(270,83),(257,85),(258,87),(259,89),(260,91),(261,93),(232,1),(233,6),(233,7),(234,12),(234,13),(235,19),(236,21),(211,23),(212,25),(213,29),(214,31),(215,33),(216,37),(216,38),(217,41),(218,44),(219,47),(220,49),(221,56),(221,58),(222,60),(223,62),(224,64),(225,67),(225,68),(226,70),(237,74),(238,77),(238,79),(239,81),(240,83),(227,85),(228,87),(229,89),(230,91),(231,93),(652,1),(653,7),(653,8),(654,12),(654,13),(654,14),(655,18),(656,21),(631,23),(632,26),(632,27),(633,29),(634,31),(635,33),(636,36),(636,38),(636,39),(637,41),(638,43),(639,47),(640,49),(640,50),(641,55),(641,56),(642,60),(643,62),(644,64),(645,66),(645,67),(645,68),(646,70),(657,74),(658,76),(658,77),(659,81),(660,83),(647,85),(648,87),(649,89),(650,91),(651,93),(682,1),(683,6),(683,7),(684,11),(684,12),(685,17),(686,21),(661,23),(662,25),(663,29),(664,31),(665,34),(666,37),(666,38),(667,41),(668,45),(669,47),(670,50),(670,51),(671,55),(671,56),(672,60),(673,62),(674,64),(675,66),(675,69),(676,70),(687,73),(688,77),(688,78),(689,81),(690,83),(677,86),(678,88),(679,89),(680,92),(681,94);
/*!40000 ALTER TABLE `assessment_answer_table` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `category_id_idx` (`category_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_process`
--

LOCK TABLES `assessment_process` WRITE;
/*!40000 ALTER TABLE `assessment_process` DISABLE KEYS */;
INSERT INTO `assessment_process` VALUES (1,1,6,2),(2,1,7,2),(3,1,8,2),(4,1,9,2),(5,1,10,2),(6,1,11,2),(7,1,12,2),(8,1,13,3),(9,1,14,3),(10,1,15,3),(11,1,16,3),(12,1,17,4),(13,1,18,4),(14,1,19,4),(15,1,20,4),(16,1,21,4),(17,1,26,6),(18,1,27,6),(19,1,28,6),(20,1,29,6),(21,1,30,6),(22,1,1,1),(23,1,2,1),(24,1,3,1),(25,1,4,1),(26,1,5,1),(27,1,22,5),(28,1,23,5),(29,1,24,5),(30,1,25,5),(31,2,6,2),(32,2,7,2),(33,2,8,2),(34,2,9,2),(35,2,10,2),(36,2,11,2),(37,2,12,2),(38,2,13,3),(39,2,14,3),(40,2,15,3),(41,2,16,3),(42,2,17,4),(43,2,18,4),(44,2,19,4),(45,2,20,4),(46,2,21,4),(47,2,26,6),(48,2,27,6),(49,2,28,6),(50,2,29,6),(51,2,30,6),(52,2,1,1),(53,2,2,1),(54,2,3,1),(55,2,4,1),(56,2,5,1),(57,2,22,5),(58,2,23,5),(59,2,24,5),(60,2,25,5),(61,3,6,2),(62,3,7,2),(63,3,8,2),(64,3,9,2),(65,3,10,2),(66,3,11,2),(67,3,12,2),(68,3,13,3),(69,3,14,3),(70,3,15,3),(71,3,16,3),(72,3,17,4),(73,3,18,4),(74,3,19,4),(75,3,20,4),(76,3,21,4),(77,3,26,6),(78,3,27,6),(79,3,28,6),(80,3,29,6),(81,3,30,6),(82,3,1,1),(83,3,2,1),(84,3,3,1),(85,3,4,1),(86,3,5,1),(87,3,22,5),(88,3,23,5),(89,3,24,5),(90,3,25,5),(91,4,6,2),(92,4,7,2),(93,4,8,2),(94,4,9,2),(95,4,10,2),(96,4,11,2),(97,4,12,2),(98,4,13,3),(99,4,14,3),(100,4,15,3),(101,4,16,3),(102,4,17,4),(103,4,18,4),(104,4,19,4),(105,4,20,4),(106,4,21,4),(107,4,26,6),(108,4,27,6),(109,4,28,6),(110,4,29,6),(111,4,30,6),(112,4,1,1),(113,4,2,1),(114,4,3,1),(115,4,4,1),(116,4,5,1),(117,4,22,5),(118,4,23,5),(119,4,24,5),(120,4,25,5),(121,5,6,2),(122,5,7,2),(123,5,8,2),(124,5,9,2),(125,5,10,2),(126,5,11,2),(127,5,12,2),(128,5,13,3),(129,5,14,3),(130,5,15,3),(131,5,16,3),(132,5,17,4),(133,5,18,4),(134,5,19,4),(135,5,20,4),(136,5,21,4),(137,5,26,6),(138,5,27,6),(139,5,28,6),(140,5,29,6),(141,5,30,6),(142,5,1,1),(143,5,2,1),(144,5,3,1),(145,5,4,1),(146,5,5,1),(147,5,22,5),(148,5,23,5),(149,5,24,5),(150,5,25,5),(151,6,6,2),(152,6,7,2),(153,6,8,2),(154,6,9,2),(155,6,10,2),(156,6,11,2),(157,6,12,2),(158,6,13,3),(159,6,14,3),(160,6,15,3),(161,6,16,3),(162,6,17,4),(163,6,18,4),(164,6,19,4),(165,6,20,4),(166,6,21,4),(167,6,26,6),(168,6,27,6),(169,6,28,6),(170,6,29,6),(171,6,30,6),(172,6,1,1),(173,6,2,1),(174,6,3,1),(175,6,4,1),(176,6,5,1),(177,6,22,5),(178,6,23,5),(179,6,24,5),(180,6,25,5),(181,7,6,2),(182,7,7,2),(183,7,8,2),(184,7,9,2),(185,7,10,2),(186,7,11,2),(187,7,12,2),(188,7,13,3),(189,7,14,3),(190,7,15,3),(191,7,16,3),(192,7,17,4),(193,7,18,4),(194,7,19,4),(195,7,20,4),(196,7,21,4),(197,7,26,6),(198,7,27,6),(199,7,28,6),(200,7,29,6),(201,7,30,6),(202,7,1,1),(203,7,2,1),(204,7,3,1),(205,7,4,1),(206,7,5,1),(207,7,22,5),(208,7,23,5),(209,7,24,5),(210,7,25,5),(211,8,6,2),(212,8,7,2),(213,8,8,2),(214,8,9,2),(215,8,10,2),(216,8,11,2),(217,8,12,2),(218,8,13,3),(219,8,14,3),(220,8,15,3),(221,8,16,3),(222,8,17,4),(223,8,18,4),(224,8,19,4),(225,8,20,4),(226,8,21,4),(227,8,26,6),(228,8,27,6),(229,8,28,6),(230,8,29,6),(231,8,30,6),(232,8,1,1),(233,8,2,1),(234,8,3,1),(235,8,4,1),(236,8,5,1),(237,8,22,5),(238,8,23,5),(239,8,24,5),(240,8,25,5),(241,9,6,2),(242,9,7,2),(243,9,8,2),(244,9,9,2),(245,9,10,2),(246,9,11,2),(247,9,12,2),(248,9,13,3),(249,9,14,3),(250,9,15,3),(251,9,16,3),(252,9,17,4),(253,9,18,4),(254,9,19,4),(255,9,20,4),(256,9,21,4),(257,9,26,6),(258,9,27,6),(259,9,28,6),(260,9,29,6),(261,9,30,6),(262,9,1,1),(263,9,2,1),(264,9,3,1),(265,9,4,1),(266,9,5,1),(267,9,22,5),(268,9,23,5),(269,9,24,5),(270,9,25,5),(271,10,6,2),(272,10,7,2),(273,10,8,2),(274,10,9,2),(275,10,10,2),(276,10,11,2),(277,10,12,2),(278,10,13,3),(279,10,14,3),(280,10,15,3),(281,10,16,3),(282,10,17,4),(283,10,18,4),(284,10,19,4),(285,10,20,4),(286,10,21,4),(287,10,26,6),(288,10,27,6),(289,10,28,6),(290,10,29,6),(291,10,30,6),(292,10,1,1),(293,10,2,1),(294,10,3,1),(295,10,4,1),(296,10,5,1),(297,10,22,5),(298,10,23,5),(299,10,24,5),(300,10,25,5),(301,11,6,2),(302,11,7,2),(303,11,8,2),(304,11,9,2),(305,11,10,2),(306,11,11,2),(307,11,12,2),(308,11,13,3),(309,11,14,3),(310,11,15,3),(311,11,16,3),(312,11,17,4),(313,11,18,4),(314,11,19,4),(315,11,20,4),(316,11,21,4),(317,11,26,6),(318,11,27,6),(319,11,28,6),(320,11,29,6),(321,11,30,6),(322,11,1,1),(323,11,2,1),(324,11,3,1),(325,11,4,1),(326,11,5,1),(327,11,22,5),(328,11,23,5),(329,11,24,5),(330,11,25,5),(331,12,6,2),(332,12,7,2),(333,12,8,2),(334,12,9,2),(335,12,10,2),(336,12,11,2),(337,12,12,2),(338,12,13,3),(339,12,14,3),(340,12,15,3),(341,12,16,3),(342,12,17,4),(343,12,18,4),(344,12,19,4),(345,12,20,4),(346,12,21,4),(347,12,26,6),(348,12,27,6),(349,12,28,6),(350,12,29,6),(351,12,30,6),(352,12,1,1),(353,12,2,1),(354,12,3,1),(355,12,4,1),(356,12,5,1),(357,12,22,5),(358,12,23,5),(359,12,24,5),(360,12,25,5),(361,13,6,2),(362,13,7,2),(363,13,8,2),(364,13,9,2),(365,13,10,2),(366,13,11,2),(367,13,12,2),(368,13,13,3),(369,13,14,3),(370,13,15,3),(371,13,16,3),(372,13,17,4),(373,13,18,4),(374,13,19,4),(375,13,20,4),(376,13,21,4),(377,13,26,6),(378,13,27,6),(379,13,28,6),(380,13,29,6),(381,13,30,6),(382,13,1,1),(383,13,2,1),(384,13,3,1),(385,13,4,1),(386,13,5,1),(387,13,22,5),(388,13,23,5),(389,13,24,5),(390,13,25,5),(391,14,6,2),(392,14,7,2),(393,14,8,2),(394,14,9,2),(395,14,10,2),(396,14,11,2),(397,14,12,2),(398,14,13,3),(399,14,14,3),(400,14,15,3),(401,14,16,3),(402,14,17,4),(403,14,18,4),(404,14,19,4),(405,14,20,4),(406,14,21,4),(407,14,26,6),(408,14,27,6),(409,14,28,6),(410,14,29,6),(411,14,30,6),(412,14,1,1),(413,14,2,1),(414,14,3,1),(415,14,4,1),(416,14,5,1),(417,14,22,5),(418,14,23,5),(419,14,24,5),(420,14,25,5),(421,15,6,2),(422,15,7,2),(423,15,8,2),(424,15,9,2),(425,15,10,2),(426,15,11,2),(427,15,12,2),(428,15,13,3),(429,15,14,3),(430,15,15,3),(431,15,16,3),(432,15,17,4),(433,15,18,4),(434,15,19,4),(435,15,20,4),(436,15,21,4),(437,15,26,6),(438,15,27,6),(439,15,28,6),(440,15,29,6),(441,15,30,6),(442,15,1,1),(443,15,2,1),(444,15,3,1),(445,15,4,1),(446,15,5,1),(447,15,22,5),(448,15,23,5),(449,15,24,5),(450,15,25,5),(451,16,6,2),(452,16,7,2),(453,16,8,2),(454,16,9,2),(455,16,10,2),(456,16,11,2),(457,16,12,2),(458,16,13,3),(459,16,14,3),(460,16,15,3),(461,16,16,3),(462,16,17,4),(463,16,18,4),(464,16,19,4),(465,16,20,4),(466,16,21,4),(467,16,26,6),(468,16,27,6),(469,16,28,6),(470,16,29,6),(471,16,30,6),(472,16,1,1),(473,16,2,1),(474,16,3,1),(475,16,4,1),(476,16,5,1),(477,16,22,5),(478,16,23,5),(479,16,24,5),(480,16,25,5),(481,17,6,2),(482,17,7,2),(483,17,8,2),(484,17,9,2),(485,17,10,2),(486,17,11,2),(487,17,12,2),(488,17,13,3),(489,17,14,3),(490,17,15,3),(491,17,16,3),(492,17,17,4),(493,17,18,4),(494,17,19,4),(495,17,20,4),(496,17,21,4),(497,17,26,6),(498,17,27,6),(499,17,28,6),(500,17,29,6),(501,17,30,6),(502,17,1,1),(503,17,2,1),(504,17,3,1),(505,17,4,1),(506,17,5,1),(507,17,22,5),(508,17,23,5),(509,17,24,5),(510,17,25,5),(511,18,6,2),(512,18,7,2),(513,18,8,2),(514,18,9,2),(515,18,10,2),(516,18,11,2),(517,18,12,2),(518,18,13,3),(519,18,14,3),(520,18,15,3),(521,18,16,3),(522,18,17,4),(523,18,18,4),(524,18,19,4),(525,18,20,4),(526,18,21,4),(527,18,26,6),(528,18,27,6),(529,18,28,6),(530,18,29,6),(531,18,30,6),(532,18,1,1),(533,18,2,1),(534,18,3,1),(535,18,4,1),(536,18,5,1),(537,18,22,5),(538,18,23,5),(539,18,24,5),(540,18,25,5),(541,19,6,2),(542,19,7,2),(543,19,8,2),(544,19,9,2),(545,19,10,2),(546,19,11,2),(547,19,12,2),(548,19,13,3),(549,19,14,3),(550,19,15,3),(551,19,16,3),(552,19,17,4),(553,19,18,4),(554,19,19,4),(555,19,20,4),(556,19,21,4),(557,19,26,6),(558,19,27,6),(559,19,28,6),(560,19,29,6),(561,19,30,6),(562,19,1,1),(563,19,2,1),(564,19,3,1),(565,19,4,1),(566,19,5,1),(567,19,22,5),(568,19,23,5),(569,19,24,5),(570,19,25,5),(571,20,6,2),(572,20,7,2),(573,20,8,2),(574,20,9,2),(575,20,10,2),(576,20,11,2),(577,20,12,2),(578,20,13,3),(579,20,14,3),(580,20,15,3),(581,20,16,3),(582,20,17,4),(583,20,18,4),(584,20,19,4),(585,20,20,4),(586,20,21,4),(587,20,26,6),(588,20,27,6),(589,20,28,6),(590,20,29,6),(591,20,30,6),(592,20,1,1),(593,20,2,1),(594,20,3,1),(595,20,4,1),(596,20,5,1),(597,20,22,5),(598,20,23,5),(599,20,24,5),(600,20,25,5),(601,21,6,2),(602,21,7,2),(603,21,8,2),(604,21,9,2),(605,21,10,2),(606,21,11,2),(607,21,12,2),(608,21,13,3),(609,21,14,3),(610,21,15,3),(611,21,16,3),(612,21,17,4),(613,21,18,4),(614,21,19,4),(615,21,20,4),(616,21,21,4),(617,21,26,6),(618,21,27,6),(619,21,28,6),(620,21,29,6),(621,21,30,6),(622,21,1,1),(623,21,2,1),(624,21,3,1),(625,21,4,1),(626,21,5,1),(627,21,22,5),(628,21,23,5),(629,21,24,5),(630,21,25,5),(631,22,6,2),(632,22,7,2),(633,22,8,2),(634,22,9,2),(635,22,10,2),(636,22,11,2),(637,22,12,2),(638,22,13,3),(639,22,14,3),(640,22,15,3),(641,22,16,3),(642,22,17,4),(643,22,18,4),(644,22,19,4),(645,22,20,4),(646,22,21,4),(647,22,26,6),(648,22,27,6),(649,22,28,6),(650,22,29,6),(651,22,30,6),(652,22,1,1),(653,22,2,1),(654,22,3,1),(655,22,4,1),(656,22,5,1),(657,22,22,5),(658,22,23,5),(659,22,24,5),(660,22,25,5),(661,23,6,2),(662,23,7,2),(663,23,8,2),(664,23,9,2),(665,23,10,2),(666,23,11,2),(667,23,12,2),(668,23,13,3),(669,23,14,3),(670,23,15,3),(671,23,16,3),(672,23,17,4),(673,23,18,4),(674,23,19,4),(675,23,20,4),(676,23,21,4),(677,23,26,6),(678,23,27,6),(679,23,28,6),(680,23,29,6),(681,23,30,6),(682,23,1,1),(683,23,2,1),(684,23,3,1),(685,23,4,1),(686,23,5,1),(687,23,22,5),(688,23,23,5),(689,23,24,5),(690,23,25,5);
/*!40000 ALTER TABLE `assessment_process` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `question_type_id_idx` (`question_type_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_question`
--

LOCK TABLES `assessment_question` WRITE;
/*!40000 ALTER TABLE `assessment_question` DISABLE KEYS */;
INSERT INTO `assessment_question` VALUES (1,'How do you plan, prioritize and schedule work?',1,1,NULL),(2,'How do development and operations teams collaborate during a production issue?',1,2,NULL),(3,'What are your policies around open source software?',1,2,NULL),(4,'Which project development method is getting used by your company?',1,1,NULL),(5,'Do you follow devops culture?',1,1,NULL),(6,'Do you use any Continuous Integration(CI) tool to orchestrate your builds?',2,1,NULL),(7,'Which files do you keep under version control?',2,2,NULL),(8,'Do you use any branching policy?',2,1,NULL),(9,'Do you use any strategy to review code changes?',2,1,NULL),(10,'How do you manage code dependencies across teams?',2,1,NULL),(11,'What does your team consider good testing?',2,2,NULL),(12,'Are you doing security testing?',2,1,NULL),(13,'Are you using automated continuous deployment(CD) strategy?',3,1,NULL),(14,'Have you provides the Disaster Recovery system',3,1,NULL),(15,'What rollback practices used by the operations team?',3,2,NULL),(16,'What types of deployment strategies used by the operations?',3,2,NULL),(17,'Have you automated an infrastructure building?',4,1,NULL),(18,'Do you have Iaas in your organization?',4,1,NULL),(19,'Are you doing infrastructure testing?',4,1,NULL),(20,'What are the components of the infrastructure uses automation?',4,2,NULL),(21,'Which cloud services your company is using?',4,1,NULL),(22,'Where are you using Continuous Integration and Continuous Delivery?',5,1,NULL),(23,'What is your policy for Cloud usage?',5,2,NULL),(24,'Do you use Automation Testing?',5,1,NULL),(25,'Do you use any tool for code review?',5,1,NULL),(26,'Are you doing production server health monitoring ?',6,1,NULL),(27,'Are you doing threats analysis for the critical production environments?',6,1,NULL),(28,'Do you provides any Aleart system for server health or threat detection?',6,1,NULL),(29,'Do you have centeralized System audit report system ?',6,1,NULL),(30,'Do you have a system for crash summery?',6,1,NULL);
/*!40000 ALTER TABLE `assessment_question` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `fk_category_id_idx` (`category_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_result`
--

LOCK TABLES `assessment_result` WRITE;
/*!40000 ALTER TABLE `assessment_result` DISABLE KEYS */;
INSERT INTO `assessment_result` VALUES (1,5,11,3,6),(2,5,11,3,1),(3,7,11,3,2),(4,4,11,3,3),(5,5,11,3,4),(6,4,11,3,5),(7,2.4,8,1,1),(8,5.2,8,2,2),(9,1.7,8,1,3),(10,4,8,2,4),(11,2.9,8,2,5),(12,5,8,3,6),(13,5.5,22,2,2),(14,1.85,22,1,3),(15,4.25,22,3,4),(16,5,22,3,6),(17,3.1,22,2,1),(18,3.1,22,2,1),(19,2.6,22,2,5),(20,2.6,22,2,5),(21,2.6,22,2,5);
/*!40000 ALTER TABLE `assessment_result` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_status`
--

LOCK TABLES `assessment_status` WRITE;
/*!40000 ALTER TABLE `assessment_status` DISABLE KEYS */;
INSERT INTO `assessment_status` VALUES (2,'Done'),(1,'in progress');
/*!40000 ALTER TABLE `assessment_status` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_size`
--

LOCK TABLES `company_size` WRITE;
/*!40000 ALTER TABLE `company_size` DISABLE KEYS */;
INSERT INTO `company_size` VALUES (1,'< 100 employees'),(2,'100-500 employees'),(3,'500-1000 employees'),(4,'1000-5000 employees'),(5,'5000 - 10000 employees'),(6,'> 10000 employees');
/*!40000 ALTER TABLE `company_size` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Afghanistan'),(2,'Armenia'),(3,'Azerbaijan'),(4,'Bahrain'),(5,'Bangladesh'),(6,'Bhutan'),(7,'Brunei'),(8,'Cambodia'),(9,'China'),(10,'Cyprus'),(11,'Georgia'),(12,'India'),(13,'Indonesia'),(14,'Iran'),(15,'Iraq'),(16,'Israel'),(17,'Japan'),(18,'Jordan'),(19,'Kazakhstan'),(20,'Kuwait'),(21,'Kyrgyzstan'),(22,'Laos'),(23,'Lebanon'),(24,'Malaysia'),(25,'Maldives'),(26,'Mongolia'),(27,'Myanmar (formerly Burma)'),(28,'Nepal'),(29,'North Korea'),(30,'Oman'),(31,'Pakistan'),(32,'Palestine'),(33,'Philippines'),(34,'Qatar'),(35,'Russia'),(36,'Saudi Arabia'),(37,'Singapore'),(38,'South Korea'),(39,'Sri Lanka'),(40,'Syria'),(41,'Taiwan'),(42,'Tajikistan'),(43,'Thailand'),(44,'Timor-Leste'),(45,'Turkey'),(46,'Turkmenistan'),(47,'United Arab Emirates (UAE)'),(48,'Uzbekistan'),(49,'Vietnam'),(50,'Yemen');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry_type`
--

LOCK TABLES `industry_type` WRITE;
/*!40000 ALTER TABLE `industry_type` DISABLE KEYS */;
INSERT INTO `industry_type` VALUES (1,'Agriculture, Forestry & Fishing'),(2,'Banking & Capital Markets'),(3,'Discrete Manufacturing'),(4,'Education'),(5,'Government'),(6,'Health'),(7,'Hospitality & Travel'),(8,'Information Technology'),(9,'Insurance'),(10,'Logistics'),(11,'Media &amp; Cable'),(12,'Nonprofit'),(13,'Other - Unsegmented'),(14,'Power & Utilities'),(15,'Process Mfg & Resources'),(16,'Professional Services'),(17,'Public Safety_Natl Security'),(18,'Retail and Consumer Goods'),(19,'Telecommunications');
/*!40000 ALTER TABLE `industry_type` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_category`
--

LOCK TABLES `question_category` WRITE;
/*!40000 ALTER TABLE `question_category` DISABLE KEYS */;
INSERT INTO `question_category` VALUES (2,'build_process'),(3,'deployment'),(4,'infrastructure'),(6,'monitoring_and_feedback'),(1,'process_and_culture'),(5,'technology_and_automation');
/*!40000 ALTER TABLE `question_category` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `question_id_idx` (`question_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_option`
--

LOCK TABLES `question_option` WRITE;
/*!40000 ALTER TABLE `question_option` DISABLE KEYS */;
INSERT INTO `question_option` VALUES (1,'By feature completion against specifications',0.2,1),(2,'In timeboxes such as sprints',0.25,1),(3,'We strive for a one-piece flow of product backlog items, stack-ranked, and delivered continuously',0.5,1),(4,'We create measurable experiments from hypotheses and use production data to assess results',0.05,1),(5,'None of these',0,1),(6,'Production incidents are handled by operations staff. Only If all operational procedures have failed to restore service level, then an escalation process may be started on an exception basis to engage developers',0.25,2),(7,'Devs and Ops do a joint retrospective to review the root cause of an issue once its resolved. They plan how to prevent a recurrence',0.25,2),(8,'They collaborate in real time, in a physical team room/war room or online chat room, IRC, IM, or other messaging channel',0.25,2),(9,'Developers rotate on-call duty and, when on duty, are paged to participate without delay in troubleshooting live site incidents related to their area of code',0.25,2),(10,'Not applicable because Ops handles production incidents independently',0,2),(11,'Using open source components requires legal review and management approval',0.1,3),(12,'We keep a central package store of approved open source components',0.1,3),(13,'We automatically scan open source components for vulnerabilities and IP before taking a dependency on them',0.3,3),(14,'Our release pipeline automatically scans OSS component versions before every deployment and we remediate any newly discovered vulnerabilities',0.5,3),(15,'We do not have a policy about using open source',0,3),(16,'Water Fall',0.1,4),(17,'Water-Scrum-Fall',0.1,4),(18,'Agile',0.5,4),(19,'Scrum',0.3,4),(20,'None',0,4),(21,'Yes',1,5),(22,'No',0,5),(23,'Yes',1,6),(24,'No',0,6),(25,'Source Files',0.4,7),(26,'Build Files',0.3,7),(27,'Configuration Files',0.2,7),(28,'Dependancies File',0.1,7),(29,'Yes',1,8),(30,'No',0,8),(31,'Yes',1,9),(32,'No',0,9),(33,'Version control system',0.4,10),(34,'Artifactory',0.35,10),(35,'Other',0.25,10),(36,'Unit Testing',0.2,11),(37,'System Integration System',0.2,11),(38,'Load Testing',0.2,11),(39,'Security Checks',0.2,11),(40,'Infra Optimisation',0.2,11),(41,'Yes',1,12),(42,'No',0,12),(43,'Automated code deployment',0.35,13),(44,'Automated server provisioning',0.35,13),(45,'Microservice Architecture',0.3,13),(46,'None',0,13),(47,'Yes',1,14),(48,'No',0,14),(49,'managing artifact version in File System',0.05,15),(50,'managing artifact in the cloud repository',0.1,15),(51,'External artifactory manager',0.5,15),(52,'Managing artifact version in code version control system',0.35,15),(53,'None',0,15),(54,'Recreate: Version A is terminated then version B is rolled out',0.2,16),(55,'Ramped (also known as rolling-update or incremental): Version B is slowly rolled out and replacing version A',0.2,16),(56,'Blue/Green: Version B is released alongside version A, then the traffic is switched to version B',0.15,16),(57,'Canary: Version B is released to a subset of users, then proceed to a full rollout',0.15,16),(58,'A/B testing: Version B is released to a subset of users under the specific condition',0.15,16),(59,'Shadow: Version B receives real-world traffic alongside version A and doesnâ€™t impact the response',0.15,16),(60,'Yes',1,17),(61,'No',0,17),(62,'Yes',1,18),(63,'No',0,18),(64,'Yes',1,19),(65,'No',0,19),(66,'VM provisioning as per requirement',0.25,20),(67,'Creating a security baseline',0.25,20),(68,'Setting up an environment for applications',0.25,20),(69,'The configuration of virtual networks',0.25,20),(70,'Private Cloud Services',0.5,21),(71,'Public Cloud Services',0.5,21),(72,'None',0,21),(73,'Only basic integration is automated and using CI tools for triggering builds',0.2,22),(74,'To automate Critical processes, auto-triggered builds, automated tags and versioning',0.3,22),(75,'To manage all builds and deployments, Fully integrated including acceptance tests and performance parameters',0.5,22),(76,'We dont allow use of the public cloud',0.05,23),(77,'Teams are free to decide on their own to run their virtual machines',0.25,23),(78,'We allow use of the cloud (IaaS, PaaS & SaaS), as long as corporate data is secure',0.35,23),(79,'We strive for the best security, end-user experience and quality of service in a cloud-native manner',0.35,23),(80,'None of the above/not applicable',0,23),(81,'Yes',1,24),(82,'No',0,24),(83,'Yes',1,25),(84,'No',0,25),(85,'Yes',1,26),(86,'No',0,26),(87,'Yes',1,27),(88,'No',0,27),(89,'Yes',1,28),(90,'No',0,28),(91,'Yes',1,29),(92,'no',0,29),(93,'Yes',1,30),(94,'No',0,30);
/*!40000 ALTER TABLE `question_option` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_type`
--

LOCK TABLES `question_type` WRITE;
/*!40000 ALTER TABLE `question_type` DISABLE KEYS */;
INSERT INTO `question_type` VALUES (2,'multiple choice question'),(1,'single choice question');
/*!40000 ALTER TABLE `question_type` ENABLE KEYS */;
UNLOCK TABLES;

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
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_maturity`
--

LOCK TABLES `result_maturity` WRITE;
/*!40000 ALTER TABLE `result_maturity` DISABLE KEYS */;
INSERT INTO `result_maturity` VALUES (3,'Advanced'),(2,'Intermediate'),(1,'low');
/*!40000 ALTER TABLE `result_maturity` ENABLE KEYS */;
UNLOCK TABLES;

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
  `user_password` varchar(500) NOT NULL,
  `country_id` int(11) NOT NULL,
  `industry_type_id` int(11) NOT NULL,
  `company_size_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_id_UNIQUE` (`user_email`),
  KEY `country_id_idx` (`country_id`),
  KEY `fk_industry_id_idx` (`industry_type_id`),
  KEY `company_size_id_idx` (`company_size_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'amit','k','ak@gmail.com','`PD','$2a$10$Em.PI2pALNDGs4kTepyGZeegN7ECRB.e4FgSEIxtzsS1lte0ApFSS',12,4,1),(2,'admin','k','admin@gmail.com','PD','$2a$10$rH7dg8VM7BqGkq.By1DVcu5RH4/wArJD5G5AlogEergIcB0J0dqSW',12,2,1),(3,'Siddu','S','siddu@gmail.com','PD','$2a$10$S/MFKbtqcQeaUMUr0Ostzuxw//chBWBL92Wn1uKuvYUenwhgMl7eS',12,8,1),(4,'YO','K','yo@gmail.com','PD','$2a$10$BoJwLw0iD5RVHTynztvsxOs40BPd5e/UfexI6fxxwDHgWgV3iRhDa',12,2,1),(5,'qiueiq','ifosdoicj','jaisd@gmail.com','tsqwbhdb','$2a$10$5ibPUfVdQVYgJ2w4ZLwsGO.snDrEr/YWf8xcflMGbl9ubR4CpULM6',4,2,2),(6,'Rajanikant','Devmore','rajanikant@gmail.com','Prodevans','$2a$10$Yq5NQ/hZoDI0L/oVuz6n9.lVua4r4o5gB9nLMPJkPS9H0SROPfZoW',12,2,2),(7,'PK','K','pk@gmail.com','PD','$2a$10$1Nn0QWs5OQ7E68w8KBc4COx2qn4MoyvY1/Myt7u8eObqJCVaG9c/6',12,6,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-15 19:11:31


-- ------------------------------------------------------
-- Host: 127.0.0.1    Database: devops_assessment initial data
-- version : 1.0.0
-- ------------------------------------------------------

-- Contry data insersaction in the Country table
INSERT INTO `country` (`country_name`)
VALUES 
('Afghanistan'), ('Armenia'), ('Azerbaijan'), ('Bahrain'), ('Bangladesh'), ('Bhutan'), ('Brunei'), ('Cambodia'),
('China'),('Cyprus'), ('Georgia'), ('India'), ('Indonesia'), ('Iran'), ('Iraq'), ('Israel'), ('Japan'),
('Jordan'), ('Kazakhstan'), ('Kuwait'), ('Kyrgyzstan'), ('Laos'), ('Lebanon'), ('Malaysia'), ('Maldives'),
('Mongolia'), ('Myanmar (formerly Burma)'), ('Nepal'), ('North Korea'), ('Oman'), ('Pakistan'), ('Palestine'),
('Philippines'), ('Qatar'), ('Russia'), ('Saudi Arabia'), ('Singapore'), ('South Korea'), ('Sri Lanka'),
('Syria'), ('Taiwan'), ('Tajikistan'), ('Thailand'), ('Timor-Leste'), ('Turkey'), ('Turkmenistan'),
('United Arab Emirates (UAE)'), ('Uzbekistan'), ('Vietnam'), ('Yemen');


-- IT industry types
INSERT INTO `industry_type` (`industry_name`)
VALUES
('Agriculture, Forestry & Fishing'), ('Banking & Capital Markets'), ('Discrete Manufacturing'), ('Education'),
('Government'), ('Health'), ('Hospitality & Travel'), ('Information Technology'), ('Insurance'), ('Logistics'),
('Media &amp; Cable'), ('Nonprofit'), ('Other - Unsegmented'), ('Power & Utilities'), ('Process Mfg & Resources'), ('Professional Services'),
('Public Safety_Natl Security'), ('Retail and Consumer Goods'), ('Telecommunications');

-- Company size data insertion
INSERT INTO `company_size` (`company_size_id`, `size`) 
VALUES (1, '< 100 employees'),
(2, '100-500 employees'),
(3, '500-1000 employees'),
(4, '1000-5000 employees'),
(5, '5000 - 10000 employees'),
(6, '> 10000 employees');


-- Assessment Status data insertion
INSERT INTO `assessment_status` (`assessment_status_id`, `status`)
VALUES (1,'in progress'), (2, 'Done');


-- Question type data insersaction 
INSERT INTO `question_type` (`question_type_id`, `question_type`)
VALUES (1, 'single choice question'), (2, 'multiple choice question');


-- Question Category data insertion
INSERT INTO `question_category` (`category_id`, `category_name`)
VALUES (1, 'process_and_culture'), (2, 'build_process'), (3, 'deployment'), 
(4, 'infrastructure'), (5, 'technology_and_automation'), (6, 'monitoring_and_feedback');

-- Result Maturity data insertion
INSERT INTO `result_maturity` (`result_maturity_id`, `maturity_level`)
VALUES (1, 'low'), (2, 'Intermediate'), (3, 'Advanced');

-- Assessment Question data insertion
INSERT INTO `assessment_question` (`question_id`, `question`, `category_id`, `question_type_id`)
VALUES 
-- process_and_culture category
(1, 'How do you plan, prioritize and schedule work?', 1, 1),
(2, 'How do development and operations teams collaborate during a production issue?', 1, 2),
(3, 'What are your policies around open source software?', 1, 2),
(4, 'Which project development method is getting used by your company?', 1, 1),
(5, 'Do you follow devops culture?', 1, 1),

-- build_process category
(6, 'Do you use any Continuous Integration(CI) tool to orchestrate your builds?', 2, 1),
(7, 'Which files do you keep under version control?', 2, 2),
(8, 'Do you use any branching policy?', 2, 1),
(9, 'Do you use any strategy to review code changes?', 2, 1),
(10, 'How do you manage code dependencies across teams?', 2, 1),
(11, 'What does your team consider good testing?', 2, 2),
(12, 'Are you doing security testing?', 2, 1),

-- deployment
(13, 'Are you using automated continuous deployment(CD) strategy?', 3, 1),
(14, 'Have you provides the Disaster Recovery system', 3, 1),
(15, 'What rollback practices used by the operations team?', 3, 2),
(16, 'What types of deployment strategies used by the operations?', 3, 2),

-- infrastructure
(17, 'Have you automated an infrastructure building?', 4, 1),
(18, 'Do you have Iaas in your organization?', 4, 1),
(19, 'Are you doing infrastructure testing?', 4, 1),
(20, 'What are the components of the infrastructure uses automation?', 4, 2),
(21, 'Which cloud services your company is using?', 4, 1),

-- technology_and_automation
(22, 'Where are you using Continuous Integration and Continuous Delivery?', 5, 1),
(23, 'What is your policy for Cloud usage?', 5, 2),
(24, 'Do you use Automation Testing?', 5, 1),
(25, 'Do you use any tool for code review?', 5, 1),

-- monitoring_and_feedback
(26, 'Are you doing production server health monitoring ?', 6, 1),
(27, 'Are you doing threats analysis for the critical production environments?', 6, 1),
(28, 'Do you provides any Aleart system for server health or threat detection?', 6, 1),
(29, 'Do you have centeralized System audit report system ?', 6, 1),
(30, 'Do you have a system for crash summery?', 6, 1); 

-- Question Option data insertion
INSERT INTO `question_option` (`question_option_id`,`question_id`,`question_option`,`weightage`)
VALUES
-- process_and_culture category
(1, 1, 'By feature completion against specifications', 0.2),
(2, 1, 'In timeboxes such as sprints', 0.25),
(3, 1, 'We strive for a one-piece flow of product backlog items, stack-ranked, and delivered continuously', 0.5),
(4, 1, 'We create measurable experiments from hypotheses and use production data to assess results', 0.05),
(5, 1, 'None of these', 0),

(6, 2, 'Production incidents are handled by operations staff. Only If all operational procedures have failed to restore service level, then an escalation process may be started on an exception basis to engage developers', 0.25),
(7, 2, 'Devs and Ops do a joint retrospective to review the root cause of an issue once its resolved. They plan how to prevent a recurrence', 0.25),
(8, 2, 'They collaborate in real time, in a physical team room/war room or online chat room, IRC, IM, or other messaging channel', 0.25),
(9, 2, 'Developers rotate on-call duty and, when on duty, are paged to participate without delay in troubleshooting live site incidents related to their area of code', 0.25),
(10, 2, 'Not applicable because Ops handles production incidents independently',0),

(11,3,'Using open source components requires legal review and management approval',0.1),
(12,3,'We keep a central package store of approved open source components',0.1),
(13,3,'We automatically scan open source components for vulnerabilities and IP before taking a dependency on them',0.3),
(14,3,'Our release pipeline automatically scans OSS component versions before every deployment and we remediate any newly discovered vulnerabilities',0.5),
(15,3,'We do not have a policy about using open source',0),

(16,4,'Water Fall',0.1),
(17,4,'Water-Scrum-Fall',0.1),
(18,4,'Agile',0.5),
(19,4,'Scrum',0.3),
(20,4,'None',0),

(21,5,'Yes',1),
(22,5,'No',0),

-- build_process category
(23,6,'Yes',1),
(24,6,'No',0),

(25,7,'Source Files',0.4),
(26,7,'Build Files',0.3),
(27,7,'Configuration Files',0.2),
(28,7,'Dependancies File',0.1),

(29,8,'Yes',1),
(30,8,'No',0),

(31,9,'Yes',1),
(32,9,'No',0),

(33,10,'Version control system',0.4),
(34,10,'Artifactory',0.35),
(35,10,'Other',0.25),

(36,11,'Unit Testing',0.2),
(37,11,'System Integration System',0.2),
(38,11,'Load Testing',0.2),
(39,11,'Security Checks',0.2),
(40,11,'Infra Optimisation',0.2),

(41,12,'Yes',1),
(42,12,'No',0),

-- deployment
(43,13,'Automated code deployment',0.35),
(44,13,'Automated server provisioning',0.35),
(45,13,'Microservice Architecture',0.30),
(46,13,'None',0),

(47,14,'Yes',1),
(48,14,'No',0),

(49,15,'managing artifact version in File System',0.05),
(50,15,'managing artifact in the cloud repository',0.10),
(51,15,'External artifactory manager',0.5),
(52,15,'Managing artifact version in code version control system',0.35),
(53,15,'None',0),

(54,16,'Recreate: Version A is terminated then version B is rolled out',0.2),
(55,16,'Ramped (also known as rolling-update or incremental): Version B is slowly rolled out and replacing version A',0.2),
(56,16,'Blue/Green: Version B is released alongside version A, then the traffic is switched to version B',0.15),
(57,16,'Canary: Version B is released to a subset of users, then proceed to a full rollout',0.15),
(58,16,'A/B testing: Version B is released to a subset of users under the specific condition',0.15),
(59,16,'Shadow: Version B receives real-world traffic alongside version A and doesn’t impact the response',0.15),

-- infrastructure
(60,17,'Yes',1),
(61,17,'No',0),

(62,18,'Yes',1),
(63,18,'No',0),

(64,19,'Yes',1),
(65,19,'No',0),

(66,20,'VM provisioning as per requirement',0.25),
(67,20,'Creating a security baseline',0.25),
(68,20,'Setting up an environment for applications',0.25),
(69,20,'The configuration of virtual networks',0.25),

(70,21,'Private Cloud Services',0.5),
(71,21,'Public Cloud Services',0.5),
(72,21,'None',0),

-- technology_and_automation
(73,22,'Only basic integration is automated and using CI tools for triggering builds',0.2),
(74,22,'To automate Critical processes, auto-triggered builds, automated tags and versioning',0.3),
(75,22,'To manage all builds and deployments, Fully integrated including acceptance tests and performance parameters',0.5),

(76,23,'We dont allow use of the public cloud',0.05),
(77,23,'Teams are free to decide on their own to run their virtual machines',0.25),
(78,23,'We allow use of the cloud (IaaS, PaaS & SaaS), as long as corporate data is secure',0.35),
(79,23,'We strive for the best security, end-user experience and quality of service in a cloud-native manner',0.35),
(80,23,'None of the above/not applicable',0),

(81,24,'Yes',1),
(82,24,'No',0),

(83,25,'Yes',1),
(84,25,'No',0),

-- monitoring_and_feedback

(85,26,'Yes',1),
(86,26,'No',0),

(87,27,'Yes',1),
(88,27,'No',0),

(89,28,'Yes',1),
(90,28,'No',0),

(91,29,'Yes',1),
(92,29,'no',0),

(93,30,'Yes',1),
(94,30,'No',0);
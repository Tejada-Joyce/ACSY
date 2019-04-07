-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2019 at 07:53 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cit361`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `first_name`, `last_name`, `email`, `password`) VALUES
(1, 'Lucio', 'Perea', 'lucio.perea@acsy.com', 'testing'),
(2, 'Rocio', 'Palao', 'rocio.palao@acsy.com', 'testing');

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--

CREATE TABLE `assignments` (
  `id` int(11) NOT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT '0',
  `group_id` int(11) NOT NULL,
  `consultant_id` int(11) NOT NULL,
  `histories_counter` int(11) NOT NULL DEFAULT '0',
  `total_histories` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignments`
--

INSERT INTO `assignments` (`id`, `completed`, `group_id`, `consultant_id`, `histories_counter`, `total_histories`) VALUES
(10, 0, 2, 7, 0, 6),
(11, 0, 9, 8, 0, 6),
(12, 0, 14, 6, 0, 7);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `first_name`, `last_name`, `phone`, `email`, `status`, `group_id`) VALUES
(1, 'Raymond', 'Connelly', '575-379-8485x21144', 'skeeling@example.com', 7, 1),
(3, 'Loren', 'Green', '06889943993', 'donnie82@example.net', 7, 3),
(4, 'Harold', 'King', '177.711.9876', 'cynthia43@example.net', 4, 4),
(5, 'Maurine', 'Rempel', '+42(0)0826583178', 'bbayer@example.com', 6, 5),
(7, 'Hal', 'Koelpin', '(514)698-9293', 'johns.elisabeth@example.com', 4, 7),
(9, 'Anabelle', 'Hammes', '316.408.8300x2097', 'wroob@example.net', 9, 9),
(10, 'Pauline', 'Jerde', '1-792-152-3860x506', 'maggio.ettie@example.com', 5, 10),
(11, 'Dorothy', 'Yost', '043.413.9046x9122', 'katrine.romaguera@example.net', 7, 11),
(12, 'Triston', 'Hudson', '(153)292-0667x594', 'don22@example.com', 6, 12),
(14, 'Florine', 'Luettgen', '460-948-5331x662', 'fahey.ella@example.net', 6, 14),
(16, 'Lea', 'Gleason', '(315)515-9036', 'ramon56@example.org', 4, 1),
(17, 'Piper', 'Vandervort', '141.123.5309x364', 'pfeffer.hardy@example.org', 4, 2),
(18, 'Maximus', 'Abernathy', '233-186-5446', 'jalon.waters@example.com', 2, 3),
(19, 'Maddison', 'McLaughlin', '709.734.6968x99647', 'lemuel.lakin@example.org', 8, 4),
(20, 'Percy', 'Stokes', '460.444.7575', 'spadberg@example.net', 7, 5),
(22, 'Otis', 'Schamberger', '1-334-072-8668', 'beatty.anissa@example.org', 7, 7),
(23, 'Chase', 'Dare', '+90(4)4211800598', 'carey39@example.org', 7, 8),
(24, 'Shawn', 'Ratke', '625.104.2657x5971', 'twalsh@example.net', 5, 9),
(25, 'Odessa', 'Bayer', '310-104-2023x111', 'reynolds.dina@example.org', 6, 10),
(26, 'Price', 'Sanford', '(888)306-5086x99548', 'jodie84@example.com', 2, 11),
(27, 'Braeden', 'Mertz', '+98(2)2060399645', 'obrekke@example.com', 7, 12),
(29, 'Geraldine', 'Schumm', '915.228.3579x907', 'o\'kon.enos@example.org', 4, 14),
(31, 'Demetrius', 'Cruickshank', '(073)423-0837x13659', 'della14@example.com', 5, 1),
(32, 'Alessandro', 'Windler', '(837)014-5747x7249', 'eullrich@example.org', 2, 2),
(33, 'Caterina', 'Kassulke', '07875804417', 'rgutmann@example.org', 5, 3),
(34, 'Alene', 'Friesen', '391-433-7722', 'thilll@example.org', 8, 4),
(35, 'Terry', 'Morissette', '(766)921-9816x8113', 'obecker@example.net', 1, 5),
(37, 'Ashleigh', 'Schoen', '1-979-252-7643x794', 'adoyle@example.com', 1, 7),
(38, 'Beulah', 'Kihn', '(129)541-6468x64710', 'mandy62@example.org', 7, 8),
(39, 'Lue', 'Green', '035-485-6747', 'elinor.cremin@example.org', 3, 9),
(40, 'Antonina', 'Weissnat', '650.216.7827', 'elinore10@example.net', 3, 10),
(41, 'Dorian', 'Ward', '1-811-515-0794x3460', 'schamberger.breanna@example.org', 8, 11),
(42, 'Jermaine', 'Mayert', '421.659.3220x99896', 'manley78@example.com', 5, 12),
(44, 'Lauriane', 'Upton', '(965)928-3098', 'domenico13@example.com', 2, 14),
(46, 'Stacey', 'Bergstrom', '09163797451', 'ferry.rhianna@example.net', 6, 1),
(47, 'Leilani', 'Bechtelar', '038-130-2163x29478', 'adam97@example.com', 6, 2),
(48, 'Gia', 'Herzog', '220-597-1828x832', 'bernadine84@example.com', 9, 3),
(49, 'Velva', 'Nader', '321.992.1897x3576', 'jnikolaus@example.org', 6, 4),
(50, 'Magali', 'Doyle', '(162)461-7769', 'ursula40@example.com', 9, 5),
(52, 'Kris', 'Gerlach', '09218507385', 'mraz.mossie@example.org', 2, 7),
(53, 'Johnny', 'Brekke', '(267)237-7082x101', 'luigi42@example.org', 6, 8),
(54, 'Alfredo', 'Lemke', '197-860-8798', 'ettie.tillman@example.net', 4, 9),
(55, 'Genesis', 'Rodriguez', '601-771-6831x5575', 'rodrigo.schiller@example.net', 2, 10),
(56, 'Lela', 'Feil', '+30(9)1851402022', 'wcasper@example.com', 7, 11),
(59, 'Yasmin', 'Christiansen', '833.279.6101x00356', 'morgan.corkery@example.com', 5, 14),
(61, 'Felipa', 'Bode', '975.887.9185', 'allan.goldner@example.net', 6, 1),
(62, 'Florida', 'Heidenreich', '1-762-358-9239x627', 'kupton@example.net', 6, 2),
(63, 'Tillman', 'Toy', '805.003.9070', 'gmarks@example.org', 7, 3),
(64, 'Eusebio', 'Kautzer', '841.167.3757', 'miller.mose@example.com', 1, 4),
(65, 'Harrison', 'Weimann', '09554327196', 'schuster.keshaun@example.org', 3, 5),
(67, 'Jonathan', 'Doyle', '512.406.3085x068', 'sally68@example.com', 6, 7),
(68, 'Christian', 'Daniel', '704-542-8662x4391', 'dejon96@example.com', 3, 8),
(70, 'Carter', 'Greenfelder', '465.410.9811x443', 'franecki.carli@example.org', 8, 10),
(71, 'Beth', 'Hane', '1-582-091-0318', 'daniel.ellen@example.com', 6, 11),
(72, 'Roosevelt', 'Pfannerstill', '082.403.8002x83113', 'ifeest@example.net', 6, 12),
(74, 'Trent', 'Hayes', '(930)984-7562', 'abigayle.hamill@example.net', 1, 14),
(76, 'Furman', 'Sipes', '1-568-962-3269', 'unique52@example.com', 8, 1),
(77, 'Vince', 'Stoltenberg', '021.614.0983', 'soledad43@example.net', 1, 2),
(78, 'Allison', 'Kihn', '169-098-9748x64601', 'dmurazik@example.org', 8, 3),
(79, 'Mylene', 'Koepp', '1-760-456-2765x8034', 'brandon88@example.com', 8, 4),
(80, 'Jayden', 'O\'Reilly', '1-226-996-4307x883', 'helmer72@example.com', 7, 5),
(82, 'Keyon', 'Durgan', '04953806672', 'kblick@example.org', 6, 7),
(83, 'Joe', 'Gleichner', '(816)248-7821', 'ymclaughlin@example.net', 6, 8),
(84, 'Wilfred', 'Labadie', '789-563-9672x980', 'johan81@example.com', 5, 9),
(85, 'Pauline', 'Nitzsche', '+53(3)5334035599', 'donnell60@example.org', 9, 10),
(86, 'Amiya', 'Kub', '798-999-9096x2708', 'lmorar@example.org', 9, 11),
(87, 'Jeremy', 'Schowalter', '993.433.6881x40386', 'cweimann@example.com', 3, 12),
(89, 'Gunnar', 'Stanton', '03512402455', 'weber.althea@example.net', 8, 14),
(91, 'Delaney', 'Ziemann', '+80(7)5348558814', 'rusty.white@example.com', 6, 1),
(92, 'Osborne', 'Koepp', '+07(2)0013210516', 'kiara80@example.com', 3, 2),
(93, 'Hattie', 'Murray', '688.440.7935', 'melisa82@example.com', 9, 3),
(94, 'Arvel', 'Jacobi', '1-668-321-9307', 'kiel52@example.org', 6, 4),
(95, 'Angus', 'Wiza', '(126)664-8177x980', 'jerod.bogisich@example.net', 7, 5),
(97, 'Nellie', 'Morissette', '311-428-3868x9188', 'jacynthe59@example.net', 6, 7),
(98, 'Icie', 'Auer', '977-984-0231x5548', 'benny.smith@example.org', 5, 8),
(99, 'Jakob', 'Swift', '1-721-301-7571', 'zfahey@example.org', 8, 9),
(100, 'Maddison', 'Lockman', '114.992.7668', 'edgar51@example.com', 6, 10),
(101, 'Edward', 'Cannon', '512.895.3456', 'edward34@example.net', 0, 10),
(102, 'Robin', 'Brand', '9965584679', 'robin678@example.com', 0, 14),
(104, 'Brenda', 'Morales', '512.895.3456', 'brenda.mor@gmail.com', 0, 4);

-- --------------------------------------------------------

--
-- Table structure for table `consultants`
--

CREATE TABLE `consultants` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consultants`
--

INSERT INTO `consultants` (`id`, `first_name`, `last_name`, `phone`, `email`, `password`, `status`) VALUES
(5, 'Alexander', 'Vasquez', '51986542155', 'alexander.vasquez@acsy.com', 'vasquezACSY', 1),
(6, 'Victor', 'Soto', '51997782391', 'victor.soto@acsy.com', 'sotoACSY', 0),
(7, 'Silvia', 'Rondon', '51947111235', 'silvia.rondon@acsy.com', 'rondonACSY', 0),
(8, 'Mauro', 'Gomez', '51959619989', 'mauro.gomez@acsy.com', 'gomezACSY', 0),
(10, 'Mario', 'Rodriguez', '51986542256', 'mario.rodriguez@acsy.com', 'rodriguezACSY', 0),
(12, 'Maria', 'Linares', '51989478521', 'maria.linares@acsy.com', 'linaresACSY', 0);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `name`, `status`) VALUES
(1, 'important', 1),
(2, 'doloremque', 0),
(3, 'corrupti', 1),
(4, 'architecto', 1),
(5, 'sint', 1),
(7, 'sit', 1),
(8, 'velite', 1),
(9, 'mollitia', 0),
(10, 'similique', 1),
(11, 'id', 1),
(12, 'voluptatum', 1),
(14, 'eos', 0),
(16, 'molliti', 0),
(20, 'group', 1),
(25, 'cents', 1),
(26, 'main', 1);

-- --------------------------------------------------------

--
-- Table structure for table `histories`
--

CREATE TABLE `histories` (
  `id` int(11) NOT NULL,
  `description` text,
  `rate` int(11) DEFAULT NULL,
  `assignment_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `done` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `histories`
--

INSERT INTO `histories` (`id`, `description`, `rate`, `assignment_id`, `client_id`, `done`) VALUES
(21, NULL, 0, 10, 17, 0),
(22, NULL, 0, 10, 32, 0),
(23, NULL, 0, 10, 47, 0),
(24, NULL, 0, 10, 62, 0),
(25, NULL, 0, 10, 77, 0),
(26, NULL, 0, 10, 92, 0),
(27, NULL, 0, 11, 9, 0),
(28, NULL, 0, 11, 24, 0),
(29, NULL, 0, 11, 39, 0),
(30, NULL, 0, 11, 54, 0),
(31, NULL, 0, 11, 84, 0),
(32, NULL, 0, 11, 99, 0),
(33, NULL, 0, 12, 14, 0),
(34, NULL, 0, 12, 29, 0),
(35, NULL, 0, 12, 44, 0),
(36, NULL, 0, 12, 59, 0),
(37, NULL, 0, 12, 74, 0),
(38, NULL, 0, 12, 89, 0),
(39, NULL, 0, 12, 102, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`),
  ADD KEY `consultant_id` (`consultant_id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`);

--
-- Indexes for table `consultants`
--
ALTER TABLE `consultants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `histories`
--
ALTER TABLE `histories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `assignment_id` (`assignment_id`),
  ADD KEY `client_id` (`client_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `assignments`
--
ALTER TABLE `assignments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT for table `consultants`
--
ALTER TABLE `consultants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `histories`
--
ALTER TABLE `histories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `assignments_ibfk_2` FOREIGN KEY (`consultant_id`) REFERENCES `consultants` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`);

--
-- Constraints for table `histories`
--
ALTER TABLE `histories`
  ADD CONSTRAINT `histories_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `histories_ibfk_2` FOREIGN KEY (`assignment_id`) REFERENCES `assignments` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

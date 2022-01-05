-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2022 at 04:07 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jordanian_people`
--

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `Person_Id` int(10) NOT NULL,
  `First_Name` varchar(10) NOT NULL,
  `Last_Name` varchar(10) NOT NULL,
  `Birth_Date` date NOT NULL,
  `Adress` varchar(10) NOT NULL,
  `Vaccine_Tipe` varchar(10) DEFAULT NULL,
  `Dose_no` int(10) DEFAULT NULL,
  `Vaccine_City` varchar(10) DEFAULT NULL,
  `Appointment_Date` date DEFAULT NULL,
  `Appointment_Time` time DEFAULT NULL,
  `Last_Appointment_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`Person_Id`, `First_Name`, `Last_Name`, `Birth_Date`, `Adress`, `Vaccine_Tipe`, `Dose_no`, `Vaccine_City`, `Appointment_Date`, `Appointment_Time`, `Last_Appointment_Date`) VALUES
(1, 'a', 'a', '1990-12-10', 'Amman', 'Sinopharm', 1, 'Mafraq', '2022-02-17', '10:36:00', '2022-01-04'),
(2, 'b', 'b', '2001-12-05', 'Irbid', 'Pfizer', 3, 'Irbid', NULL, NULL, '2022-01-05'),
(3, 'ahmad', 'ahmad', '2011-08-24', 'Irbid', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'sdf', 'sdss', '2015-12-09', 'Amman', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'ahmad', 'ahmad', '1991-12-18', 'Irbid', 'Pfizer', 3, 'Irbid', '2022-03-24', '12:42:00', '2022-01-05'),
(6, 'abood', 'ahmad', '2002-01-25', 'Irbid', 'Sinopharm', 2, 'Mafraq', NULL, NULL, '2022-01-05'),
(7, 'hussain', 'talal', '1994-01-21', 'Amman', NULL, NULL, 'Irbid', '2022-01-05', '12:42:00', NULL),
(8, 'mohammed', 'ahmad', '1993-01-29', 'Zarqa', NULL, NULL, 'Amman', '2022-01-05', '12:42:00', NULL),
(9, 'taysser', 'gamal', '1985-01-17', 'Irbid', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`Person_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2023 at 07:29 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `monitrackerdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `walletName` varchar(30) NOT NULL,
  `transactId` int(11) NOT NULL,
  `transactValue` double NOT NULL,
  `transactCategory` varchar(100) NOT NULL,
  `transactDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `isExpense` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`walletName`, `transactId`, `transactValue`, `transactCategory`, `transactDate`, `isExpense`) VALUES
('Penjualan', 22, 185000, 'Minuman', '2023-01-16 06:01:57', 0),
('Stock', 19, 55000, 'bahan baku', '2023-01-16 05:59:31', 1),
('Penjualan', 21, 130000, 'Kue tart', '2023-01-16 06:01:01', 0),
('Stock', 18, 250000, 'beli bahan baku', '2023-01-01 00:40:41', 1),
('Stock', 17, 250000, 'beli bahan baku', '2023-01-01 00:40:41', 0);

-- --------------------------------------------------------

--
-- Table structure for table `userwallet`
--

CREATE TABLE `userwallet` (
  `walletId` int(11) NOT NULL,
  `walletName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `wallettransaction`
--

CREATE TABLE `wallettransaction` (
  `walletName` varchar(30) NOT NULL,
  `transactId` int(11) NOT NULL,
  `transactValue` double NOT NULL,
  `transactCategory` varchar(60) NOT NULL,
  `transactDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `isExpense` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`walletName`,`transactId`),
  ADD KEY `transactId` (`transactId`);

--
-- Indexes for table `userwallet`
--
ALTER TABLE `userwallet`
  ADD PRIMARY KEY (`walletId`);

--
-- Indexes for table `wallettransaction`
--
ALTER TABLE `wallettransaction`
  ADD PRIMARY KEY (`walletName`,`transactId`),
  ADD UNIQUE KEY `transactId` (`transactId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `transactId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `userwallet`
--
ALTER TABLE `userwallet`
  MODIFY `walletId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `wallettransaction`
--
ALTER TABLE `wallettransaction`
  MODIFY `transactId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

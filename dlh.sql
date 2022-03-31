-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ago 14, 2019 alle 17:01
-- Versione del server: 10.3.16-MariaDB
-- Versione PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dlh`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `paziente`
--

CREATE TABLE `paziente` (
  `CF` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `dataRegistrazione` date NOT NULL DEFAULT current_timestamp(),
  `eta` int(11) NOT NULL,
  `percentualeInvalidita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `paziente`
--

INSERT INTO `paziente` (`CF`, `nome`, `cognome`, `dataRegistrazione`, `eta`, `percentualeInvalidita`) VALUES
(1, 'alessandro', 'bianchi', '2019-08-01', 25, 0),
(2, 'andrea', 'verdi', '2019-08-02', 15, 30),
(3, 'dario', 'rossi', '2019-08-02', 15, 0),
(4, 'claudio', 'ferrari', '2019-08-05', 75, 12),
(5, 'giuseppe', 'marino', '2019-08-06', 25, 0),
(6, 'pippo', 'colombo', '2019-08-11', 12, 34),
(7, 'topolino', 'bruno', '2019-08-03', 78, 89),
(8, 'pluto', 'costa', '2019-08-02', 36, 65),
(9, 'cesare', 'villa', '2019-08-11', 15, 0),
(10, 'gino', 'grasso', '2019-08-26', 54, 78),
(11, 'prova', 'prova', '2019-08-14', 67, 34),
(12, 'prova1', 'prova1', '2019-08-14', 75, 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

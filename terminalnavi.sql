-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 11, 2025 alle 14:16
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `terminalnavi`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `buonoconsegna`
--

CREATE TABLE `buonoconsegna` (
  `idBuono` int(11) NOT NULL,
  `merce_id` int(11) NOT NULL,
  `camionista_id` int(11) NOT NULL,
  `camion_id` varchar(20) NOT NULL,
  `telefonoCliente` varchar(20) DEFAULT NULL,
  `dataRitiro` date DEFAULT NULL,
  `pesoRitirato` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `marca` varchar(50) DEFAULT NULL,
  `targa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `camionista`
--

CREATE TABLE `camionista` (
  `idCamionista` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `targaCamion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `idFornitore` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `nomeAzienda` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `guidacamion`
--

CREATE TABLE `guidacamion` (
  `idCamionista` int(11) NOT NULL,
  `targa` varchar(20) NOT NULL,
  `dataInizio` date NOT NULL,
  `dataFine` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `merce`
--

CREATE TABLE `merce` (
  `idMerce` int(11) NOT NULL,
  `tipologia` varchar(100) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `volume` double DEFAULT NULL,
  `condizioniConservazione` varchar(100) DEFAULT NULL,
  `polizza_id` int(11) DEFAULT NULL,
  `idFornitore` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `idNave` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `polizza`
--

CREATE TABLE `polizza` (
  `idPolizza` int(11) NOT NULL,
  `franchigiaGiorni` int(11) DEFAULT NULL,
  `fornitore` varchar(100) DEFAULT NULL,
  `destinazione` varchar(100) DEFAULT NULL,
  `portoCarico_id` int(11) DEFAULT NULL,
  `viaggio_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `idPorto` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `nazione` varchar(100) DEFAULT NULL,
  `linea` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ruolo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `idViaggio` int(11) NOT NULL,
  `idNave` int(11) DEFAULT NULL,
  `dataPartenza` date DEFAULT NULL,
  `dataArribamento` date DEFAULT NULL,
  `portoPartenza_id` int(11) DEFAULT NULL,
  `portoArrivo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `buonoconsegna`
--
ALTER TABLE `buonoconsegna`
  ADD PRIMARY KEY (`idBuono`),
  ADD KEY `merce_id` (`merce_id`),
  ADD KEY `camionista_id` (`camionista_id`),
  ADD KEY `camion_id` (`camion_id`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `camionista`
--
ALTER TABLE `camionista`
  ADD PRIMARY KEY (`idCamionista`),
  ADD KEY `targaCamion` (`targaCamion`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`idFornitore`);

--
-- Indici per le tabelle `guidacamion`
--
ALTER TABLE `guidacamion`
  ADD PRIMARY KEY (`idCamionista`,`targa`,`dataInizio`),
  ADD KEY `targa` (`targa`);

--
-- Indici per le tabelle `merce`
--
ALTER TABLE `merce`
  ADD PRIMARY KEY (`idMerce`),
  ADD KEY `polizza_id` (`polizza_id`),
  ADD KEY `idFornitore` (`idFornitore`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`idNave`);

--
-- Indici per le tabelle `polizza`
--
ALTER TABLE `polizza`
  ADD PRIMARY KEY (`idPolizza`),
  ADD KEY `portoCarico_id` (`portoCarico_id`),
  ADD KEY `viaggio_id` (`viaggio_id`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`idPorto`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`username`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`idViaggio`),
  ADD KEY `idNave` (`idNave`),
  ADD KEY `portoPartenza_id` (`portoPartenza_id`),
  ADD KEY `portoArrivo_id` (`portoArrivo_id`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buonoconsegna`
--
ALTER TABLE `buonoconsegna`
  ADD CONSTRAINT `buonoconsegna_ibfk_1` FOREIGN KEY (`merce_id`) REFERENCES `merce` (`idMerce`),
  ADD CONSTRAINT `buonoconsegna_ibfk_2` FOREIGN KEY (`camionista_id`) REFERENCES `camionista` (`idCamionista`),
  ADD CONSTRAINT `buonoconsegna_ibfk_3` FOREIGN KEY (`camion_id`) REFERENCES `camion` (`targa`);

--
-- Limiti per la tabella `camionista`
--
ALTER TABLE `camionista`
  ADD CONSTRAINT `camionista_ibfk_1` FOREIGN KEY (`targaCamion`) REFERENCES `camion` (`targa`);

--
-- Limiti per la tabella `guidacamion`
--
ALTER TABLE `guidacamion`
  ADD CONSTRAINT `guidacamion_ibfk_1` FOREIGN KEY (`idCamionista`) REFERENCES `camionista` (`idCamionista`),
  ADD CONSTRAINT `guidacamion_ibfk_2` FOREIGN KEY (`targa`) REFERENCES `camion` (`targa`);

--
-- Limiti per la tabella `merce`
--
ALTER TABLE `merce`
  ADD CONSTRAINT `merce_ibfk_1` FOREIGN KEY (`polizza_id`) REFERENCES `polizza` (`idPolizza`),
  ADD CONSTRAINT `merce_ibfk_2` FOREIGN KEY (`idFornitore`) REFERENCES `fornitore` (`idFornitore`);

--
-- Limiti per la tabella `polizza`
--
ALTER TABLE `polizza`
  ADD CONSTRAINT `polizza_ibfk_1` FOREIGN KEY (`portoCarico_id`) REFERENCES `porto` (`idPorto`),
  ADD CONSTRAINT `polizza_ibfk_2` FOREIGN KEY (`viaggio_id`) REFERENCES `viaggio` (`idViaggio`);

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`idNave`) REFERENCES `nave` (`idNave`),
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`portoPartenza_id`) REFERENCES `porto` (`idPorto`),
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`portoArrivo_id`) REFERENCES `porto` (`idPorto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

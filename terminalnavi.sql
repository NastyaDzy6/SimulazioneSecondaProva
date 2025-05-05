-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 05, 2025 alle 21:14
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
-- Struttura della tabella `buono_consegna`
--

CREATE TABLE `buono_consegna` (
  `id_buono` int(11) NOT NULL,
  `id_merce` int(11) NOT NULL,
  `id_camionista` int(11) NOT NULL,
  `targa` varchar(20) NOT NULL,
  `telefono_cliente` varchar(20) DEFAULT NULL,
  `data_ritiro` date DEFAULT NULL,
  `peso_ritirato` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `camionista`
--

CREATE TABLE `camionista` (
  `id_camionista` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `guida_camion`
--

CREATE TABLE `guida_camion` (
  `id_camionista` int(11) NOT NULL,
  `targa` varchar(20) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `merce`
--

CREATE TABLE `merce` (
  `id_merce` int(11) NOT NULL,
  `tipologia` varchar(100) DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `volume` decimal(5,2) DEFAULT NULL,
  `condizioni_conservazione` varchar(255) DEFAULT NULL,
  `id_polizza` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `id_nave` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `polizza`
--

CREATE TABLE `polizza` (
  `id_polizza` int(11) NOT NULL,
  `franchigia_giorni` int(11) DEFAULT NULL,
  `fornitore` varchar(100) DEFAULT NULL,
  `destinazione` varchar(100) DEFAULT NULL,
  `porto_carico` int(11) DEFAULT NULL,
  `id_viaggio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `id_porto` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `nazione` varchar(100) NOT NULL,
  `linea` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `id_viaggio` int(11) NOT NULL,
  `id_nave` int(11) NOT NULL,
  `data_partenza` date NOT NULL,
  `data_arribamento` date DEFAULT NULL,
  `porto_partenza` int(11) NOT NULL,
  `porto_arrivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `buono_consegna`
--
ALTER TABLE `buono_consegna`
  ADD PRIMARY KEY (`id_buono`),
  ADD KEY `id_merce` (`id_merce`),
  ADD KEY `id_camionista` (`id_camionista`),
  ADD KEY `targa` (`targa`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `camionista`
--
ALTER TABLE `camionista`
  ADD PRIMARY KEY (`id_camionista`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indici per le tabelle `guida_camion`
--
ALTER TABLE `guida_camion`
  ADD PRIMARY KEY (`id_camionista`,`targa`,`data_inizio`),
  ADD KEY `targa` (`targa`);

--
-- Indici per le tabelle `merce`
--
ALTER TABLE `merce`
  ADD PRIMARY KEY (`id_merce`),
  ADD KEY `id_polizza` (`id_polizza`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`id_nave`);

--
-- Indici per le tabelle `polizza`
--
ALTER TABLE `polizza`
  ADD PRIMARY KEY (`id_polizza`),
  ADD KEY `porto_carico` (`porto_carico`),
  ADD KEY `id_viaggio` (`id_viaggio`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`id_porto`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`id_viaggio`),
  ADD KEY `id_nave` (`id_nave`),
  ADD KEY `porto_partenza` (`porto_partenza`),
  ADD KEY `porto_arrivo` (`porto_arrivo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buono_consegna`
--
ALTER TABLE `buono_consegna`
  ADD CONSTRAINT `buono_consegna_ibfk_1` FOREIGN KEY (`id_merce`) REFERENCES `merce` (`id_merce`),
  ADD CONSTRAINT `buono_consegna_ibfk_2` FOREIGN KEY (`id_camionista`) REFERENCES `camionista` (`id_camionista`),
  ADD CONSTRAINT `buono_consegna_ibfk_3` FOREIGN KEY (`targa`) REFERENCES `camion` (`targa`);

--
-- Limiti per la tabella `guida_camion`
--
ALTER TABLE `guida_camion`
  ADD CONSTRAINT `guida_camion_ibfk_1` FOREIGN KEY (`id_camionista`) REFERENCES `camionista` (`id_camionista`),
  ADD CONSTRAINT `guida_camion_ibfk_2` FOREIGN KEY (`targa`) REFERENCES `camion` (`targa`);

--
-- Limiti per la tabella `merce`
--
ALTER TABLE `merce`
  ADD CONSTRAINT `merce_ibfk_1` FOREIGN KEY (`id_polizza`) REFERENCES `polizza` (`id_polizza`);

--
-- Limiti per la tabella `polizza`
--
ALTER TABLE `polizza`
  ADD CONSTRAINT `polizza_ibfk_1` FOREIGN KEY (`porto_carico`) REFERENCES `porto` (`id_porto`),
  ADD CONSTRAINT `polizza_ibfk_2` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`id_viaggio`);

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`id_nave`) REFERENCES `nave` (`id_nave`),
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`porto_partenza`) REFERENCES `porto` (`id_porto`),
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`id_porto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 02 jan. 2025 à 17:49
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `echec`
--

-- --------------------------------------------------------

--
-- Structure de la table `contient`
--

CREATE TABLE `contient` (
  `id_piece` int(11) NOT NULL,
  `id_deck` int(11) NOT NULL,
  `id_joueur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `deck`
--

CREATE TABLE `deck` (
  `id_deck` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `id_joueur` int(11) NOT NULL,
  `deckprincipal` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `id_joueur` int(11) NOT NULL,
  `identifiant` varchar(30) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `argent` varchar(50) DEFAULT NULL,
  `NbPartiesG` int(11) NOT NULL,
  `NbPartiesJ` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

CREATE TABLE `partie` (
  `id_partie` smallint(6) NOT NULL,
  `tour_joueur` tinyint(1) DEFAULT NULL,
  `id_deck` int(11) NOT NULL,
  `id_deck2` int(11) NOT NULL,
  `id_joueur` int(11) NOT NULL,
  `id_joueur2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `possède`
--

CREATE TABLE `possède` (
  `id_joueur` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `nombre` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `variable_partie`
--

CREATE TABLE `variable_partie` (
  `id_piece` int(11) NOT NULL,
  `id_partie` smallint(6) NOT NULL,
  `id_piece_partie` smallint(6) NOT NULL,
  `Couleur` varchar(50) DEFAULT NULL,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `pouvoir_utilise` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contient`
--
ALTER TABLE `contient`
  ADD PRIMARY KEY (`id_piece`,`id_deck`,`id_joueur`),
  ADD KEY `id_deck` (`id_deck`),
  ADD KEY `contient_ibfk_3` (`id_joueur`);

--
-- Index pour la table `deck`
--
ALTER TABLE `deck`
  ADD PRIMARY KEY (`id_deck`,`id_joueur`),
  ADD KEY `id_joueur` (`id_joueur`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`id_joueur`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`id_partie`),
  ADD KEY `id_joueur` (`id_joueur`,`id_joueur2`) USING BTREE,
  ADD KEY `id_deck` (`id_deck`,`id_deck2`) USING BTREE,
  ADD KEY `partie_ibfk_3` (`id_deck2`),
  ADD KEY `partie_ibfk_4` (`id_joueur2`);

--
-- Index pour la table `possède`
--
ALTER TABLE `possède`
  ADD PRIMARY KEY (`id_joueur`,`id_piece`);

--
-- Index pour la table `variable_partie`
--
ALTER TABLE `variable_partie`
  ADD PRIMARY KEY (`id_piece`,`id_partie`,`id_piece_partie`),
  ADD KEY `id_partie` (`id_partie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `deck`
--
ALTER TABLE `deck`
  MODIFY `id_deck` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `id_joueur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- AUTO_INCREMENT pour la table `partie`
--
ALTER TABLE `partie`
  MODIFY `id_partie` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contient`
--
ALTER TABLE `contient`
  ADD CONSTRAINT `contient_ibfk_2` FOREIGN KEY (`id_deck`) REFERENCES `deck` (`id_deck`) ON DELETE CASCADE,
  ADD CONSTRAINT `contient_ibfk_3` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id_joueur`) ON DELETE CASCADE;

--
-- Contraintes pour la table `deck`
--
ALTER TABLE `deck`
  ADD CONSTRAINT `deck_ibfk_1` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id_joueur`) ON DELETE CASCADE;

--
-- Contraintes pour la table `partie`
--
ALTER TABLE `partie`
  ADD CONSTRAINT `partie_ibfk_1` FOREIGN KEY (`id_deck`) REFERENCES `deck` (`id_deck`) ON DELETE CASCADE,
  ADD CONSTRAINT `partie_ibfk_2` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id_joueur`) ON DELETE CASCADE,
  ADD CONSTRAINT `partie_ibfk_3` FOREIGN KEY (`id_deck2`) REFERENCES `deck` (`id_deck`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partie_ibfk_4` FOREIGN KEY (`id_joueur2`) REFERENCES `joueur` (`id_joueur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `possède`
--
ALTER TABLE `possède`
  ADD CONSTRAINT `possède_ibfk_1` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id_joueur`) ON DELETE CASCADE;

--
-- Contraintes pour la table `variable_partie`
--
ALTER TABLE `variable_partie`
  ADD CONSTRAINT `variable_partie_ibfk_2` FOREIGN KEY (`id_partie`) REFERENCES `partie` (`id_partie`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

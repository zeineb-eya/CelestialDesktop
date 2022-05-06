-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 06 mai 2022 à 10:32
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `celestial`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom_utilisateur` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `prenom_utilisateur` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `adresse_utilisateur` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mail_utilisateur` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero_utilisateur` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `nom_role_id` int(11) DEFAULT 1,
  `roles` longtext COLLATE utf8mb4_unicode_ci DEFAULT 'CLIENT' COMMENT '(DC2Type:json)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom_utilisateur`, `prenom_utilisateur`, `adresse_utilisateur`, `mail_utilisateur`, `password`, `numero_utilisateur`, `post_id`, `nom_role_id`, `roles`) VALUES
(3, 'fatima', 'fatima', 'Bizerte', 'fatima@mail.com', 'aaa', '1122334', NULL, 8, 'CLIENT'),
(28, 'yacoubi', 'fatima', 'Bizerte', 'Zeeeineb', 'mirror', '111111111', NULL, NULL, ''),
(32, 'aziz', 'mahdi', 'Tunis', 'mehdi@esprit.tn', 'mirror', '111111111', NULL, NULL, ''),
(38, 'tfnomU.getText()', 'tfprenomU.getText()', 'Ariana', 'tfmailU.getText()', 'tfpasswordU.getText()', 'tfnumtelU.getText()', NULL, NULL, ''),
(39, 'AZIZ', 'cherif', 'Tunis', 'mail@maol.com', 'plain', '33344', NULL, NULL, ''),
(40, 'mahdi', 'mahdi', 'Bizerte', 'mehdi@mail.com', '123', '3344', NULL, NULL, ''),
(57, 'aa', 'aaa', 'Tunis', 'aaa', 'aaa', 'aaa', NULL, NULL, ''),
(59, '', '', 'Ariana', '', '', '', NULL, NULL, ''),
(132, 'Miloud', 'Mahdi', 'Jendouba', 'mahdi@mail.com', '112233', '66778899', NULL, 0, 'CLIENT'),
(133, 'yaacoubi', 'Fatima', 'Sousse', 'kk@mail.com', '778899', '8899000', NULL, 0, 'CLIENT'),
(134, 'Yaacoubi', 'Mohamed Hedi', 'Zaghouan', 'k@k.com', '8899', '888990', NULL, 0, 'CLIENT'),
(138, 'Said', 'Jalel', 'Bizerte', 'jalel.g@mail.com', '222', 'U8U8', NULL, 0, 'CLIENT'),
(145, 'Bachoucb', 'Zeineb', 'Zaghouan', 'fahs@gmail.cpm', 'fahs', '77889900', NULL, 0, 'CLIENT'),
(146, 'a', 'fa', 'Bizerte', 'a@mail.com', 'a', '6677', NULL, 0, 'CLIENT'),
(147, 'zertyui', 'azertyu', 'rhghjn', 'dfghjkl@fgh/.tyu', 'mpolikjuhgf', 'zertghj', NULL, 0, 'CLIENT'),
(148, 'dfghj', 'sdfghjk', 'sdfghj', 'dfghj', 'dfhj', 'SDFHJ', NULL, 0, 'CLIENT'),
(149, 'ZEFRHJKKJH', 'LKJHDS', 'AZEFGHJK', 'AZERTHJKL', 'AZERTHJK', 'AZERGHJK', NULL, 0, 'CLIENT'),
(151, 'Fatima Yaacoubi', 'Fatima Yaacoubi@gmail.com', '', 'Fatima Yaacoubi', 'Fatima Yaacoubi0000', '', NULL, 0, 'CLIENT');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_8D93D649A9C31E6E` (`mail_utilisateur`),
  ADD KEY `IDX_8D93D6494B89032C` (`post_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=154;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_8D93D649238C2964` FOREIGN KEY (`nom_role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FK_8D93D6494B89032C` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

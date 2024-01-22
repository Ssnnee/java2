-- CREATE DATABASE 'demo';
-- USE demo;
--
-- create table users (
-- 	id  int(3) NOT NULL AUTO_INCREMENT,
-- 	name varchar(120) NOT NULL,
-- 	email varchar(220) NOT NULL,
-- 	country varchar(120),
-- 	PRIMARY KEY (id)
-- );

-- Création de la base de données
CREATE DATABASE gestiondr2;

-- Utilisation de la base de données
USE gestiondr2;

-- Création de la table facture
CREATE TABLE facture (
    ID INT NOT NULL AUTO_INCREMENT,
    Reference VARCHAR(255) NOT NULL,
    Designation VARCHAR(255) NOT NULL,
    Prix_Unitaire DECIMAL(10, 2) NOT NULL,
    Quantite INT NOT NULL,
    Prix_HT DECIMAL(10, 2) NOT NULL,
    Remise DECIMAL(5, 2),
    Prix_TTC DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (ID)
);



CREATE DATABASE QLCH;

GO

USE QLCH;

GO

CREATE TABLE Menu (
    menuID INT PRIMARY KEY,
    menuNAME VARCHAR(50) NOT NULL
);

CREATE TABLE Brand (
	brandID INT PRIMARY KEY,
	brandNAME VARCHAR(50) NOT NULL
);

CREATE TABLE Clothes (
    clothesID VARCHAR(50) PRIMARY KEY,
	clothesNUMBER INT NOT NULL IDENTITY(1, 1),
    menuID INT,
    clothesNAME VARCHAR(50) NOT NULL,
    clothesPRICE INT NOT NULL,
    brandID INT,
    CONSTRAINT fk_menu FOREIGN KEY (menuID) REFERENCES Menu(menuID),
    CONSTRAINT fk_brand FOREIGN KEY (brandID) REFERENCES Brand(brandID)
);

CREATE TABLE Size (
    Size VARCHAR(10),
	clothesID VARCHAR(50),
    sizeQUANTITY INT NOT NULL,
    CONSTRAINT fk_clothes FOREIGN KEY (clothesID) REFERENCES Clothes(clothesID)
);

GO
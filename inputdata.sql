INSERT INTO Menu (menuID, menuNAME)
VALUES (1, 'T-SHIRTS'),
       (2, 'SHIRTS'),
       (3, 'SHORTS'),
       (4, 'JACKET'),
       (5, 'GLASSES');
INSERT INTO Brand (brandID, brandNAME)
VALUES (1, 'Guggi'),
       (2, 'BalanceAka'),
       (3, 'LuonVuiTuoi'),
	   (4, 'Nieked');
INSERT INTO Clothes (clothesID, menuID, clothesNAME, clothesPRICE, brandID)
VALUES ('TSGG', 1, 'SonGuggi', 20, 1),
       ('MTBA', 2, 'Tri5M', 30, 2),
       ('TLVT', 3, 'TuanLuonVuiTuoi', 25, 3),
       ('MQNK', 4, 'QuanNieked', 50, 4);

INSERT INTO Size (Size, clothesID, sizeQUANTITY)
VALUES ('S', 'TSGG', 10),
       ('M', 'TSGG', 15),
       ('L', 'TSGG', 20),
       ('S', 'MTBA', 12),
       ('M', 'MTBA', 18),
       ('L', 'MTBA', 22),
       ('S', 'TLVT', 8),
       ('M', 'TLVT', 12),
       ('L', 'TLVT', 15),
	   ('S', 'MQNK', 8),
       ('M', 'MQNK', 12),
       ('L', 'MQNK', 15);
SELECT Clothes.clothesID, Clothes.clothesNAME, Size.Size, Size.sizeQUANTITY
FROM Clothes
INNER JOIN Size ON Clothes.clothesID = Size.clothesID;
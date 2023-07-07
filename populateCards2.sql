DELETE FROM carddetails;
DELETE FROM cardgeneration;
DELETE FROM pokemonname;

INSERT INTO pokemonname (pNameId, pName, powerType) VALUES ("mew001", "Mew", "EX");
INSERT INTO pokemonname (pNameId, pName, powerType) VALUES ("mew002", "Mew", "V");
INSERT INTO pokemonname (pNameId, pName, powerType) VALUES ("mew003", "Mew", "VMAX");
INSERT INTO pokemonname (pNameId, pName, powerType) VALUES ("mew004", "Mew", "VSTAR");
INSERT INTO pokemonname (pNameId, pName, powerType) VALUES ("mew005", "Mew", "GX");

INSERT INTO cardgeneration (pNameId, cardGen) VALUES ("mew001", "SWSH1");
INSERT INTO cardgeneration (pNameId, cardGen) VALUES ("mew001", "Scarlet2");
INSERT INTO cardgeneration (pNameId, cardGen) VALUES ("mew001", "Violet3");
INSERT INTO cardgeneration (pNameId, cardGen) VALUES ("mew002", "VSU1");
INSERT INTO cardgeneration (pNameId, cardGen) VALUES ("mew002", "VSU2");
INSERT INTO cardgeneration (pNameId, cardGen) VALUES ("mew002", "VSU3");

/* CardDetails table ----------------------------------------------------------------*/
INSERT INTO carddetails (pNameId, platformBought, priceBought) VALUES ("mew001", "eBay", 125.00);
INSERT INTO carddetails (pNameId, platformBought, priceBought) VALUES ("mew001", "carousell", 115.00);
INSERT INTO carddetails (pNameId, platformBought, priceBought) VALUES ("mew001", "eBay", 120.00);
INSERT INTO carddetails (pNameId, platformBought, priceBought) VALUES ("mew002", "Mercari", 120.00);
INSERT INTO carddetails (pNameId, platformBought, priceBought) VALUES ("mew002", "Buyee", 121.00);
INSERT INTO carddetails (pNameId, platformBought, priceBought) VALUES ("mew002", "Shopee", 122.00);
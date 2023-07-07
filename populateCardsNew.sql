
DELETE FROM Details;

DELETE FROM PokemonSpecies;

DELETE FROM Powertype;


INSERT INTO PowerType VALUES ("EX", "EX Pokémon have the ability to Mega-evolve");
INSERT INTO PowerType VALUES ("GX", "GX cards have a special GX move that may only be used once per game");
INSERT INTO PowerType VALUES ("V", "Pokemon V includes Pokemon V, VMAX, VSTAR, and V-UNION");
INSERT INTO PowerType VALUES ("VSTAR", "You can only use a VSTAR Power once per game");
INSERT INTO PowerType VALUES ("VMAX", "Vmax cards are meant to mimic Dynamax and Gigantamax mechanics that appear in the Galar region");

INSERT INTO Pokemonspecies (spcName, spcBackground, spcType) VALUES ("Mew", "Mew is the original Mythical Pokémon", "Psychic");
INSERT INTO PokemonSpecies (spcName, spcBackground, spcType) VALUES ("Pikachu", "yellow, mouse creature with electrical abilities", "Electric");
INSERT INTO PokemonSpecies (spcName, spcBackground, spcType) VALUES ("Charizard", "Evolved from Charmeleon, fire breathing dragon", "Fire/Flying");

/* CardDetails table ----------------------------------------------------------------*/
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Mew", "EX", "eBay", "PKGU", 125.00, 200.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Mew", "EX", "Carousell", "pokeSG", 115.00, 200.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Mew", "EX", "eBay", "PKGU", 130.00, 200.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Pikachu", "V", "eBay", "Tokyo1", 50.00, 150.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Pikachu", "VSTAR", "eBay", "Tokyo1", 51.00, 151.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Pikachu", "VMAX", "eBay", "Tokyo1", 52.00, 152.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Charizard", "VSTAR", "Mercari", "Europe1", 800.00, 1000.00, 1);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Pikachu", "EX", "Buyee", "Jap1", 53.00, 153.00, 2);
INSERT INTO Details (spcName, pwrType, buyFrom, shopName, buyPrice, highSellPrice, quantity) VALUES ("Pikachu", "VMAX", "Carousell", "PokeSG", 54.00, 154.00, 3);

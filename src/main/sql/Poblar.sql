-- POBLAR ROLES
INSERT INTO ROLES (descripcion)
VALUES ('Admin');
INSERT INTO ROLES (descripcion)
VALUES ('Gerente');
INSERT INTO ROLES (descripcion)
VALUES ('Cliente');

-- POBLAR CLIENTES_APP
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(1014217248, 'Andres Galindo', 'ing.agaguilera@gmail.com', 'andres', 1);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(1014230230, 'Felipe Gomez', 'felipe.gomez@gmail.com', 'felipe', 1);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(1014120120, 'Oscar Ardila', 'oscar.ardila@gmail.com', 'ojcar', 1);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(1014111222, 'David Galvis', 'david.galvis@gmail.com', 'david', 1);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(28000123, 'Juancho de la Espriella', 'juancho@gmail.com', 'juan', 3);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(29000123, 'Silvestre Dangond', 'silvestre@gmail.com', 'silvestre', 3);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(30123123, 'Diomedes Diaz', 'diome@gmail.com', 'diomedes', 3);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(88888888, 'Pepe Perez', 'pepe.perez@gmail.com', 'pepe', 3);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(99999999, 'Maria Moreno', 'maria.moreno@gmail.com', 'maria', 3);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(1010654321, 'Juan Rodriguez', 'juan.rodriguez@gmail.com', 'juan', 2);
INSERT INTO CLIENTS_APP(id_clients, name_client_app, email, password, Roles_id)
VALUES(1111234567, 'Pedro Ramirez', 'pedro.ramirez@gmail.com', 'pedro', 2);

-- POBLAR SUPERMARKETS
INSERT  INTO SUPERMARKETS (name_supermarket)
VALUES ('Exito');
INSERT  INTO SUPERMARKETS (name_supermarket)
VALUES ('Olimpica');
INSERT  INTO SUPERMARKETS (name_supermarket)
VALUES ('Cencosud');
INSERT  INTO SUPERMARKETS (name_supermarket)
VALUES ('Makro');

-- POBLAR STORES
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (1, 15, 20, 'Exito Calle 170');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (1, 15, 20, 'Exito Calle 80');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (1, 15, 20, 'Exito Americas');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (2, 15, 20, 'Jumbo Calle 80');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (2, 15, 20, 'Jumbo Titan');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (2, 15, 20, 'Jumbo Calle 19');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (3, 15, 20, 'Olimpica Calle 53');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (3, 15, 20, 'Olimpica Mazuren');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (3, 15, 20, 'Olimpica Calle 100');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (4, 15, 20, 'Makro Av. Boyaca');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (4, 15, 20, 'Makro Villa del Rio');
INSERT  INTO STORES (SuperMarket_id, longitud, latitud, name_store)
VALUES (4, 15, 20, 'Makro Cumará');

-- POBLAR ZONES
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (1, 1, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (1, 1, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (1, 1, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (1, 1, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (1, 1, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (1, 1, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (4, 2, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (4, 2, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (4, 2, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (4, 2, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (4, 2, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (4, 2, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (7, 3, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (7, 3, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (7, 3, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (7, 3, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (7, 3, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (7, 3, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (10, 4, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (10, 4, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (10, 4, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (10, 4, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (10, 4, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (10, 4, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (2, 1, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (2, 1, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (2, 1, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (2, 1, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (2, 1, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (2, 1, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (5, 2, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (5, 2, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (5, 2, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (5, 2, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (5, 2, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (8, 3, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (8, 3, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (8, 3, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (8, 3, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (8, 3, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (8, 3, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (11, 4, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (11, 4, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (11, 4, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (11, 4, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (11, 4, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (11, 4, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (3, 1, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (3, 1, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (3, 1, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (3, 1, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (3, 1, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (3, 1, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (6, 2, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (6, 2, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (6, 2, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (6, 2, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (6, 2, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (9, 3, 'Salud');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (12, 4, 'Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (12, 4, 'No Perecederos');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (12, 4, 'Aseo');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (12, 4, 'Ropa');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (12, 4, 'Tecnologia');
INSERT INTO ZONES (STORES_id_stores, STORES_SuperMarket_id, name_zone) 
VALUES (12, 4, 'Salud');


-- POBLAR PRODUCTS
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77010, 'Coca Cola', 2400, 20, 600, 1, 1, 1);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77011, 'Chocorramo', 1100, 30, 100, 9, 4, 2);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77012, 'Jabon Ariel', 3500, 15, 500, 15, 7, 3);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77013, 'Atun Van Camps', 2800, 25, 450, 22, 10, 4);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77014, 'Frijol Bola Roja', 9000, 10, 1000, 28, 2, 1);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77015, 'Shampoo', 15000, 30, 600, 35, 5, 2);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77016, 'Sprite', 4500, 20, 2500, 15, 7, 3);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77017, 'Carne de Res', 11000, 25, 1000, 44, 11, 4);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77018, 'Carne de Cerdo', 7000, 30, 1000, 50, 3, 1);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77019, 'Papas Margarita', 1500, 30, 150, 56, 6, 2);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77020, 'Salchichas en Lata', 3400, 30, 400, 63, 9, 3);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77021, 'Rexona', 15000, 20, 180, 70, 12, 4);
INSERT  INTO PRODUCTS (id_productos, name_product, buyPrice, Percentage, weight, ZONES_id_zones, ZONES_STORES_id_stores, ZONES_STORES_SuperMarket_id)
VALUES (77010, 'Coca Cola', 2400, 20, 600, 1, 1, 1);




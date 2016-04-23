-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-04-09 14:39:14.183




-- tables
-- Table CLIENTS_APP
CREATE TABLE CLIENTS_APP (
    id_clients int  NOT NULL,
    name_client_app varchar(25)  NOT NULL,
    email varchar(32)  NOT NULL,
    password varchar(25)  NOT NULL,
    Roles_id int  NOT NULL,
    CONSTRAINT id PRIMARY KEY (id_clients)
)ENGINE=InnoDB;

-- Table CLIENTS_MARKETS
CREATE TABLE CLIENTS_MARKETS (
    SUPERMARKETS_id int  NOT NULL,
    CLIENTS_APP_id int  NOT NULL,
    CONSTRAINT CLIENTS_MARKETS_pk PRIMARY KEY (SUPERMARKETS_id,CLIENTS_APP_id)
)ENGINE=InnoDB;

-- Table INVOICES
CREATE TABLE INVOICES (
    id_invoices int  NOT NULL AUTO_INCREMENT,
    date_invoice timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CLIENTS_APP_id int  NOT NULL,
    STORES_id_stores int  NOT NULL,
    STORES_SuperMarket_id int  NOT NULL,
    CONSTRAINT INVOICES_pk PRIMARY KEY (id_invoices)
)ENGINE=InnoDB;

-- Table LINE_INVOICE
CREATE TABLE LINE_INVOICE (
    INVOICES_id_invoices int  NOT NULL,
    PRODUCTS_id_productos int  NOT NULL,
    CONSTRAINT LINE_INVOICE_pk PRIMARY KEY (INVOICES_id_invoices,PRODUCTS_id_productos)
)ENGINE=InnoDB;

-- Table PRODUCTS
CREATE TABLE PRODUCTS (
    
    id_productos int  NOT NULL,
    name_product varchar(25)  NOT NULL,
    buyPrice int  NOT NULL,
    Percentage int  NOT NULL,
    weight int  NOT NULL,
    ZONES_id_zones int  NOT NULL,
    ZONES_STORES_id_stores int  NOT NULL,
    ZONES_STORES_SuperMarket_id int  NOT NULL,
    CONSTRAINT PRODUCTS_pk PRIMARY KEY (id_productos)
)ENGINE=InnoDB;

-- Table ROLES
CREATE TABLE ROLES (
    id_roles int  NOT NULL AUTO_INCREMENT,
    descripcion varchar(25)  NOT NULL,
    CONSTRAINT ROLES_pk PRIMARY KEY (id_roles)
)ENGINE=InnoDB;

-- Table STORES
CREATE TABLE STORES (
    id_stores int  NOT NULL AUTO_INCREMENT,
    SuperMarket_id int  NOT NULL,
    longitud int  NOT NULL,
    latitud int  NOT NULL,
    name_store varchar(25)  NOT NULL,
    CONSTRAINT STORES_pk PRIMARY KEY (id_stores,SuperMarket_id)
)ENGINE=InnoDB;

-- Table SUPERMARKETS
CREATE TABLE SUPERMARKETS (
    id_supermarkets int  NOT NULL AUTO_INCREMENT,
    name_supermarket varchar(25)  NOT NULL,
    CONSTRAINT SUPERMARKETS_pk PRIMARY KEY (id_supermarkets)
)ENGINE=InnoDB;

-- Table ZONES
CREATE TABLE ZONES (
    id_zones int  NOT NULL AUTO_INCREMENT,
    STORES_id_stores int  NOT NULL,
    STORES_SuperMarket_id int  NOT NULL,
    name_zone varchar(25)  NOT NULL,
    CONSTRAINT ZONES_pk PRIMARY KEY (id_zones,STORES_id_stores,STORES_SuperMarket_id)
)ENGINE=InnoDB;





-- foreign keys
-- Reference:  CLIENTS_MARKETS_CLIENTS_APP (table: CLIENTS_MARKETS)

ALTER TABLE CLIENTS_MARKETS ADD CONSTRAINT CLIENTS_MARKETS_CLIENTS_APP FOREIGN KEY CLIENTS_MARKETS_CLIENTS_APP (CLIENTS_APP_id)
    REFERENCES CLIENTS_APP (id_clients);
-- Reference:  CLIENTS_MARKETS_SUPERMARKETS (table: CLIENTS_MARKETS)

ALTER TABLE CLIENTS_MARKETS ADD CONSTRAINT CLIENTS_MARKETS_SUPERMARKETS FOREIGN KEY CLIENTS_MARKETS_SUPERMARKETS (SUPERMARKETS_id)
    REFERENCES SUPERMARKETS (id_supermarkets);
-- Reference:  ClientsApp_Roles (table: CLIENTS_APP)

ALTER TABLE CLIENTS_APP ADD CONSTRAINT ClientsApp_Roles FOREIGN KEY ClientsApp_Roles (Roles_id)
    REFERENCES ROLES (id_roles);
-- Reference:  INVOICES_CLIENTS_APP (table: INVOICES)

ALTER TABLE INVOICES ADD CONSTRAINT INVOICES_CLIENTS_APP FOREIGN KEY INVOICES_CLIENTS_APP (CLIENTS_APP_id)
    REFERENCES CLIENTS_APP (id_clients);
-- Reference:  INVOICES_STORES (table: INVOICES)

ALTER TABLE INVOICES ADD CONSTRAINT INVOICES_STORES FOREIGN KEY INVOICES_STORES (STORES_id_stores,STORES_SuperMarket_id)
    REFERENCES STORES (id_stores,SuperMarket_id);
-- Reference:  LINE_INVOICE_INVOICES (table: LINE_INVOICE)

ALTER TABLE LINE_INVOICE ADD CONSTRAINT LINE_INVOICE_INVOICES FOREIGN KEY LINE_INVOICE_INVOICES (INVOICES_id_invoices)
    REFERENCES INVOICES (id_invoices);
-- Reference:  LINE_INVOICE_PRODUCTS (table: LINE_INVOICE)

ALTER TABLE LINE_INVOICE ADD CONSTRAINT LINE_INVOICE_PRODUCTS FOREIGN KEY LINE_INVOICE_PRODUCTS (PRODUCTS_id_productos)
    REFERENCES PRODUCTS (id_productos);
-- Reference:  PRODUCTS_ZONES (table: PRODUCTS)

ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_ZONES FOREIGN KEY PRODUCTS_ZONES (ZONES_id_zones,ZONES_STORES_id_stores,ZONES_STORES_SuperMarket_id)
    REFERENCES ZONES (id_zones,STORES_id_stores,STORES_SuperMarket_id);
-- Reference:  Store_SuperMarket (table: STORES)

ALTER TABLE STORES ADD CONSTRAINT Store_SuperMarket FOREIGN KEY Store_SuperMarket (SuperMarket_id)
    REFERENCES SUPERMARKETS (id_supermarkets);
-- Reference:  ZONES_STORES (table: ZONES)

ALTER TABLE ZONES ADD CONSTRAINT ZONES_STORES FOREIGN KEY ZONES_STORES (STORES_id_stores,STORES_SuperMarket_id)
    REFERENCES STORES (id_stores,SuperMarket_id);



-- End of file.

rename table CLIENTS_APP to clients_app;
rename table CLIENTS_MARKETS to clients_markets;
rename table INVOICES to invoices;
rename table LINE_INVOICE to line_invoice;
rename table PRODUCTS to products;
rename table ROLES to roles;
rename table STORES to stores;
rename table SUPERMARKETS to supermarkets;
rename table ZONES to zones;
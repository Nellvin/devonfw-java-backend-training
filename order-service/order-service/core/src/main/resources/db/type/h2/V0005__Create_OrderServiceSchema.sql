	CREATE TABLE Item (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name                VARCHAR(255) NOT NULL,
  description         VARCHAR(255),
  price               DOUBLE NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT UC_Item_name UNIQUE(name)
);

CREATE TABLE Customer (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  firstname		 VARCHAR(255),
  lastname			 VARCHAR(255),
  PRIMARY KEY (ID)
);

CREATE TABLE OrderSummary (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  price			 DOUBLE,
  ownerId 			 BIGINT NOT NULL,
  creationDate		 DATE NOT NULL,
  status			 VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_OrderSummary_owner FOREIGN KEY (ownerId) REFERENCES Customer(ID)
);

CREATE TABLE OrderPosition (
  orderId             BIGINT NOT NULL,
  itemId 			 BIGINT NOT NULL,
  CONSTRAINT FK_OrderPosition_order FOREIGN KEY (orderId) REFERENCES OrderSummary(ID),
CONSTRAINT FK_OrderPosition_item FOREIGN KEY (itemId) REFERENCES Item(ID)

);



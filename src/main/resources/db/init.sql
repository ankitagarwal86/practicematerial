DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id                VARCHAR(30) NOT NULL PRIMARY KEY,
  name              VARCHAR(50) NOT NULL,
  basePrice         INTEGER NOT NULL,
  pricePerKg        DOUBLE NOT NULL,
  pricePerZone      DOUBLE NOT NULL,
  maxWeightInGrams  BIGINT NOT NULL
);

INSERT INTO product VALUES ('SERVICE_PACKAGE', 'Service Package', 50, 20.3, 10.8, 20000);
INSERT INTO product VALUES ('COURIER', 'Courier', 100, 30.1, 0, 30000);
DROP TABLE IF EXISTS Transaction;
 
CREATE TABLE Transaction (
  customer_id long not null,
  transaction_date date NOT NULL,
  item_id long not null,
  quantity int NOT NULL,
  item_price double NOT NULL,
  PRIMARY KEY(customer_id, transaction_date, item_id)
);
CREATE TABLE subitem (
  pjo_subitemid bigint(20) NOT NULL AUTO_INCREMENT,
  pjo_subitem varchar(255),
  pjo_itemid bigint(20),
  PRIMARY KEY (pjo_subitemid),
  FOREIGN KEY (pjo_itemid) REFERENCES item(pjo_itemid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

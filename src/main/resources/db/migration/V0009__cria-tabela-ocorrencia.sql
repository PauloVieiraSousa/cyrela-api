CREATE TABLE ocorrencia (
  pjo_ticketnumber bigint(20) NOT NULL AUTO_INCREMENT,
  pjo_clienteid bigint(20),
  pjo_bandeira varchar(255) DEFAULT null,
  pjo_ambiente  varchar(255) DEFAULT null,
  pjo_description  varchar(255) DEFAULT null,
  pjo_dataatendimento TIMESTAMP null,
  pjo_itemid bigint(20),
  pjo_subitemid bigint(20),
  PRIMARY KEY (pjo_ticketnumber),
  FOREIGN KEY (pjo_itemid) REFERENCES item(pjo_itemid),
  FOREIGN KEY (pjo_subitemid) REFERENCES subitem(pjo_subitemid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

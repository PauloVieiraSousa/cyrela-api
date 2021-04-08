CREATE TABLE agenda (
  pjo_agendaid bigint(20) NOT NULL AUTO_INCREMENT,
  pjo_subject varchar(255) DEFAULT null,
  pjo_clienteid bigint(20),
  pjo_actualstart TIMESTAMP null,
  pjo_actualend TIMESTAMP null,
  PRIMARY KEY (pjo_agendaid),
  FOREIGN KEY (pjo_clienteid) REFERENCES clientes(pjo_clienteid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


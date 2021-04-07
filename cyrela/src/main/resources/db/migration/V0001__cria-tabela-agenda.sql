CREATE TABLE agenda (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  subject varchar(255) DEFAULT null,
  pjo_empreendimentoid bigint(20) NOT NULL,
  pjo_blocoid bigint(20) NOT NULL,
  pjo_unidadeid bigint(20) NOT NULL,
  pjo_tipodeatividade varchar(50) not null,
  actualstart time not null,
  actualend time not null,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


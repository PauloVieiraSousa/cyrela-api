CREATE TABLE ocorrencia (
  ticketnumber bigint(20) NOT NULL AUTO_INCREMENT,
  pjo_clientedaunidade varchar(255) DEFAULT null,
  pjo_empreendimentoid bigint(20) NOT NULL,
  pjo_bloco bigint(20) NOT NULL,
  pjo_unidade  bigint(20) NOT NULL,
  pjo_bandeira varchar(255) DEFAULT null,
  description  varchar(255) DEFAULT null,
  PRIMARY KEY (ticketnumber)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

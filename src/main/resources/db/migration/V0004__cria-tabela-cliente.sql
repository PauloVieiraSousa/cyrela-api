CREATE TABLE clientes (
  pjo_clienteid bigint(20) not null AUTO_INCREMENT,
  pjo_nome varchar(255),
  pjo_empreendimentoid bigint(20),
  pjo_unidadeid bigint(20),
  pjo_blocoid bigint(20),
  pjo_datagarantia TIMESTAMP null,
  PRIMARY KEY (pjo_clienteid),
  FOREIGN KEY (pjo_empreendimentoid) REFERENCES empreendimento(pjo_empreendimentoid),
  FOREIGN KEY (pjo_unidadeid) REFERENCES unidades(pjo_unidadeid),
  FOREIGN KEY (pjo_blocoid) REFERENCES blocos(pjo_blocoid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


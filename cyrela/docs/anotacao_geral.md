
### Problemas
- Eu tenho alguma coisa do minha estrutura do ano passado que eu posso reaproveitar para não gerar mais custo?
- Não tenho documentação tecnica!
- Equipe de TI bem enxuta.
- Bando de dados em servidores on-primises locaweb. (CRM, Banco SQL) / SAP

#### Funcionalidades CRM (Banco SQL)
 - Andamento da Obra
 - Assitencia tecnica
 - dados do cliente
 - documentos
 - logs
 - beneficios
 - vistoria

#### Funcionalidades SAP
- Extrato financeiro
- Informe d erendimentos
- Boletos
- Antecipação
	

### Desafio

Expor em forma de webservice as apis necessárias para o cliente efetuar o agendamento da vistoria, e a assistencia tecnica.

Extrutura de tabelas disponíveis:
- Atividade Agendada
	- actualstart - Data de inicio
	- actualend -  Data de termino
	- pjo_tipodeatividade - Tipo de atividade
	- subject - Assunto
	- pjo_empreendimentoid - Empreendimento
	- pjo_blocoid - Bloco
	- pjo_unidadeid - Unidade

- Ocorrencia
	- ticketnumber - Numero da Ocorrencia
	- pjo_clientedaunidade -  Cliente da Unidade
	- pjo_empreendimentoid - Empreendimento
	- pjo_bloco - Bloco
	- pjo_unidade - Unidade
	- pjo_bandeira - Bandeira
	- description - Descrição

### Protótipo

Baseado no protótio essas são as premissas para cada operação realizada sobre o agendamento e a assistencia tecnica.

- Agendamento de vistoria:
	- História
        Eu como cliente tenho a necessiade de agendar a vistoria no meu imovel na data e horario disponivel pela Cyrela.
        Informações extras:
		- Traz as datas e horario dispiníveis para cirela e para living.
		- O Cliente pode ter mais que um empreendimento para efetuar a vistoria.
		- Tudo que ele faz, necessita esta on-line no CRM, pq essas informações precisam estar registradas.

- Assistencia tecnica
    - História
    Eu como cliente tenho a necessidade de agendar a assistencia para algum problema tecnico ou defeito que tenho em meu apartamento.
    Informações extras:
        - Pagina 1 - Abertura do Chamado
            - Na abertura do chamado é necessário informar qual é o inicio da garantia para o cliente.
			- Cada item tem um tempo determinado para a garantia.
			- Cada subitem pode ter um tempo diferente.
			- o ambiente a qual esta o item.
			- E um texto (opcional) contendo uma breve descrição do problema.
			- O cliente pode anexar um ou mais arquivo.
		- Pagina 2 - Data e horario disponíveis
			- O cliente agenda a assitencia, nas datas e horarios disponíveis pela Cyrela
			- O cliente confirma a data e horario agendado
		- Página 3 - Agendamento confirmado
            - Dados de data e horario agendado
            - Dados do item agendado

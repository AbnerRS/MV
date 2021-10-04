-- criação das tabelas 
CREATE TABLE cliente
    ( ID_CLIENTE NUMBER(5),
      NOME VARCHAR2(40),
      TELEFONE VARCHAR2(20),
      ENDERECO VARCHAR2(100),
      DATA_INCLUSAO DATE);
     
--criação da chave primária da tabela cliente
ALTER TABLE cliente ADD CONSTRAINT cliente_id_pk 
	PRIMARY KEY(ID_CLIENTE);


CREATE TABLE cliente_pf
    ( ID_CLIENTE NUMBER(5),
      CPFVARCHAR2(15));
     
--criação da chave estrangeira  do cliente pessoa Física   
ALTER TABLE cliente_pf 
    ADD CONSTRAINT cliente_pf_fk 
    FOREIGN KEY(cliente_id) 
    REFERENCES cliente(ID_CLIENTE);
    
    
CREATE TABLE cliente_pj
    ( ID_CLIENTE NUMBER(5),
      CNPJ VARCHAR2(15),
      NIRE VARCHAR2(20),
      RAZAO VARCHAR2(100));
     
--criação da chave estrangeira  do cliente pessoa Jurídica   
ALTER TABLE cliente_pj 
    ADD CONSTRAINT cliente_pj_fk 
    FOREIGN KEY(cliente_id) 
    REFERENCES cliente(ID_CLIENTE);   
    
    
CREATE TABLE conta
    ( ID_CLIENTE NUMBER(5),
      ID_CONTA NUMBER(5),
      MOVIMENTACAO_CREDITO INTEGER,
      MOVIMENTACAO_DEBITO INTEGER,
      TOTAL_MOVIMENTACOES INTEGER,
      TOTAL_MOVIMENTACOES INTEGER,
      VALOR_MOVIMENTACOES FLOAT,
      SALDO_INICIAL FLOAT,
      SALDO_ATUAL FLOAT,
      DATA_CRIACAO DATE,
      ATIVA(5));
     
--criação da chave estrangeira  da conta 
ALTER TABLE conta 
    ADD CONSTRAINT conta_fk 
    FOREIGN KEY(cliente_id) 
    REFERENCES cliente(ID_CLIENTE);    

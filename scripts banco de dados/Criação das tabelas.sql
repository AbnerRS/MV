-- criação das tabelas 
CREATE TABLE cliente
    ( ID NUMBER(5),
      nome VARCHAR2(40),
      telefone VARCHAR2(20),
      endereco VARCHAR2(100),
       tipo VARCHAR2(20),
      data_inclusao DATE);
     
--criação da chave primária da tabela cliente
ALTER TABLE cliente ADD CONSTRAINT cliente_id_pk 
	PRIMARY KEY(ID);


CREATE TABLE cliente_pf
    ( ID NUMBER(5),
      cpf VARCHAR2(15));
     
--criação da chave estrangeira  do cliente pessoa Física   
ALTER TABLE cliente_pf 
    ADD CONSTRAINT cliente_pf_fk 
    FOREIGN KEY(cliente_id) 
    REFERENCES cliente(id);
    
    
CREATE TABLE cliente_pj
    ( ID NUMBER(5),
      cnpj VARCHAR2(15),
      nire VARCHAR2(20),
      razao VARCHAR2(100));
     
--criação da chave estrangeira  do cliente pessoa Jurídica   
ALTER TABLE cliente_pj 
    ADD CONSTRAINT cliente_pj_fk 
    FOREIGN KEY(cliente_id) 
    REFERENCES cliente(id);   
    
    
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
      DATA_CRIACAO DATE);
     
--criação da chave estrangeira  da conta 
ALTER TABLE conta 
    ADD CONSTRAINT conta_fk 
    FOREIGN KEY(cliente_id) 
    REFERENCES cliente(id);    

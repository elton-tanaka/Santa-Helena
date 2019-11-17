DROP DATABASE SantaHelena;
CREATE DATABASE SantaHelena;
USE SantaHelena;


CREATE TABLE IF NOT EXISTS Caixa (
  id INT NOT NULL AUTO_INCREMENT,
  quantia_dinheiro FLOAT NOT NULL,
  Usuario_id INT NOT NULL,
  CONSTRAINT pk_Caixa_id PRIMARY KEY (id),
  CONSTRAINT fk_Caixa_Usuario_id FOREIGN KEY (Usuario_id) REFERENCES Usuario (id)
  );
  
CREATE TABLE IF NOT EXISTS Usuario(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  Funcao_id INT NOT NULL,
  CONSTRAINT pk_Usuario_id PRIMARY KEY (id),
  CONSTRAINT fk_Usuario_Funcao_id FOREIGN KEY (Funcao_id) REFERENCES Funcao (id)
  );
  
  CREATE TABLE IF NOT EXISTS Funcao(
  id INT NOT NULL AUTO_INCREMENT,
  descricao	 VARCHAR(45) NOT NULL,
  CONSTRAINT pk_Funcao_id PRIMARY KEY (id)
  );
  
  CREATE TABLE IF NOT EXISTS Nota_Saida(
  id INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  Pagamento_id INT NOT NULL,
  Caixa_id INT NOT NULL,
  Caixa_Usuario_id INT NOT NULL,
  cpf_cliente VARCHAR(45) NULL,
  nome_cliente VARCHAR(45) NULL,
  CONSTRAINT pk_Nota_Saida_id PRIMARY KEY (id),
  CONSTRAINT fk_Nota_Saida_Pagamento_id FOREIGN KEY (Pagamento_id) REFERENCES Pagamento (id),
  CONSTRAINT fk_Nota_Saida_Caixa_id FOREIGN KEY (Caixa_id) REFERENCES Caixa (id)
  );
  
  CREATE TABLE IF NOT EXISTS Nota_Entrada(
  id INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  Pagamento_id INT NOT NULL,
  Usuario_id INT NOT NULL,
  Fornecedor_id INT NOT NULL,
  CONSTRAINT Nota_Entrada_id PRIMARY KEY (id),
  CONSTRAINT fk_Nota_Entrada_Pagamento_id FOREIGN KEY (Pagamento_id) REFERENCES Pagamento (id),
  CONSTRAINT fk_Nota_Entrada_Usuario_id FOREIGN KEY (Usuario_id) REFERENCES Usuario (id),
  CONSTRAINT fk_Nota_Entrada_Fornecedor_id FOREIGN KEY (Fornecedor_id) REFERENCES Fornecedor (id)
  );
  
  CREATE TABLE IF NOT EXISTS Pagamento(
  id INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(45) NOT NULL,
  parcela INT NOT NULL,
  CONSTRAINT pk_Pagamento_id PRIMARY KEY (id)
  );
  
  CREATE TABLE IF NOT EXISTS Item_Saida(
  id INT NOT NULL AUTO_INCREMENT,
  Produto_id INT NOT NULL,
  Nota_Saida_id INT NOT NULL,
  qntd_produto INT NOT NULL,
  preco_total INT NOT NULL,
  CONSTRAINT pk_Item_Saida_id PRIMARY KEY (id),
  CONSTRAINT fk_Produto_has_Nota_Saida_Produto_id FOREIGN KEY (Produto_id) REFERENCES Produto (id),
  CONSTRAINT fk_Produto_has_Nota_Saida_Nota_Saida_id FOREIGN KEY (Nota_Saida_id) REFERENCES Nota_Saida (id)
  );
  
  CREATE TABLE IF NOT EXISTS Item_Entrada(
  Produto_id INT NOT NULL,
  Nota_Entrada_id INT NOT NULL,
  qntd_produto INT NOT NULL,
  preco_total INT NOT NULL,
  CONSTRAINT pk_Item_Entrada_Produto_id PRIMARY KEY (Produto_id),
  CONSTRAINT fk_Produto_has_Nota_Entrada_Produto_id FOREIGN KEY (Produto_id) REFERENCES Produto (id),
  CONSTRAINT fk_Produto_has_Nota_Entrada_Nota_Entrada1_id FOREIGN KEY (Nota_Entrada_id) REFERENCES Nota_Entrada (id)
);
 
 CREATE TABLE IF NOT EXISTS Fornecedor(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cnpj VARCHAR(45) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  CONSTRAINT fk_Fornecedor_id PRIMARY KEY (id)
  );
  
  CREATE TABLE IF NOT EXISTS Produto(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  preco FLOAT NOT NULL,
  CONSTRAINT pk_Produto_id PRIMARY KEY (id)
  );
  
  CREATE TABLE IF NOT EXISTS Produto_Fornecedor(
  Produto_id INT NOT NULL,
  Fornecedor_id INT NOT NULL,
  CONSTRAINT fk_Produto_has_Fornecedor_Produto_id FOREIGN KEY (Produto_id) REFERENCES Produto (id),
  CONSTRAINT fk_Produto_has_Fornecedor_Fornecedor_id FOREIGN KEY (Fornecedor_id) REFERENCES Fornecedor (id)
  );
  
  CREATE TABLE IF NOT EXISTS Cliente (
  id INT NOT NULL AUTO_INCREMENT,
  cpf_cliente VARCHAR(45) NULL,
  nome_cliente VARCHAR(45) NULL,
  CONSTRAINT pk_Cliente_id PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS Cliente_Nota_Saida(
  Cliente_id INT NOT NULL,
  Nota_Saida_id INT NOT NULL,
  Nota_Saida_Pagamento_id INT NOT NULL,
  CONSTRAINT fk_Cliente_Nota_Saida_Nota_Saida_Pagamento_id FOREIGN KEY (Nota_Saida_Pagamento_id) REFERENCES Pagamento (id),
  CONSTRAINT fk_Cliente_Nota_Saida_Cliente_id FOREIGN KEY (Cliente_id) REFERENCES Cliente (id),
  CONSTRAINT fk_Cliente_Nota_Saida_Nota_Saida_id FOREIGN KEY (Nota_Saida_id) REFERENCES Nota_Saida (id)
    )
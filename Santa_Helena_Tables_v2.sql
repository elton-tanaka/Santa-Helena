CREATE DATABASE SantaHelena;
USE SantaHelena;

CREATE TABLE Usuario(
id_usuario INT NOT NULL AUTO_INCREMENT,
nome_usuario VARCHAR(45) NOT NULL,
cpf_usuario VARCHAR(12) NOT NULL,
senha_usuario VARCHAR(45) NOT NULL,
CONSTRAINT pk_usuario_id_usuario PRIMARY KEY (id_usuario)
);

CREATE TABLE Caixa(
id_caixa INT NOT NULL AUTO_INCREMENT,
quantia_dinheiro_caixa FLOAT NOT NULL,
CONSTRAINT pk_caixa_id_caixa PRIMARY KEY (id_caixa)
);

CREATE TABLE Saida(
id_saida INT NOT NULL AUTO_INCREMENT,
nota_saida VARCHAR(45) NOT NULL,
data_saida DATE NOT NULL,
CONSTRAINT pk_saida_id_caixa PRIMARY KEY (id_saida)
);

CREATE TABLE Produto(
id_produto INT NOT NULL AUTO_INCREMENT,
nome_produto VARCHAR(45) NOT NULL,
preco_produto FLOAT NOT NULL,
CONSTRAINT pk_produto_id_produto PRIMARY KEY (id_produto)
);

CREATE TABLE Entrada(
id_entrada INT NOT NULL AUTO_INCREMENT,
nota_entrada VARCHAR(45) NOT NULL,
data_entrada DATE NOT NULL,
CONSTRAINT pk_entrada_id_entrada PRIMARY KEY (id_entrada)
);

CREATE TABLE Fornecedor(
id_fornecedor INT NOT NULL AUTO_INCREMENT,
cnpj_fornecedor VARCHAR(45) NOT NULL,
nome_fornecedor VARCHAR(45) NOT NULL,
cidade_fornecedor VARCHAR(45) NOT NULL,
CONSTRAINT pk_fornecedor_id_fornecedor PRIMARY KEY (id_fornecedor)
);

CREATE TABLE Usuario_Caixa(
id_usuario INT NOT NULL,
id_caixa INT NOT NULL,
CONSTRAINT fk_usuario_caixa_id_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario),
CONSTRAINT fk_usuario_caixa_id_caixa FOREIGN KEY (id_caixa) REFERENCES Caixa (id_caixa)
);

CREATE TABLE Saida_Caixa(
id_saida INT NOT NULL,
id_caixa INT NOT NULL,
CONSTRAINT fk_saida_caixa_id_saida FOREIGN KEY (id_saida) REFERENCES Saida (id_saida),
CONSTRAINT fk_saida_caixa_id_caixa FOREIGN KEY (id_caixa) REFERENCES Caixa (id_caixa)
);

CREATE TABLE Quantidade(
quantidade_produto INT NOT NULL AUTO_INCREMENT,
id_saida INT NOT NULL,
id_produto INT NOT NULL,
CONSTRAINT pk_quantidade_quantidade_produto PRIMARY KEY (quantidade_produto),
CONSTRAINT fk_quantidade_id_saida FOREIGN KEY (id_saida) REFERENCES Saida (id_saida),
CONSTRAINT fk_quantidade_id_produto FOREIGN KEY (id_produto) REFERENCES Produto (id_produto)
);

CREATE TABLE Produto_Entrada(
id_produto INT NOT NULL,
id_entrada INT NOT NULL,
CONSTRAINT fk_produto_entrada_id_produto FOREIGN KEY (id_produto) REFERENCES Produto (id_produto),
CONSTRAINT fk_produto_entrada_id_entrada FOREIGN KEY (id_entrada) REFERENCES Entrada (id_entrada)
);

CREATE TABLE Entrada_Fornecedor(
id_entrada INT NOT NULL,
id_fornecedor INT NOT NULL,
CONSTRAINT fk_entrada_produto_id_entrada FOREIGN KEY (id_entrada) REFERENCES Entrada (id_entrada),
CONSTRAINT fk_entrada_produto_id_fornecedor FOREIGN KEY (id_fornecedor) REFERENCES Fornecedor (id_fornecedor) 
);

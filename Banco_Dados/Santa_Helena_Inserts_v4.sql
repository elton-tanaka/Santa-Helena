USE SantaHelena;

INSERT INTO Usuario (nome, cpf, senha, funcao)
VALUES ('Elton', '123123123', '123', 'Administrador');

INSERT INTO Usuario (nome, cpf, senha, funcao)
VALUES ('Daum', '321321321', '321', 'Gerente');

INSERT INTO Usuario (nome, cpf, senha, funcao)
VALUES ('Wagner', '123321123', '1234', 'Gerente');

INSERT INTO Usuario (nome, cpf, senha, funcao)
VALUES ('João', '123456789', '12345', 'Funcionário');

INSERT INTO Usuario (nome, cpf, senha, funcao)
VALUES ('Danilo', '987654321', '123456', 'Funcionário');

INSERT INTO Caixa (quantia_dinheiro, Usuario_id)
VALUES (200 , '1');

INSERT INTO Caixa (quantia_dinheiro, Usuario_id)
VALUES (300, '2');

INSERT INTO Caixa (quantia_dinheiro, Usuario_id)
VALUES (400 , '3');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-15' , '1', '1', '1');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-16' , '2', '2', '2');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-16' , '3', '2', '1');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-16' , '4', '1', '1');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-17' , '5', '2', '1');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-17' , '6', '2', '3');

INSERT INTO Nota_Saida (data, Pagamento_id, Caixa_id, Caixa_Usuario_id)
VALUES ('2019-09-18' , '7', '2', '2');

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES ('321-321-321-0', 'Jao');

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES ('321-123-123-0', 'Rodolfo');

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES ('321-321-123-0', 'Jacquin');

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES ('321-321-123-0', null);

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES (null, null);

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES (null, null);

INSERT INTO Cliente (cpf_cliente, nome_cliente)
VALUES ('321-321-321-0', 'Jao');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('1', '2', '1');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('1', '3', '1');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('2', '1', '1');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('3', '4', '2');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('3', '5', '3');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('1', '6', '1');

INSERT INTO Cliente_Nota_Saida (Cliente_id, Nota_Saida_id, Nota_Saida_Pagamento_id)
VALUES ('7', '7', '2');

INSERT INTO Pagamento (tipo, parcela)
VALUES ('Dinheiro', '1'),
('Cartão de Crédito' , '2'),
('Cartão de Crédito' , '4'),
('Cartão de Débito' , '1');

INSERT INTO Nota_Entrada (data, Pagamento_id, Usuario_id, Fornecedor_id) 
VALUES ('2019-11-13', '3', '1', '1');

INSERT INTO Nota_Entrada (data, Pagamento_id, Usuario_id, Fornecedor_id) 
VALUES ('2019-11-14', '3', '2', '1');

INSERT INTO Nota_Entrada (data, Pagamento_id, Usuario_id, Fornecedor_id) 
VALUES ('2019-11-14', '3', '3', '2');

INSERT INTO Nota_Entrada (data, Pagamento_id, Usuario_id, Fornecedor_id) 
VALUES ('2019-11-15', '3', '2', '3');

INSERT INTO Nota_Entrada (data, Pagamento_id, Usuario_id, Fornecedor_id) 
VALUES ('2019-11-15', '3', '2', '5');

INSERT INTO Produto (nome, preco) 
VALUES ('Açucar 1000g', 2.50),
('Café 500g', 9.99),
('Sal 1000g', 2.35),
('Nescau 400g', 3.99),
('Arroz 1000g', 4.99),
('Feijao 1000g', 5.99),
('Óleo 900mL', 2.69),
('Farinha 1000g', 5.99);

INSERT INTO fornecedor (nome, cnpj, cidade)
VALUES ('João Ferreira', '12234256897602', 'Marília'),
	   ('Pedro Silva', '34455990900809', 'Marília'),
	   ('Victor dos Santos', '36655677890066', 'Bauru'),
       ('Mariana Bastos', '899007888888999', 'Bauru'),
       ('Inara Rosa', '23455777877809', 'Bauru'),
       ('Creusa Fernandes', '33556677766700', 'Marília');

INSERT INTO Item_Saida (Produto_id, Nota_Saida_id, qntd_produto, preco_total) 
VALUES ('1','2', '5', '12.5'),
('2', '2', '1', '9.99'),
('3', '2', '4', '9.4');

INSERT INTO Item_Entrada (Produto_id, Nota_Entrada_id, qntd_produto, preco_total) 
VALUES ('1','2', '5', '12.5'),
('2', '2', '1', '9.99'),
('3', '2', '4', '9.4');

INSERT INTO Produto_Fornecedor (Produto_id, Fornecedor_id) 
VALUES ('1', '1'),
('1', '3'),
('1', '4'),
('2', '1'),
('2', '2'),
('2', '4'),
('2', '5'),
('3', '1'),
('3', '3'),
('3', '5'),
('4', '5'),
('5', '1'),
('5', '3'),
('5', '5'),
('6', '1'),
('6', '2'),
('7', '3'),
('7', '4'),
('7', '5');



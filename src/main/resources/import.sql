-- Inserção de dados na tabela tb_endereco
INSERT INTO tb_endereco (nome_endereco, latitude, longitude, cep)
VALUES
    ('Rua das Flores', -23.550520, -46.633308, '01001-000');

-- Inserção de dados na tabela tb_user
-- Aqui, como o id do endereço é auto-incrementado, vamos usar o LAST_INSERT_ID() para referenciar o endereço inserido
INSERT INTO tb_user (nome, cpf, email, telefone, senha, role, endereco_id)
VALUES
    ('João Silva', '12345678900', 'joao@email.com', '11987654321', 'senha123', 'ROLE_USER', 1);

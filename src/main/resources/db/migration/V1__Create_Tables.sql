-- Criar tabela de Usuário
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);

-- Criar tabela de Perfil
CREATE TABLE perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Criar tabela de Curso
CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

-- Criar tabela de Tópico
CREATE TABLE topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL,
    autor_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- Criar tabela de Resposta
CREATE TABLE resposta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico_id BIGINT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor_id BIGINT,
    solucao BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico_id) REFERENCES topico(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);

-- Criar tabela intermediária de Usuario_Perfil
CREATE TABLE usuario_perfil (
    usuario_id BIGINT,
    perfil_id BIGINT,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

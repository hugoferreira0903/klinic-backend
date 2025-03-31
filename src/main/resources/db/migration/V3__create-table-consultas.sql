CREATE TABLE CONSULTAS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    preco DECIMAL(10,2) NOT NULL,
    atendimento VARCHAR(100) NOT NULL,
    id_medico BIGINT NOT NULL,
    CONSTRAINT FK_MEDICO FOREIGN KEY (id_medico) REFERENCES MEDICOS(id) ON DELETE CASCADE
);
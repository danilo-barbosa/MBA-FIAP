create table assistances
(
    id  bigint auto_increment primary key,
    description varchar(300) not null,
    name        varchar(100) not null
);

INSERT INTO assistances (description, name) VALUES ('Troca aparelho', 'Serviço de Troca de aparelho');
INSERT INTO assistances (description, name) VALUES ('Troca cabo', 'Serviço de Troca de cabo');
INSERT INTO assistances (description, name) VALUES ('Troca fiação', 'Serviço de Troca de fiação');
INSERT INTO assistances (description, name) VALUES ('Manutenção fogão', 'Serviço de Manutenção em fogão');
INSERT INTO assistances (description, name) VALUES ('Manutenção geladeira', 'Serviço de Manutenção em geladeira');
INSERT INTO assistances (description, name) VALUES ('Manutenção lavadora', 'Serviço de Manutenção em lavadora');



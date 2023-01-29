create table abctech.assistances
(
    id  bigint auto_increment primary key,
    description varchar(300) not null,
    name        varchar(100) not null
);

INSERT INTO abctech.assistances (description, name) VALUES ('Troca aparelho', 'Serviço de Troca de aparelho');
INSERT INTO abctech.assistances (description, name) VALUES ('Troca cabo', 'Serviço de Troca de cabo');
INSERT INTO abctech.assistances (description, name) VALUES ('Troca fiação', 'Serviço de Troca de fiação');
INSERT INTO abctech.assistances (description, name) VALUES ('Manutenção fogão', 'Serviço de Manutenção em fogão');
INSERT INTO abctech.assistances (description, name) VALUES ('Manutenção geladeira', 'Serviço de Manutenção em geladeira');
INSERT INTO abctech.assistances (description, name) VALUES ('Manutenção lavadora', 'Serviço de Manutenção em lavadora');



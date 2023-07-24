CREATE DATABASE db_adotation;

CREATE TABLE usuario (
usuario_id bigserial PRIMARY KEY,
nome varchar(60) NOT NULL,
email varchar(40) NOT NULL,
senha varchar(8) NOT NULL
);
CREATE TABLE estoque(
estoque_id bigserial PRIMARY KEY,
nome_estoque varchar(15) NOT NULL,
animal varchar(10) NOT NULL
situacao boolean
);
CREATE TABLE produto(
produto_id bigserial PRIMARY KEY,
estoque_id bigint NOT NULL REFERENCES estoque(estoque_id),
produto varchar(40) NOT NULL,
quantidade bigint NOT NULL,
animal varchar(10) NOT NULL,
categoria varchar(15) NOT NULL
);

ALTER TABLE usuario ALTER COLUMN senha SET NOT NULL; 

ALTER TABLE estoque ADD COLUMN situacao boolean;






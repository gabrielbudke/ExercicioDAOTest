/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alunos
 * Created: 09/10/2018
 */
DROP DATABASE IF EXISTS cinema;
CREATE DATABASE cinema;
USE cinema;

CREATE TABLE filmes (
    id INT PRIMARY KEY AUTO_INCREMENT,   
    nome VARCHAR(30),
    diretor VARCHAR(30),
    categoria VARCHAR(30),
    ano SMALLINT,
    ator_principal VARCHAR(30),
    tempo_filme SMALLINT,
    orcamento DOUBLE,
    faturamento DOUBLE,
    faixa_etaria VARCHAR(30),
    legenda BOOLEAN,
    dublado BOOLEAN,
    idioma_original VARCHAR(30)



);


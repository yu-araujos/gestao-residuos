CREATE TABLE T_CADASTRO (
                          CD_CADASTRO NUMBER PRIMARY KEY,
                          DS_NOME VARCHAR2(100) NOT NULL,
                          DS_EMAIL VARCHAR2(100) NOT NULL,
                          DS_ENDERECO VARCHAR2(255) NOT NULL
);

CREATE TABLE T_TIPO_NOTIFICACAO (
                                  CD_TIPO_NOTIFICACAO NUMBER PRIMARY KEY,
                                  DS_MENSAGEM VARCHAR2(255) NOT NULL
);

CREATE TABLE T_NOTIFICACAO (
                             CD_NOTIFICACAO NUMBER PRIMARY KEY,
                             CD_CADASTRO NUMBER,
                             CD_TIPO_NOTIFICACAO NUMBER,
                             NR_NOTIFICACAO VARCHAR2(50),
                             CONT_NOTIFICACAO VARCHAR2(255),
                             ST_NOTIFICACAO VARCHAR2(50),
                             DT_ENVIO DATE,
                             FOREIGN KEY (CD_CADASTRO) REFERENCES CADASTRO (CD_CADASTRO),
                             FOREIGN KEY (CD_TIPO_NOTIFICACAO) REFERENCES TIPO_NOTIFICACAO (CD_TIPO_NOTIFICACAO)
);

CREATE TABLE T_CALENDARIO_COLETA (
                                   CD_CALENDARIO_COLETA NUMBER PRIMARY KEY,
                                   DIA_COLETA DATE,
                                   TIPO_RESIDUO VARCHAR2(255),
                                   INSTRUCOES VARCHAR2(255)
);

CREATE TABLE T_MORADORES (
                           CD_MORADORES NUMBER PRIMARY KEY,
                           DS_NOME VARCHAR2(100) NOT NULL,
                           DS_EMAIL VARCHAR2(100) NOT NULL,
                           DS_ENDERECO VARCHAR2(255) NOT NULL
);

CREATE TABLE T_RASTREAMENTO_CAMINHAO (
                                       CD_CAMINHAO NUMBER PRIMARY KEY,
                                       DS_LOCALIZACAO VARCHAR2(255),
                                       DT_ATUALIZACAO DATE
);

CREATE TABLE T_RESIDUO (
                         CD_RESIDUO NUMBER PRIMARY KEY,
                         DS_RESIDUO VARCHAR2(255),
                         VL_MAXIMO VARCHAR2(255)
);

CREATE TABLE T_RASTREIO (
                          CD_RASTREIO NUMBER PRIMARY KEY,
                          CD_CADASTRO NUMBER,
                          CD_RESIDUO NUMBER,
                          NR_RASTREIO VARCHAR2(50),
                          ST_CAMINHAO VARCHAR2(50),
                          FOREIGN KEY (CD_CADASTRO) REFERENCES CADASTRO (CD_CADASTRO),
                          FOREIGN KEY (CD_RESIDUO) REFERENCES RESIDUO (CD_RESIDUO)
);

CREATE TABLE T_STATUS_RASTREIO (
                                 CD_STATUS_RASTREIO NUMBER PRIMARY KEY,
                                 CD_RASTREIO NUMBER,
                                 CD_CADASTRO NUMBER,
                                 DS_ENDERECO_INICIAL VARCHAR2(255),
                                 DS_ENDERECO_ATUAL VARCHAR2(255),
                                 DS_ENDERECO_FINAL VARCHAR2(255),
                                 DT_OPERACAO DATE,
                                 HR_INICIAL TIMESTAMP,
                                 HR_ATUAL TIMESTAMP,
                                 HR_FINAL TIMESTAMP,
                                 FOREIGN KEY (CD_RASTREIO) REFERENCES RASTREIO (CD_RASTREIO),
                                 FOREIGN KEY (CD_CADASTRO) REFERENCES CADASTRO (CD_CADASTRO)
);

CREATE TABLE T_VL_REAL_RESIDUO (
                                     CD_VL_REAL_RESIDUO NUMBER PRIMARY KEY,
                                     CD_RESIDUO NUMBER,
                                     VL_RES_ORG VARCHAR2(255),
                                     VL_RES_REC VARCHAR2(255),
                                     VL_RES_PER VARCHAR2(255),
                                     FOREIGN KEY (CD_RESIDUO) REFERENCES RESIDUO (CD_RESIDUO)
);

# Gestão de Resíduos - CI/CD Pipeline e Docker

## Sumário
1. [Introdução](#introdução)
2. [Pré-requisitos](#pré-requisitos)
3. [Instruções de Execução](#instruções-de-execução)
   - [Rodando com Docker Compose](#rodando-com-docker-compose)
   - [Rodando apenas com Docker](#rodando-apenas-com-docker)
4. [Pipeline CI/CD](#pipeline-cicd)
5. [Estrutura do Projeto](#estrutura-do-projeto)
6. [Deploy em Staging e Produção](#deploy-em-staging-e-produção)
7. [Logs e Debugging](#logs-e-debugging)
8. [Contribuindo](#contribuindo)
9. [Licença](#licença)

---

## Introdução

Este projeto faz parte de um sistema de **Gestão de Resíduos** que utiliza automação DevOps com um pipeline de CI/CD configurado e containerização usando Docker. A aplicação pode ser executada tanto em ambientes locais quanto em servidores remotos com Docker Compose.

---

## Pré-requisitos

Antes de rodar este projeto, certifique-se de que você tem as seguintes ferramentas instaladas:
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) (opcional, caso queira rodar sem Docker)

---

## Instruções de Execução

### Rodando com Docker Compose
Siga as etapas abaixo para rodar o projeto com Docker Compose:

1. **Clonar o repositório**:
   ```bash
   git clone https://github.com/yur1silva/gestao-residuos.git
   cd gestao-residuos

2. Construir e rodar a aplicação:

docker-compose up --build


### Rodando apenas com Docker
1. Clonar o repositório:

git clone https://github.com/yu-araujos/gestao-residuos.git
cd gestao-residuos

2. Construir a imagem Docker:
docker build -t gestao-residuos-app .

3. Rodar a imagem Docker:
docker run -p 8080:8080 gestao-residuos-app

###Pipeline CI/CD
O pipeline de CI/CD foi configurado usando GitHub Actions para rodar automaticamente a cada push na branch main. Ele realiza:

Build da aplicação com Maven.
Construção da imagem Docker e envio para o Docker Hub.
Deploy da aplicação usando Docker Compose.
Segredos configurados no GitHub:
DOCKER_USERNAME: Seu nome de usuário no Docker Hub.
DOCKER_PASSWORD: Sua senha do Docker Hub.

###Estrutura do Projeto
gestao-residuos/
├── .github/
│   └── workflows/
│       └── docker-publish.yml  # Arquivo de pipeline do GitHub Actions
├── Dockerfile                  # Arquivo Docker para containerização
├── docker-compose.yml           # Arquivo Docker Compose para orquestração
├── src/                         # Código-fonte da aplicação
├── pom.xml                      # Arquivo Maven
└── target/                      # Arquivos JAR gerados pelo Maven (após o build)

###Deploy em Staging e Produção
Este projeto suporta deploy em Staging e Produção utilizando Docker Compose. No arquivo docker-compose.yml, as seguintes configurações são definidas:

Build da Imagem: A imagem é construída localmente usando o Dockerfile existente.
Porta Mapeada: A porta 8080 é exposta para acessar a aplicação no navegador.
Volumes: Os logs da aplicação são armazenados localmente na pasta ./logs, para facilitar o monitoramento.
Variáveis de Ambiente: O perfil Spring ativo é configurado como prod com SPRING_PROFILES_ACTIVE=prod.


###Logs e Debugging
Os logs da aplicação são armazenados no diretório ./logs, conforme definido no arquivo docker-compose.yml. Isso facilita o acesso e monitoramento dos logs da aplicação em tempo real, sem a necessidade de acessar o contêiner diretamente.

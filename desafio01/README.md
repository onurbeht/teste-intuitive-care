# Desafio 01

Este projeto Java, construído com Maven, realiza web scraping no site da Agência Nacional de Saúde Suplementar (ANS) para baixar os Anexos I e II do Rol de Procedimentos em formato PDF e compactá-los em um único arquivo ZIP.

## Descrição

O projeto realiza as seguintes tarefas:

1.  **Download dos Anexos:** Identifica e baixa os arquivos PDF dos Anexos I e II.
2.  **Compactação:** Compacta os PDFs baixados em um único arquivo ZIP.

## Pré-requisitos

- [**Java Development Kit (JDK):**](https://www.oracle.com/br/java/technologies/downloads/#java21) Versão 21.
- [**Maven:**](https://maven.apache.org/) Instalado e configurado no seu sistema.
- **Conexão com a Internet:** Necessária para acessar o site e baixar os arquivos.

## Como Executar

Siga os passos abaixo para executar o projeto:

1.  **Clone o Repositório (se aplicável):**

    ```bash
    git clone https://github.com/onurbeht/teste-intuitive-care
    ```

2.  **Navegue até o diretório do projeto:**

    ```bash
    cd <diretorio_do_projeto>/desafio01
    ```

    (Substitua `<diretorio_do_projeto>` pelo caminho para o diretório onde o projeto foi clonado ou descompactado.)

3.  **Compile o Projeto:**

    ```bash
    mvn clean compile
    ```

    Este comando irá limpar o diretório `target` e compilar o código fonte.

4.  **Execute o Projeto:**

    ```bash
    mvn exec:java -Dexec.mainClass="com.desafio01.Main"
    ```

    Este comando irá executar a classe principal do projeto, que contém a lógica de web scraping, download e compactação.

5.  **Verifique os Arquivos:**
    Após a execução, os arquivos PDF baixados e o arquivo ZIP compactado estarão localizados no diretório `pdf e zipFiles` dentro do diretório do projeto. Se o diretório não existir, ele será criado.

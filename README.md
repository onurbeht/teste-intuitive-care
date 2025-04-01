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
    git clone <URL_DO_SEU_REPOSITORIO>
    ```

    (Substitua `<URL_DO_SEU_REPOSITORIO>` e `<NOME_DO_SEU_PROJETO>` pelos valores corretos.)

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

---

# Desafio 02 - Extração e Processamento de Dados de PDF

Este projeto consiste em um script Python que extrai dados de um arquivo PDF, processa esses dados e os salva em um arquivo CSV. Finalmente, o arquivo CSV é compactado em um arquivo ZIP.

## Descrição

O script `Desafio02.py` realiza as seguintes tarefas:

1.  **Extração de Dados do PDF:** Utiliza a biblioteca `tabula-py` para extrair dados tabulares de um arquivo PDF específico (páginas 3 a 181).
2.  **Processamento de Dados:**
    - Concatena as tabelas extraídas em um único DataFrame do pandas.
    - Remove linhas e colunas completamente vazias.
    - Realiza a limpeza de dados, removendo espaços em branco no início e no final das strings e substituindo as abreviações "OD" por "Seg. Odontológica" e "AMB" por "Seg. Ambulatoria".
3.  **Salvamento em CSV:** Salva o DataFrame processado em um arquivo CSV, utilizando a codificação `utf-8-sig` para garantir a correta representação de caracteres especiais.
4.  **Compactação em ZIP:** Compacta o arquivo CSV gerado em um arquivo ZIP.

## Pré-requisitos

Antes de executar o script, certifique-se de ter o seguinte instalado:

- **Python 3.x:** O script foi desenvolvido e testado com Python 3.x.
- **Java:** A biblioteca `tabula-py` depende do Java para funcionar. Certifique-se de ter o Java instalado e configurado corretamente em seu sistema. Você pode verificar se o Java está instalado executando o comando `java -version` no seu terminal.
- **Bibliotecas Python:** As seguintes bibliotecas Python são necessárias:
  - `pandas`
  - `zipfile`
  - `tabula-py`

## Como Executar o Código

Siga os passos abaixo para executar o projeto:

1.  **Clone o Repositório (se aplicável):**

    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    ```

    (Substitua `<URL_DO_SEU_REPOSITORIO>` e `<NOME_DO_SEU_PROJETO>` pelos valores corretos.)

2.  **Navegue até o diretório do projeto:**

    ```bash
    cd <diretorio_do_projeto>/desafio01
    ```

    (Substitua `<diretorio_do_projeto>` pelo caminho para o diretório onde o projeto foi clonado ou descompactado.)

### Instalação das Dependências

Para instalar as bibliotecas Python necessárias, siga os passos abaixo:

1.  **Abra o terminal ou prompt de comando.**
2.  **Navegue até o diretório do projeto.**
3.  **Execute o seguinte comando para instalar as bibliotecas:**

    ```bash
    pip install pandas tabula-py
    ```

    Este comando instalará as bibliotecas `pandas`, `tabula-py`. A biblioteca `zipfile` já vem instaladas com o python.

Após instalar as dependências, siga os passos abaixo para executar o script:

1.  **Baixe o arquivo PDF:** Certifique-se de ter o arquivo `Anexo_I_Rol_2021RN_465_2021_RN627L_2024.pdf` no mesmo diretório do script `Desafio02.py`.
2.  **Abra o terminal ou prompt de comando.**
3.  **Navegue até o diretório onde o script `Desafio02.py` está localizado.**
4.  **Execute o script usando o seguinte comando:**

    ```bash
    python Desafio02.py
    ```

    O script irá executar, extrair os dados do PDF, processá-los, salvar em `dados.csv` e compactar em `Teste_Bruno_Oliveira.zip`.

## Saída

Após a execução bem-sucedida do script, os seguintes arquivos serão gerados no mesmo diretório:

- `dados.csv`: Um arquivo CSV contendo os dados extraídos e processados do PDF.
- `Teste_Bruno_Oliveira.zip`: Um arquivo ZIP contendo o arquivo `dados.csv`.

## Observações

- O script foi projetado para funcionar com o arquivo PDF específico `Anexo_I_Rol_2021RN_465_2021_RN627L_2024.pdf`. Se você tentar usar outro PDF, pode ser necessário ajustar o código.
- Certifique-se de que o arquivo PDF está no mesmo diretório do script.
- Caso tenha problemas com a instalação do tabula-py, verifique se o java está instalado e configurado corretamente.

---

# Desafio 03

## Fonte de Dados

Os dados utilizados neste projeto são publicamente disponíveis pela ANS:

- **Demonstrações Contábeis:** [https://dadosabertos.ans.gov.br/FTP/PDA/demonstracoes_contabeis/](https://dadosabertos.ans.gov.br/FTP/PDA/demonstracoes_contabeis/) (Últimos 2 anos)
- **Cadastro de Operadoras Ativas:** [https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/](https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/) (Formato CSV)

## Banco de Dados

- **Sistema de Banco de Dados:** PostgreSQL
- **Versão:** 15

## Como Executar o Projeto

1.  **Configuração do Banco de Dados (`backup.sql`):**

    **Pelo PgAdmin4.**

    - **1** Crie um Database.
    - **2** Clique com o botão direito do mouse no Database criado.
    - **3** Selecione a opção 'Restore...'.
    - **4** Em Filename, adicione o arquivo 'backup.sql'.
    - **5** Clique em 'Restore'.
    - **6** Navegue até: Nome_do_seu_database > Schemas > Public > Tables.
    - **7** Clique com o botão direito do mouse e selecione a opção 'Refresh'.
    - **8** Depois, no mesmo lugar, clique com o botão direito do mouse e selecione a opção 'Query Tool'.
    - **9** Copie e cole os comandos que tem no arquivo 'consulta.sql'. Ou clique na opção 'OpenFile' e abra o arquivo 'consulta.sql' e execute a consulta sql.

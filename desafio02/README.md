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

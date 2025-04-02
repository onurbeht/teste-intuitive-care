# Desafio 03

## Fonte de Dados

Os dados utilizados neste projeto são publicamente disponíveis pela ANS:

- **Demonstrações Contábeis:** [https://dadosabertos.ans.gov.br/FTP/PDA/demonstracoes_contabeis/](https://dadosabertos.ans.gov.br/FTP/PDA/demonstracoes_contabeis/) (Últimos 2 anos)
- **Cadastro de Operadoras Ativas:** [https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/](https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/) (Formato CSV)

## Banco de Dados

- **Sistema de Banco de Dados:** PostgreSQL
- **Versão:** 15

## Como Executar o Projeto

1. **Realize o clone do repositorio**

   ```bash
   git clone https://github.com/onurbeht/teste-intuitive-care
   cd <Diretorio do repositorio>/desafio03
   ```

2. **Configuração do Banco de Dados (`backup.sql`):**

   **Pelo PgAdmin4.**

   - **1** Crie um Database.
   - **2** Clique com o botão direito do mouse no Database criado.
   - **3** Selecione a opção 'Restore...'.
   - **4** Em Filename, adicione o arquivo 'backup.sql', que está dentro do diretorio ./desafio03.
   - **5** Clique em 'Restore'.
   - **6** Navegue até: Nome_do_seu_database > Schemas > Public > Tables.
   - **7** Clique com o botão direito do mouse e selecione a opção 'Refresh'.
   - **8** Depois, no mesmo lugar, clique com o botão direito do mouse e selecione a opção 'Query Tool'.
   - **9** Copie e cole os comandos que tem no arquivo 'consulta.sql', que está dentro do diretorio ./desafio03. Ou clique na opção 'OpenFile' e abra o arquivo 'consulta.sql' e execute a consulta sql.

import pandas as pd
import zipfile
import tabula

# Função para extrair dados do PDF
def extrair_dados_pdf(pdf_path):
    return tabula.read_pdf(input_path=pdf_path, pages="3-181", stream=True, lattice=True)

# Função para processar os dados
def processar_dados(tabela):
    df = pd.concat(tabela, ignore_index=True)

    # Remover linhas completamente vazias
    df.dropna(how='all', inplace=True)

    # Remover colunas completamente vazias
    df.dropna(axis=1, how='all', inplace=True)

    # Limpeza de dados
    # Exemplo: remover espaços extras, corrigir tipos de dados, etc.
    # Exemplo de remoção de espaços em branco no início e no final das strings
    for col in df.columns:
        if df[col].dtype == 'object':  # Verifica se a coluna é do tipo string
            df[col] = df[col].str.strip()
            df[col] = df[col].replace("OD", "Seg. Odontológica")
            df[col] = df[col].replace("AMB", "Seg. Ambulatoria")

    return df
    

# Função para salvar dados em CSV
def salvar_csv(df, nome_arquivo):
    df.to_csv(nome_arquivo, index=False, encoding='utf-8-sig')  # 'utf-8-sig' para evitar problemas com caracteres especiais

# Função para compactar CSV em arquivo ZIP
def compactar_csv(nome_csv, nome_zip):
    with zipfile.ZipFile(nome_zip, 'w', zipfile.ZIP_DEFLATED) as zipf:
        zipf.write(nome_csv)

# Exemplo de uso
print("Texto extraido do PDF...")
pdf_path = './Anexo_I_Rol_2021RN_465_2021_RN627L_2024.pdf'
texto_extraido = extrair_dados_pdf(pdf_path)

print("Formatando os dados da tabela...")
dados_processados = processar_dados(texto_extraido)

print("salvando CSV e zipando arquivo...")
nome_csv = 'dados.csv'
salvar_csv(dados_processados, nome_csv)

nome_zip = 'Teste_Bruno_Oliveira.zip'
compactar_csv(nome_csv, nome_zip)

print("___FIM___")

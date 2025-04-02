package com.desafio04.dtos;

import java.time.LocalDate;

public record OperadorasResponseDto(
                Integer registro_ans,
                String cnpj,
                String razao_social,
                String nome_fantasia,
                String modalidade,
                String logradouro,
                String numero,
                String complemento,
                String bairro,
                String cidade,
                String uf,
                String cep,
                String ddd,
                String telefone,
                String fax,
                String endereco_eletronico,
                String representante,
                String cargo_representante,
                Integer regiao_de_comercializacao,
                LocalDate data) {

}

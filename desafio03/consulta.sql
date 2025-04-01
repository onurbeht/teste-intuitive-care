SELECT
    op.registro_ans,
    SUM(ic.VL_SALDO_FINAL) AS TotalDespesas
FROM
    tb_infos_contabeis ic
JOIN
    tb_operadoras_plano_saude op ON ic.REG_ANS = op.Registro_ANS
WHERE
    ic.Data >= (SELECT MAX(Data) - INTERVAL '3 months' FROM tb_infos_contabeis)
	And
	descricao like '%EVENTOS/SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA À SAÚDE%'
GROUP BY
    op.registro_ans
ORDER BY
    TotalDespesas DESC
limit 10;

-- 5711	54458189118.43
-- 6246	37190583882.93
-- 326305	36960600916.94
-- 359017	16631257242.28
-- 368253	13934932219.96
-- 346659	13002216049.19
-- 339679	12194602690.55
-- 302147	10354968079.51
-- 343889	9327409970.83
-- 701	8372053724.04



SELECT
    op.registro_ans,
    SUM(ic.VL_SALDO_FINAL) AS TotalDespesas
FROM
    tb_infos_contabeis ic
JOIN
    tb_operadoras_plano_saude op ON ic.REG_ANS = op.Registro_ANS
WHERE
    ic.Data >= (SELECT MAX(Data) - INTERVAL '12 months' FROM tb_infos_contabeis)
	And
	descricao like '%EVENTOS/SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA À SAÚDE%'
GROUP BY
    op.registro_ans
ORDER BY
    TotalDespesas DESC
limit 10;


-- 5711	106718771959.79
-- 6246	71865868185.78
-- 326305	71305613945.23
-- 359017	33241533777.25
-- 368253	27877422510.03
-- 346659	25346712117.19
-- 339679	24052862648.70
-- 302147	19559410625.58
-- 343889	18093600317.89
-- 701	15740136143.48

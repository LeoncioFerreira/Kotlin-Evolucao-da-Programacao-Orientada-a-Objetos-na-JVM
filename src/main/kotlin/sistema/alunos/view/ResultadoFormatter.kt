package sistema.alunos.view

import sistema.alunos.service.EstatisticasTurma
import sistema.alunos.service.RelatorioAcademico

/**
 * Descrição: Transforma os dados brutos do sistema em texto formatado para a tela.
 * Autor: Paulo
 */
object ResultadoFormatter {

    fun formatarRelatorio(relatorio: RelatorioAcademico): String {
        val builder = StringBuilder()
        builder.appendLine("Relatório de ${relatorio.nomeAluno}:")
        builder.appendLine("Média Geral: ${relatorio.mediaGeral}")
        
        relatorio.disciplinas.forEach { item ->
            val notasStr = item.notas.joinToString(", ") { it.valor.toString() }
            builder.appendLine("  - ${item.nomeDisciplina}: Notas [$notasStr], Média: ${item.media} (${item.situacao})")
        }
        
        return builder.toString().trimEnd()
    }

    fun formatarEstatisticas(estatisticas: EstatisticasTurma): String {
        val builder = StringBuilder()
        builder.appendLine("Média Geral da Turma: ${estatisticas.mediaGeralTurma}")
        
        estatisticas.alunosPorSituacao.forEach { (situacao, alunos) ->
            builder.appendLine("Situação $situacao: ${alunos.size} aluno(s)")
        }
        
        return builder.toString().trimEnd()
    }
}

package sistema.alunos.sistema.alunos.view

/**
 * Descrição: Transforma os dados brutos do sistema em texto formatado para a tela.
 * Autor: Paulo
 */

import sistema.alunos.model.Aluno
import sistema.alunos.model.SituacaoAcademica

object ResultadoFormatter {

    fun formatarBoletim(aluno: Aluno, notas: List<Double>, media: Double, situacao: SituacaoAcademica): String {

        val notasFormatadas = if (notas.isEmpty()) "Nenhuma nota registrada" else notas.joinToString(", ")


        return """
                ========================================
                           BOLETIM ACADÊMICO
                ========================================
                ID: ${aluno.id}
                Nome: ${aluno.nome}
                Notas: $notasFormatadas
                Média: $media
                Situação: ${situacao.name}
                ========================================
            """.trimIndent()
    }
}

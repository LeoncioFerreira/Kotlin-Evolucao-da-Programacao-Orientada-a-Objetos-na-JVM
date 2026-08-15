/**
 * Descrição: Serviço para cálculo de estatísticas gerais da turma.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.model.Aluno
import sistema.alunos.repository.AlunoRepository
import sistema.alunos.repository.AvaliacaoRepository

class EstatisticaTurmaService(
    private val alunoRepository: AlunoRepository,
    private val avaliacaoRepository: AvaliacaoRepository,
    private val calculadora: CalculadoraAcademica
) {
    fun calcularEstatisticas(): EstatisticasTurma {
        val todosAlunos = alunoRepository.listar()
        if (todosAlunos.isEmpty()) return EstatisticasTurma(0.0, emptyMap())

        // filter demonstrado
        val alunosAvaliados = todosAlunos.filter { aluno ->
            avaliacaoRepository.buscarPorIdAluno(aluno.id).isNotEmpty()
        }

        if (alunosAvaliados.isEmpty()) return EstatisticasTurma(0.0, emptyMap())

        val mediaTurma = alunosAvaliados.map { aluno ->
            avaliacaoRepository.buscarPorIdAluno(aluno.id).calcularMediaGeral(calculadora)
        }.average()

        // groupBy demonstrado
        val agrupamentoPorSituacao = alunosAvaliados.groupBy { aluno ->
            val mediaAluno = avaliacaoRepository.buscarPorIdAluno(aluno.id).calcularMediaGeral(calculadora)
            calculadora.determinarSituacao(mediaAluno).name
        }

        return EstatisticasTurma(
            mediaGeralTurma = mediaTurma,
            alunosPorSituacao = agrupamentoPorSituacao
        )
    }
}

data class EstatisticasTurma(val mediaGeralTurma: Double, val alunosPorSituacao: Map<String, List<Aluno>>)
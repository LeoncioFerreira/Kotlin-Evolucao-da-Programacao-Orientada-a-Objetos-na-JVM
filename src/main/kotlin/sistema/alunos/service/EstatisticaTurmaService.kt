/**
 * Descrição: Serviço para cálculo de estatísticas gerais da turma.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.model.Aluno
import sistema.alunos.model.CalculadoraDeMedia
import sistema.alunos.model.Nota
import sistema.alunos.repository.AlunoRepository
import sistema.alunos.repository.AvaliacaoRepository

class EstatisticaTurmaService(
    private val alunoRepository: AlunoRepository,
    private val avaliacaoRepository: AvaliacaoRepository
) {
    fun calcularEstatisticas(): EstatisticasTurma {
        val todosAlunos = alunoRepository.listar()
        if (todosAlunos.isEmpty()) return EstatisticasTurma(0.0, emptyMap())

        val alunosAvaliados = todosAlunos.filter { aluno ->
            avaliacaoRepository.buscarPorIdAluno(aluno.id).isNotEmpty()
        }

        if (alunosAvaliados.isEmpty()) return EstatisticasTurma(0.0, emptyMap())

        val mediaTurma = alunosAvaliados.map { aluno ->
            avaliacaoRepository.buscarPorIdAluno(aluno.id).calcularMediaGeral()
        }.average()

        val agrupamentoPorSituacao = alunosAvaliados.groupBy { aluno ->
            val mediaAluno = avaliacaoRepository.buscarPorIdAluno(aluno.id).calcularMediaGeral()
            // Simula as duas notas usando a própria média para que a calculadora consiga determinar a situação final
            val calculadora = CalculadoraDeMedia(Nota(mediaAluno), Nota(mediaAluno))
            calculadora.determinarSituacao().name
        }

        return EstatisticasTurma(
            mediaGeralTurma = mediaTurma,
            alunosPorSituacao = agrupamentoPorSituacao
        )
    }
}

data class EstatisticasTurma(val mediaGeralTurma: Double, val alunosPorSituacao: Map<String, List<Aluno>>)
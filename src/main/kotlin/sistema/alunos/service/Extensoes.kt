/**
 * Descrição: Funções de extensão para auxiliar cálculos com a calculadora acadêmica.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.model.Avaliacao
import sistema.alunos.model.CalculadoraDeMedia

fun List<Avaliacao>.calcularMediaGeral(): Double {
    if (this.isEmpty()) return 0.0
    val somaDasMedias = this.sumOf { avaliacao ->
        // Como sabemos que a Avaliacao possui exatamente duas notas, podemos passar os índices 0 e 1
        CalculadoraDeMedia(avaliacao.notas[0], avaliacao.notas[1]).calcularMedia()
    }
    return somaDasMedias / this.size
}
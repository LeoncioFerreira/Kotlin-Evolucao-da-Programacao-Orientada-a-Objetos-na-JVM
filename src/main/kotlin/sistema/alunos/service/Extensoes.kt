/**
 * Descrição: Funções de extensão para auxiliar cálculos com a calculadora acadêmica.
 * Autor: Salomão
 */
package sistema.alunos.service

import sistema.alunos.model.Avaliacao

// Função de extensão solicitada nos critérios de aceite
fun List<Avaliacao>.calcularMediaGeral(calculadora: CalculadoraAcademica): Double {
    if (this.isEmpty()) return 0.0
    val somaDasMedias = this.sumOf { calculadora.calcularMedia(it.notas) }
    return somaDasMedias / this.size
}
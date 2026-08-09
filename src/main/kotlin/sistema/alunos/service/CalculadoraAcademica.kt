/**
 * Descrição: Define o contrato para cálculo de média e situação acadêmica
 * Autor: Leôncio Ferreira
 */
package sistema.alunos.service

import sistema.alunos.model.Nota
import sistema.alunos.model.SituacaoAcademica

interface CalculadoraAcademica {
    fun calcularMedia(notas: List<Nota>): Double

    fun determinarSituacao(media: Double): SituacaoAcademica
}

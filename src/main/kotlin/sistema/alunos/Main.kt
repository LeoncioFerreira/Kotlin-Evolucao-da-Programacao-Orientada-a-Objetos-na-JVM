package sistema.alunos

import sistema.alunos.controller.ConsoleAlunoController
import sistema.alunos.repository.AlunoRepositoryEmMemoria
import sistema.alunos.repository.AvaliacaoRepositoryEmMemoria
import sistema.alunos.service.AvaliacaoService
import sistema.alunos.service.CadastroAlunoService
import sistema.alunos.service.EstatisticaTurmaService
import sistema.alunos.service.RelatorioAcademicoService
import sistema.alunos.view.ConsoleInput
import sistema.alunos.view.ConsoleView
import sistema.alunos.view.MenuPrincipal

fun main() {

    val alunoRepository = AlunoRepositoryEmMemoria()
    val avaliacaoRepository = AvaliacaoRepositoryEmMemoria()

    // 2. Inicializa as regras de negócio (Model - Serviços)
    val cadastroService = CadastroAlunoService(alunoRepository)
    val avaliacaoService = AvaliacaoService(alunoRepository, avaliacaoRepository)
    val relatorioService = RelatorioAcademicoService(alunoRepository, avaliacaoRepository)
    val estatisticaService = EstatisticaTurmaService(alunoRepository, avaliacaoRepository)

    // 3. Inicializa as interfaces de terminal (View)
    val entrada = ConsoleInput()
    val saida = ConsoleView()

    // 4. Inicializa o maestro (Controller)
    val controller = ConsoleAlunoController(
        entrada = entrada,
        saida = saida,
        cadastroService = cadastroService,
        avaliacaoService = avaliacaoService,
        relatorioService = relatorioService,
        estatisticaService = estatisticaService
    )

    // 5. Conecta o Controller ao Menu Principal e inicia o programa
    val menu = MenuPrincipal(
        input = entrada,
        view = saida,
        controller = controller
    )

    saida.limparTela()
    saida.exibir("Iniciando o Sistema de Gerenciamento de Alunos...")

    // Inicia o laço de repetição que vai manter o sistema rodando
    menu.iniciar()
}

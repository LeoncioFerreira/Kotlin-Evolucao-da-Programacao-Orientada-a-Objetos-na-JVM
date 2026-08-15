# Wiki - Kotlin: Evolução da POO na JVM

Bem-vindo à documentação oficial do projeto prático de Paradigmas de Programação.

---

## 1. Guia de Uso (Instalação e Execução)

O projeto foi construído usando o **Gradle** e requer o **Java JDK 17** ou superior.

### Comandos de Terminal
Abra o terminal na pasta raiz do projeto e execute os comandos abaixo. (No Windows, substitua `./gradlew` por `gradlew.bat`):

*   **Compilar a aplicação:** `./gradlew build`
*   **Rodar os testes automatizados:** `./gradlew test`
*   **Limpar, testar e compilar tudo:** `./gradlew clean test build`
*   **Executar a aplicação interativa:** `./gradlew run -q --console=plain`

---

## 2. Arquitetura do Sistema (MVC)

O projeto segue o padrão de arquitetura **Model-View-Controller (MVC)**, garantindo que as regras de negócio não se misturem com a interface do usuário.

**Fluxo de Execução (View → Controller → Model):**
1. O usuário digita uma opção no terminal capturada pela **View** (`ConsoleInput`, `MenuPrincipal`).
2. O menu repassa a intenção para o **Controller** (`ConsoleAlunoController`).
3. O Controller orquestra o fluxo enviando os dados brutos aos **Serviços (Model)** (`CadastroAlunoService`, `AvaliacaoService`, `RelatorioAcademicoService`, `EstatisticaTurmaService`).
4. Os Serviços aplicam as regras (ex: `CalculadoraDeMedia`) e salvam os dados no armazenamento por meio dos **Repositórios** (`AlunoRepositoryEmMemoria`, `AvaliacaoRepositoryEmMemoria`).
5. O Controller pega a resposta de sucesso ou o erro do Model e pede para a View (`ConsoleView`, `ResultadoFormatter`) exibir na tela.

---

## 3. Interoperabilidade (Kotlin ↔ Java)

O Kotlin não foi criado para destruir o Java, mas para evoluí-lo. O maior trunfo do Kotlin é a interoperabilidade de 100% com código Java existente. 

**Como testar:**
Nós criamos o arquivo `GeradorDeMensagemJava.java` (uma classe Java pura) e o arquivo `ExemploInteropKotlin.kt` (um executável Kotlin). Para ver a mágica acontecer e o Kotlin instanciando o objeto Java nativamente na JVM, rode no seu terminal:
*   `./gradlew run -PmainClass=sistema.alunos.interop.ExemploInteropKotlinKt`

---

## 4. Análise Crítica: Kotlin vs Java

### Segurança (Null Safety)
O maior pesadelo dos programadores Java é a famosa `NullPointerException` (Apelidada de "O Erro de um bilhão de dólares"). O Kotlin resolve isso no nível do compilador. Variáveis no Kotlin não podem ser nulas por padrão. Se você tentar atribuir `null` a uma String, o código sequer compila.

### Produtividade e Quantidade de Código
Kotlin reduz drasticamente o *boilerplate* (código repetitivo).
*   **Data Classes:** No Java, criar uma classe para guardar dados exige criar getters, setters, equals(), hashCode() e toString(). No Kotlin, a palavra `data class Aluno(val nome: String)` gera tudo isso por debaixo dos panos.
*   **Menos verbosidade:** Não há ponto-e-vírgula obrigatório. A inferência de tipo elimina a necessidade de repetir tipos explícitos (`val nome = "Paulo"` em vez de `String nome = "Paulo";`).

### Desempenho
Sendo ambas compiladas para o *Bytecode* da JVM, o desempenho de execução (Runtime) de Kotlin e Java é **praticamente idêntico**. A diferença de desempenho ocorre no tempo de compilação, onde o Java é ligeiramente mais rápido, pois o compilador do Kotlin faz muito mais verificações de segurança e gera os métodos ocultos (como os da Data Class).

### Facilidade de Desenvolvimento e Manutenção
Com recursos como *Extension Functions* (poder adicionar funções em classes prontas como `String` ou `List` sem precisar de herança) e *Smart Casts*, o código Kotlin fica incrivelmente legível. Um código menor e mais claro resulta em custos de manutenção menores para as empresas.

---

## 5. Ecossistema, Maturidade e Aplicações Reais

O Kotlin começou em 2011 pela JetBrains (criadora do IntelliJ). 

*   **Android:** Em 2017, o Google anunciou Kotlin como linguagem oficial para o Android. Em 2019, tornou-se a linguagem preferida (Kotlin-first). Hoje, virtualmente 100% das aplicações modernas de Android do mundo real são feitas em Kotlin.
*   **Backend:** Kotlin vem substituindo o Java no desenvolvimento de APIs de grandes empresas. Frameworks famosos do Java, como o **Spring Boot**, adotaram o Kotlin como linguagem de primeira classe.
*   **Comunidade e Perspectivas:** O ecossistema é massivo e blindado pelo peso corporativo da JetBrains e do Google. As perspectivas apontam para o Kotlin solidificando seu domínio no mobile e engolindo fatias gradativas do mercado Backend Java.

**Vantagens vs Limitações:**
A principal vantagem é a concisão, segurança e o fim das NullPointerExceptions. A principal limitação é a curva de aprendizado inicial (paradigmas funcionais misturados à POO) e um tempo de compilação um pouco maior que o Java puro.

---

## 6. Referências Bibliográficas

*   [Site Oficial do Kotlin - Kotlin Programming Language](https://kotlinlang.org/)
*   [Google Developers - Android's Kotlin-first approach](https://developer.android.com/kotlin/first)
*   [JetBrains - Kotlin for Server Side](https://kotlinlang.org/docs/server-overview.html)
*   [Documentação Spring Boot e Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin)

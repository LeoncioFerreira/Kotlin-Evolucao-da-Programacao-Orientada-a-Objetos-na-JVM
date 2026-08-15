# Sistema de Gerenciamento de Alunos em Kotlin

Projeto da disciplina de Paradigmas de Programação para estudar Kotlin como evolução da Programação Orientada a Objetos na JVM.

Pergunta central:

> Kotlin substitui Java ou as duas linguagens continuarão coexistindo na JVM?

## Integrantes

- André Wesley Barbosa Rodrigues Filho
- Leôncio Ferreira Flores Neto
- Paulo Gabriel Leite Landim
- Salomão Rodrigues Silva
- Ramona Vitória Clemente Cardoso
- Pedro Kauan Cardoso da Silva

## Objetivo do sistema

Criar uma aplicação de terminal para cadastrar alunos, registrar notas, calcular médias e informar a situação acadêmica.

## Estrutura

```text
src/main/kotlin/sistema/alunos/
├── model/          # Entidades e tipos acadêmicos
├── repository/     # Armazenamento em memória
├── service/        # Regras de negócio
├── controller/     # Coordenação dos casos de uso
└── view/           # Entrada e saída pelo terminal
```

## Comandos

```bash
./gradlew test
./gradlew build
./gradlew clean test build
```

No Windows, utilize `gradlew.bat` no lugar de `./gradlew`.

## Git Flow

```text
main                 código estável
  └── develop        integração do trabalho
        └── feature  desenvolvimento de cada issue
```

Regras:

- nunca envie código diretamente para `main`;
- crie as branches a partir de `develop`;
- utilize nomes como `feature/modelar-aluno`;
- abra pull requests sempre para `develop`;
- aguarde a revisão de outro integrante e o pipeline passar;
- `main` será utilizada somente para versões estáveis.

## Regras de desenvolvimento

### Idioma e documentação

- **Código:** nomes de arquivos, classes, variáveis e funções devem ser escritos em **português**, mantendo em inglês apenas palavras próprias da linguagem e de bibliotecas.
- **KDoc:** todo arquivo Kotlin deve começar com um cabeçalho em português:

```kotlin
/**
 * Descrição: O que este arquivo implementa.
 * Autor: Nome do autor.
 */
```

- **Didática:** nomes devem ser claros para estudantes que conhecem Java e estão aprendendo Kotlin.
- **Consistência:** um mesmo conceito deve manter o mesmo nome em todo o projeto.

## Commits

Utilize Conventional Commits:

```text
feat: adiciona validação de notas
fix: corrige busca de aluno
test: cobre notas inválidas
docs: atualiza arquitetura
ci: adiciona pipeline de testes
```

## Pipeline

Pushes e pull requests para `develop` executam automaticamente:

```bash
./gradlew clean test build --no-daemon
```

As ferramentas completas de Quality Gates serão adicionadas posteriormente no repositório do trabalho de Gerência de Configuração.

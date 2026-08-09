# Como contribuir

## Fluxo de trabalho

1. Atualize sua branch a partir de `develop`.
2. Crie uma branch no formato `tipo/descricao`, como `feature/modelar-aluno`.
3. Faça commits pequenos e com mensagens objetivas.
4. Envie a branch e abra uma pull request.
5. Solicite a revisão de pelo menos um integrante.
6. Corrija os problemas apontados antes da integração.

Não envie alterações diretamente para `main` ou `develop`. Abra uma pull request da sua branch para `develop`. A branch `main` será utilizada somente para versões estáveis.

## Antes da pull request

Execute:

```bash
./gradlew clean test build
```

A pull request deve explicar o que mudou, como testar e quais critérios da issue foram atendidos.

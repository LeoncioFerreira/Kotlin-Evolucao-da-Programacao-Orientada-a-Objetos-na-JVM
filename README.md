# Kotlin: Evolução da Programação Orientada a Objetos na JVM

[![Language: Kotlin](https://img.shields.io/badge/Language-Kotlin-blue.svg)](https://kotlinlang.org/)
[![Build: Gradle](https://img.shields.io/badge/Build-Gradle-02303A.svg?logo=gradle)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> **Acesse a nossa Pesquisa completa na [Página Inicial da Wiki (Home)](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Home).** Toda a documentação detalhada da pesquisa sobre o Kotlin e sua aplicação prática está reunida lá!

---

## 1. O Projeto

Este projeto foi desenvolvido como parte da disciplina de **Paradigmas de Programação** da **Universidade Federal do Cariri (UFCA)**, sob a orientação do **Professor Rafael Will Macedo de Araújo**.

O repositório contém os materiais da pesquisa acadêmica e um **Sistema Acadêmico Prático**, focados em demonstrar a evolução da Programação Orientada a Objetos (POO) na JVM através da linguagem Kotlin. O objetivo da pesquisa é evidenciar a adoção de novos recursos, concisão, null safety e demais paradigmas suportados pela linguagem, comparativamente ao ecossistema Java clássico.

### O Sistema Acadêmico

Como prova de conceito, desenvolvemos um sistema CLI (Command Line Interface) de gestão acadêmica. O projeto é executado inteiramente em memória e aplica, na prática, os recursos estudados:
- **Data Classes** para representação de alunos e disciplinas sem verborragia.
- **Extensions Functions** para calcular médias e situações das turmas de maneira idiomática.
- **Null Safety e Smart Casts** no tratamento de inputs do usuário e prevenção de *NullPointerExceptions*.

A aplicação permite criar cadastros, registrar notas e emitir relatórios de turmas de forma interativa através do terminal, isolando a camada de persistência em memória e a interface da regra de negócio.

**Toda a pesquisa construída está documentada e disponível na [Wiki do Repositório](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki).**

## 2. Demonstração

![Demonstração do Sistema Prático](docs/video.gif)

> Demonstração em vídeo do Sistema Acadêmico em funcionamento, ilustrando a aplicação prática dos conceitos em Kotlin.

---

## 3. Como Rodar Localmente

Para compilar e executar o Sistema Acadêmico contido neste repositório, certifique-se de ter o **JDK (Java Development Kit)** instalado na versão 11 ou superior.

1. Clone este repositório:
   ```bash
   git clone https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM.git
   cd Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM
   ```

2. Execute o projeto utilizando o Gradle Wrapper incluído:
   - **No Linux/macOS:**
     ```bash
     ./gradlew run
     ```
   - **No Windows:**
     ```cmd
     gradlew.bat run
     ```

---

## 4. Nossa Equipe e Responsabilidades

### A Equipe

| Nome                                 | GitHub                                                 |
| ------------------------------------ | ------------------------------------------------------ |
| André Wesley Barbosa Rodrigues Filho | [@awesleyy](https://github.com/awesleyy)               |
| Leôncio Ferreira Flores Neto         | [@LeoncioFerreira](https://github.com/LeoncioFerreira) |
| Paulo Gabriel Leite Landim           | [@LandimPG](https://github.com/LandimPG)               |
| Pedro Kauan Cardoso da Silva         | [@DevPKauan01](https://github.com/DevPKauan01)         |
| Ramona Vitória Clemente Cardoso      | [@ramona-dev](https://github.com/ramona-dev)           |
| Salomão Rodrigues Silva              | [@salomaosilvaa](https://github.com/salomaosilvaa)     |

### Entregas: Pesquisa e Apresentação (Wiki e Slides)

| Integrante | Foco da Pesquisa e Apresentação (Página da Wiki) | Slides |
| :--- | :--- | :--- |
| **André Wesley Barbosa Rodrigues Filho** | • [Classes e Objetos](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Classes-e-objetos-em-Kotlin)<br>• [Mobile com Jetpack Compose](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Kotlin-e-aplicacoes-mobile-com-Jetpack-Compose) | 06 e 14 |
| **Leôncio Ferreira Flores Neto** | • [Página Inicial (Home)](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Home)<br>• [Como começar no Kotlin](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Como-comecar-no-Kotlin)<br>• [Recursos da linguagem](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Recursos-modernos-e-concisao-do-Kotlin) | 12, 15 e 16 |
| **Paulo Gabriel Leite Landim** | [Ecossistema e Mercado](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Kotlin-versus-Java-aplicacoes-e-ecossistema) | 05 e 13 |
| **Pedro Kauan Cardoso da Silva** | [Funcional e Interoperabilidade](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Interfaces-colecoes-e-inversao-de-dependencia) | 09, 10 e 11 |
| **Ramona Vitória Clemente Cardoso** | [Segurança e Tipos (Null Safety)](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Null-safety-conversoes-seguras-e-tratamento-de-erros) | 07 e 08 |
| **Salomão Rodrigues Silva** | [Contexto Histórico](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki/Historia-do-Java-e-do-Kotlin) | 01, 02, 03 e 04 |

### Entregas: Desenvolvimento do Sistema Acadêmico (Issues)

| Integrante | Responsabilidade / Módulo | Issue e Pull Request |
| :--- | :--- | :--- |
| **André Wesley Barbosa Rodrigues Filho** | Task 3 (Cálculo de média e situação acadêmica) | [#5](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/5) / [#13](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/13) |
| **Leôncio Ferreira Flores Neto** | Tasks 0, 1 e 2 (Estrutura, Documentação, Disciplinas) | [#2](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/2), [#3](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/3), [#4](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/4) / [#1](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/1), [#12](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/12) |
| **Paulo Gabriel Leite Landim** | Task 7 (Integrar Controller, aplicação e formatação) | [#8](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/8) / [#16](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/16) |
| **Pedro Kauan Cardoso da Silva** | Task 4 (Criar cadastro e repositório em memória) | [#6](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/6) / [#11](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/11) |
| **Ramona Vitória Clemente Cardoso** | Task 6 (Construir a View e a entrada do terminal) | [#7](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/7) / [#10](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/10) |
| **Salomão Rodrigues Silva** | Task 5 (Lançamento de avaliações e relatórios) | [#9](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/issues/9) / [#14](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/pull/14) |

---

## 5. Artefatos Finais

- **Apresentação de Slides:** [`Slide Paradigmas.pdf`](Slide%20Paradigmas.pdf)
- **Nossa Pesquisa:** [Wiki do Projeto](https://github.com/LeoncioFerreira/Kotlin-Evolucao-da-Programacao-Orientada-a-Objetos-na-JVM/wiki) (Documentação central de toda a pesquisa).
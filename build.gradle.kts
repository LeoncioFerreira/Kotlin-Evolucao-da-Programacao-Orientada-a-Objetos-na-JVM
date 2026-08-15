plugins {
    kotlin("jvm") version "2.3.21"
    application
}

application {
    mainClass.set("sistema.alunos.AplicacaoKt")
}

group = "sistema.alunos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    jvmArgs("-Dfile.encoding=UTF-8")
}
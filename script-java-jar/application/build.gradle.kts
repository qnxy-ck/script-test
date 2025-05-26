plugins {
    kotlin("jvm")
}

group = "com.qnxy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":script-java-jar:api"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.named("build") {
    dependsOn(":script-java-jar:java-jar:build")

    doLast {
        val targetDir = project.file("libs").apply { if (!exists()) mkdirs() }

        copy {
            from(project.rootProject.file("script-java-jar/java-jar/build/libs/java-jar-1.0-SNAPSHOT.jar"))
            into(targetDir)
        }
    }
}

tasks.named("clean") {
    doLast {
        project.file("libs").deleteRecursively()
    }
}
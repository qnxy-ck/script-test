plugins {
    kotlin("jvm") version "2.1.20"
}

group = "com.qnxy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
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
    implementation("org.graalvm.js:js:24.2.1")
    implementation("org.graalvm.sdk:graal-sdk:24.2.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
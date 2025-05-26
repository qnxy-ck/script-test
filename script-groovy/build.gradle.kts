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
    implementation("org.apache.groovy:groovy:4.0.26")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
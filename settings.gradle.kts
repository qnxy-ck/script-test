plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "script-test"
include("script-groovy")
include("script-js-graalvm")
include("script-java-jar")
include("script-java-jar:java-jar")
include("script-java-jar:application")
include("script-java-jar:api")
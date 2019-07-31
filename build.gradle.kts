group = "de.tfr.game"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.3.41"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

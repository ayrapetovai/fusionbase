import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.40"
}

group = "ru.solidbase"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        setUrl("https://dl.bintray.com/s1m0nw1/KtsRunner")
    }
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

//    testCompile("de.swirtz:ktsRunner:0.0.1")
    testCompile(kotlin("script-runtime"))
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
//    testRuntime("org.junit.platform:junit-platform-console:1.2.0")

    // Kotlintest
//    testCompile("io.kotlintest:kotlintest-core:3.1.0-RC2")
//    testCompile("io.kotlintest:kotlintest-assertions:3.1.0-RC2")
//    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.0-RC2")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

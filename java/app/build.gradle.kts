plugins {
    application
    id("com.diffplug.spotless") version "8.2.1"
}

repositories {
    mavenCentral()
}

dependencies {
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "org.bloku.App"
}

spotless {
    java {
        googleJavaFormat()
    }
}

plugins {
    alias(libs.plugins.kotlin)
}

allprojects {
    group = "net.teaclient"

    repositories {
        maven("https://jitpack.io") {
            name = "Jitpack"
        }
        mavenCentral()
    }
}

subprojects {
    val secrets: File = rootProject.file("secrets.gradle.kts")
    if (secrets.exists()) {
        apply(from = secrets)
    }
}

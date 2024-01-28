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
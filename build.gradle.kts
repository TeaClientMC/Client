import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.base.DokkaBaseConfiguration


buildscript {
    dependencies {
        classpath(libs.dokka.base)
    }
}

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.dokka)
}

allprojects {
    group = "net.teaclient"


    repositories {
        maven("https://jitpack.io") {
            name = "Jitpack"
        }
        mavenCentral()
    }

    tasks.withType<DokkaTask>().configureEach {
        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            footerMessage = "(c) 2024 TeaClient"
            separateInheritedMembers = false
            mergeImplicitExpectActualDeclarations = false
        }
    }
}



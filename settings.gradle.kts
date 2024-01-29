pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        maven("https://maven.minecraftforge.net/") {
            name = "MinecraftForge"
        }
        mavenCentral()
    }
}

include("common", "fabric")
include("forge")

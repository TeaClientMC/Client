pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        maven("https://maven.minecraftforge.net/") {
            name = "MinecraftForge"
        }
        maven("https://maven.pkg.github.com/PlanetTeamSpeakk/DevLogin") {
            name = "DevLogin"
        }
        mavenCentral()
    }
}

include("common", "fabric")
include("forge")

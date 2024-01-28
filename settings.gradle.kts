pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        maven("https://api.modrinth.com/maven") {
            name = "Modrinth"

        }
        maven("https://www.cursemaven.com") {
            name = "CurseMaven"
        }
        mavenCentral()
    }
}

include("common", "fabric", "forge")

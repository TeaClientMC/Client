plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.dokka)
}

version = "${properties["net.teaclient.version"]}+${properties["net.teaclient.minecraft"]}-fabric"

base {
    archivesName.set(properties["net.teaclient.archives.base.name"].toString())
}

dependencies {
    minecraft(libs.minecraft)
    mappings(libs.yarn)

    implementation(project(":common"))

    modImplementation(libs.fabric.api)
    modImplementation(libs.fabric.language.kotlin)
    modImplementation(libs.fabric.loader)
//    modImplementation(libs.sodium)
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand(properties)
    }
}


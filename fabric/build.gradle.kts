plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.fabric.loom)
}

version = "${properties["net.teaclient.version"]}+${properties["net.teaclient.minecraft"]}-fabric"

dependencies {
    minecraft(libs.minecraft)
    mappings(libs.yarn)

    modImplementation(libs.fabric.api)
    modImplementation(libs.fabric.language.kotlin)
    modImplementation(libs.fabric.loader)
}

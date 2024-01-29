plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.dokka)
//    alias(libs.plugins.minecraft.forge)
}



version = "${properties["net.teaclient.version"]}+${properties["net.teaclient.minecraft"]}-forge"


base {
    archivesName.set(properties["net.teaclient.archives.base.name"].toString())
}


tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand(properties)
    }
}

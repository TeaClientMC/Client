plugins {
    alias(libs.plugins.kotlin)
}

version = "${properties["net.teaclient.version"]}+${properties["net.teaclient.minecraft"]}-common"

dependencies {
    implementation(libs.discord.ipc)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.log4j.core)
}
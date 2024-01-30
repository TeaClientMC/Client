package net.teaclient

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.loader.api.FabricLoader
import java.io.File

/**
 * The client entrypoint to the Fabric mod. The fully-qualified name of this class
 * (i.e. net.teaclient.ClientTeaClientFabric) is to be registered as a `client` entrypoint
 * in the `fabric.mod.json` Fabric mod manifest file.
 *
 * `client` entrypoint classes typically implement the [net.fabricmc.api.ClientModInitializer]
 * interface and overrides the [net.fabricmc.api.ClientModInitializer.onInitializeClient] function to
 * implement the initialization logic of the mod in the scope of the client.
 *
 * @author HTGAzureX1212.
 * @see net.fabricmc.api.ClientModInitializer
 * @since 0.1.0
 */
class ClientTeaClientFabric : ClientModInitializer {
    /**
     * The [onInitializeClient] function, overriding the [net.fabricmc.api.ClientModInitializer.onInitializeClient]
     * function, runs the initialization logic for the mod in the scope of the client.
     *
     * @author HTGAzureX1212.
     * @return nothing.
     * @see net.fabricmc.api.ClientModInitializer.onInitializeClient
     * @since 0.1.0
     */
    override fun onInitializeClient() {
        val configurationPath = File(FabricLoader.getInstance().configDir.toString() + "/teaclient")
        if (!configurationPath.exists())
            configurationPath.mkdir()

        val splashPath = Thread.currentThread().contextClassLoader.getResourceAsStream("assets/teaclient/splash.png")
        val iconPath = Thread.currentThread().contextClassLoader.getResourceAsStream("assets/minecraft/splashLogo.png")
        val ProgressBackground = Thread.currentThread().contextClassLoader.getResourceAsStream("assets/teaclient/progress_background.png")
        val ProgressRender = Thread.currentThread().contextClassLoader.getResourceAsStream("assets/teaclient/progress_bar.png")

    }
}
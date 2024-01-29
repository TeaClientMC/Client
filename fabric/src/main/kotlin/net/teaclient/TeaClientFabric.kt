package net.teaclient

import net.fabricmc.api.ModInitializer
import net.teaclient.common.diagnostics.Logger
import net.teaclient.common.discord.DiscordIpcConnection
import net.teaclient.common.discord.DiscordRichPresence

/**
 * The entrypoint to the Fabric mod. The fully-qualified name of this class
 * (i.e. net.teaclient.TeaClientFabric) is to be registered as a `main` entrypoint
 * in the `fabric.mod.json` Fabric mod manifest file.
 *
 * `main` entrypoint classes typically implement the [net.fabricmc.api.ModInitializer]
 * interface and overrides the [net.fabricmc.api.ModInitializer.onInitialize] function to
 * implement the initialization logic of the mod.
 *
 * @author HTGAzureX1212.
 * @see net.fabricmc.api.ModInitializer
 * @since 0.1.0
 */
class TeaClientFabric : ModInitializer {
    /**
     * The [onInitialize] function, overriding the [net.fabricmc.api.ModInitializer.onInitialize]
     * function, runs the initialization logic for the mod.
     *
     * @author HTGAzureX1212.
     * @return nothing.
     * @see net.fabricmc.api.ModInitializer.onInitialize
     * @since 0.1.0
     */
    override fun onInitialize() {
        Logger.logger.info("Hello world from TeaClient")

        // TODO: move all of this Discord Rich Presence thing to a toggleable module
        val connection = DiscordIpcConnection(1201074663988658267UL)
        connection.connect()
        Thread.sleep(5000)
        val presence = DiscordRichPresence(1201074663988658267UL, "TeaClient", "Minecraft 1.20.1")
        connection.send(presence, 4500)
    }
}
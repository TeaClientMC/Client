package net.teaclient

import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager

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
     * A static instance of a Log4j [org.apache.logging.log4j.Logger] used by the client.
     *
     * Constructed by invoking the [org.apache.logging.log4j.LogManager.getLogger] function.
     *
     * @author HTGAzureX1212.
     * @see org.apache.logging.log4j.Logger
     * @since 0.1.0
     */
    val logger = LogManager.getLogger("TeaClient")

    /**
     * The [onInitialize] function, overriding the [net.fabricmc.api.ModInitializer.onInitialize]
     * function, runs the initialization logic for the client mod.
     *
     * @author HTGAzureX1212.
     * @return nothing.
     * @see net.fabricmc.api.ModInitializer.onInitialize
     * @since 0.1.0
     */
    override fun onInitialize() {
        logger.info("Hello world from TeaClient")
    }
}
package net.teaclient

import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager

class TeaClient : ModInitializer {
    val logger = LogManager.getLogger("TeaClient")

    override fun onInitialize() {
        logger.info("Hello world from TeaClient")
    }
}
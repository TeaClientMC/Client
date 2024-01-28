package net.teaclient.common.diagnostics

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

/**
 * An object class holding various loggers used by the project.
 */
object Logger {
    /**
     * An instance of a Log4j [org.apache.logging.log4j.Logger] used by the client.
     * This is mostly used for top-level logging and diagnostic output.
     *
     * Constructed by invoking the [org.apache.logging.log4j.LogManager.getLogger] function.
     *
     * @author HTGAzureX1212.
     * @see org.apache.logging.log4j.Logger
     * @since 0.1.0
     */
    val logger: Logger = LogManager.getLogger("TeaClient")

    /**
     * An instance of a Log4j [org.apache.logging.log4j.Logger] used by the client.
     * This is mostly used for the Discord IPC (for rich presences) component of the client.
     *
     * Constructed by invoking the [org.apache.logging.log4j.LogManager.getLogger] function.
     *
     * @author HTGAzureX1212.
     * @see org.apache.logging.log4j.Logger
     * @since 0.1.0
     */
    val discordLogger: Logger = LogManager.getLogger("TeaClient-Discord")
}
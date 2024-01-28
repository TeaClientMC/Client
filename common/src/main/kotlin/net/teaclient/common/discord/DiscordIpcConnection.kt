package net.teaclient.common.discord

import dev.cbyrne.kdiscordipc.KDiscordIPC
import dev.cbyrne.kdiscordipc.core.event.impl.ReadyEvent
import kotlinx.coroutines.*
import net.teaclient.common.diagnostics.Logger
import kotlin.coroutines.CoroutineContext

/**
 * Represents a Discord IPC connection.
 *
 * This class manages the act of connecting to, disconnecting from and sending [DiscordRichPresence]s
 * to Discord within the connection.
 *
 * @author HTGAzureX1212.
 * @constructor Creates an IPC connection with an application ID.
 * @since 0.1.0
 */
class DiscordIpcConnection(applicationId: ULong) : CoroutineScope {
    /**
     * A [kotlin.coroutines.CoroutineContext] for this [kotlinx.coroutines.CoroutineScope] to use.
     *
     * @author HTGAzureX1212.
     * @since 0.1.0
     */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    /**
     * A [Job] instance of a supervisor job for the coroutine context.
     *
     * @author HTGAzureX1212.
     * @see [kotlinx.coroutines.SupervisorJob]
     * @since 0.1.0
     */
    private val job: Job = SupervisorJob()

    /**
     * The Discord IPC client used by this IPC connection.
     *
     * The client registers a listener for the [ReadyEvent] when the connection is ready.
     * Discord sends a `READY` event when that is the case, and we receive it and handle it
     * in the [onReadyEvent] function.
     *
     * @author HTGAzureX1212.
     * @see [dev.cbyrne.kdiscordipc.KDiscordIPC]
     * @since 0.1.0
     */
    private val ipcClient: KDiscordIPC = KDiscordIPC(applicationId.toString()).apply {
        runBlocking {
            on<ReadyEvent>(::onReadyEvent)
        }
    }

    /**
     * Connect to the Discord IPC using the client associated with this connection.
     *
     * @author HTGAzureX1212.
     * @since 0.1.0
     */
    fun connect() {
        if (!ipcClient.connected) {
            Logger.discordLogger.trace("No Discord IPC connection found, making a new connection")

            val exceptionHandler = CoroutineExceptionHandler { _, exception ->
                Logger.discordLogger.error("Could not connect to Discord IPC due to an exception", exception)
            }

            launch(exceptionHandler) {
                withTimeoutOrNull(5000) {
                    ipcClient.connect()
                    Logger.discordLogger.info("Connected to Discord IPC successfully")
                }
            }
        }
    }

    /**
     * Disconnect from the Discord IPC using the client associated with this connection.
     *
     * @author HTGAzureX1212.
     * @since 0.1.0
     */
    fun disconnect() {
        if (ipcClient.connected) {
            Logger.discordLogger.trace("Discord IPC connection found, attempting to disconnect")

            val exceptionHandler = CoroutineExceptionHandler { _, exception ->
                Logger.discordLogger.error("Could not disconnect from Discord IPC due to an exception", exception)
            }

            launch(exceptionHandler) {
                withTimeoutOrNull(5000) {
                    ipcClient.disconnect()
                    Logger.discordLogger.info("Disconnected from Discord IPC successfully")
                }
            }
        }
    }

    /**
     * Send a [DiscordRichPresence] to Discord via Discord IPC.
     */
    fun send(presence: DiscordRichPresence, timeoutMillis: Long) {
        if (ipcClient.connected) {
            Logger.discordLogger.info("Discord IPC client is still connected, sending rich presence")

            val exceptionHandler = CoroutineExceptionHandler { _, exception ->
                Logger.discordLogger.error("Could not send rich presence via Discord IPC due to an exception", exception)
            }

            launch(exceptionHandler) {
                withTimeoutOrNull(timeoutMillis) {
                    ipcClient.activityManager.setActivity(presence.toActivity())
                    Logger.discordLogger.info("Sent rich presence to Discord via Discord IPC")
                }
            }
        }
    }

    /**
     * Callback for handling the `READY` event when it is received.
     *
     * @author HTGAzureX1212.
     * @since 0.1.0
     */
    private fun onReadyEvent(event: ReadyEvent) {
        Logger.discordLogger.info("Discord IPC client is ready, connected to the Discord gateway version ${event.data.version}")
    }
}
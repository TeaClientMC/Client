package net.teaclient.common.discord

import dev.cbyrne.kdiscordipc.data.activity.Activity
import dev.cbyrne.kdiscordipc.data.activity.activity
import dev.cbyrne.kdiscordipc.data.activity.largeImage

/**
 * Represents a Discord rich presence object to be sent in the [DiscordIpcConnection].
 *
 * @author HTGAzureX1212.
 * @constructor Creates a rich presence from an application ID.
 * @since 0.1.0
 */
// TODO: validate lengths of state and details strings
class DiscordRichPresence(val applicationId: ULong, val state: String? = null, val details: String? = null)

/**
 * Convert a [DiscordRichPresence] object to a Discord IPC [Activity].
 *
 * @author HTGAzureX1212.
 * @see [dev.cbyrne.kdiscordipc.data.activity.Activity]
 * @since 0.1.0
 */
fun DiscordRichPresence.toActivity(): Activity = activity(this@toActivity.details, this@toActivity.state) {
    this.largeImage("teaclient", "TeaClient - 1.20.1")
}
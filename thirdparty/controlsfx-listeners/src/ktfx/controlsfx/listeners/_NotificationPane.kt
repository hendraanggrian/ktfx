@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import javafx.event.Event
import org.controlsfx.control.NotificationPane
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see NotificationPane.setOnShowing
 */
public inline fun NotificationPane.onShowing(noinline action: (Event) -> Unit) {
    return setOnShowing(action)
}

/**
 * @see NotificationPane.setOnShown
 */
public inline fun NotificationPane.onShown(noinline action: (Event) -> Unit) {
    return setOnShown(action)
}

/**
 * @see NotificationPane.setOnHiding
 */
public inline fun NotificationPane.onHiding(noinline action: (Event) -> Unit) {
    return setOnHiding(action)
}

/**
 * @see NotificationPane.setOnHidden
 */
public inline fun NotificationPane.onHidden(noinline action: (Event) -> Unit) {
    return setOnHidden(action)
}

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.NodeManager
import org.controlsfx.control.NotificationPane
import kotlin.contracts.ExperimentalContracts

/**
 * [NotificationPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxNotificationPane : NotificationPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}

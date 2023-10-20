@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Paint
import kotlin.contracts.ExperimentalContracts

/**
 * [Scene] with dynamic-layout dsl support.
 * Invoking dsl will only set its root.
 */
open class KtfxScene(root: Parent, width: Double, height: Double, fill: Paint) :
    Scene(root, width, height, fill), NodeContainer {
    final override fun <T : Node> addChild(child: T): T =
        child.also {
            root = it as? Pane ?: Pane(it)
        }
}

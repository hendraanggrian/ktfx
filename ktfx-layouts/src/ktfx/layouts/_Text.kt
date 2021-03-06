@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.text.Text
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Text] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.text(text: String? = null): Text = text(text = text) { }

/**
 * Create a [Text] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun text(text: String? = null, configuration: (@KtfxLayoutDslMarker Text).() -> Unit):
    Text {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Text(text)
    child.configuration()
    return child
}

/**
 * Add a [Text] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.text(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        Text
    ).() -> Unit
): Text {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Text(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Text].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledText(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): Text = styledText(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Text] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledText(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): Text = styledText(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Text] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledText(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Text(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Text] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledText(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Text(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

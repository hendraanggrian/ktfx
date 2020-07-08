@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ProgressBar] to this manager.
 */
fun NodeManager.progressBar(progress: Double = INDETERMINATE_PROGRESS): ProgressBar =
    progressBar(progress = progress) { }

/**
 * Create a [ProgressBar] with configuration block.
 */
inline fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (
        @LayoutDslMarker    
        ProgressBar
    ).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ProgressBar(progress), configuration = configuration)
}

/**
 * Add a [ProgressBar] with configuration block to this manager.
 */
inline fun NodeManager.progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ProgressBar(progress), configuration = configuration))
}

/**
 * Create a styled [ProgressBar].
 */
fun styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): ProgressBar = styledProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ProgressBar] to this manager.
 */
fun NodeManager.styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): ProgressBar = styledProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ProgressBar] with configuration block.
 */
inline fun styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ProgressBar(progress), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ProgressBar] with configuration block to this manager.
 */
inline fun NodeManager.styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ProgressBar(progress), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

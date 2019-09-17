@file:Suppress("NOTHING_TO_INLINE", "PackageDirectoryMismatch", "UsePropertyAccessSyntax")

package ktfx.controlsfx

import java.util.Optional
import javafx.concurrent.Worker
import javafx.scene.Node
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.ProgressDialog

/**
 * Build a progress dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param worker progress worker.
 */
fun progressDialog(
    title: String? = null,
    graphic: Node? = null,
    worker: Worker<*>?
): Optional<Void> = ProgressDialog(worker).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build a progress dialog with Kotlin DSL.
 *
 * @param worker progress worker.
 */
inline fun progressDialog(
    worker: Worker<*>?
): Optional<Void> = progressDialog(null, null, worker)

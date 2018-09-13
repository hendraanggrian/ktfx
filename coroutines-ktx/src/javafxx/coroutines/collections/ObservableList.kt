@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.collections.ListChangeListener
import javafx.collections.ListChangeListener.Change
import javafx.collections.ObservableList
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable list. */
fun <E> ObservableList<E>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Change<out E>) -> Unit
): ListChangeListener<E> = ListChangeListener<E> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }
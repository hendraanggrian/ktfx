@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.TableColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TableColumn.setOnEditStart
 */
public fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) {
    return setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TableColumn.setOnEditCommit
 */
public fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) {
    return setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see TableColumn.setOnEditCancel
 */
public fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) {
    return setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }
}

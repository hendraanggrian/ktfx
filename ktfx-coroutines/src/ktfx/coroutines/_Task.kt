@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
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
 * @see Task.setOnScheduled
 */
public fun Task<*>.onScheduled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WorkerStateEvent) -> Unit
) {
    return setOnScheduled { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Task.setOnRunning
 */
public fun Task<*>.onRunning(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WorkerStateEvent) -> Unit
) {
    return setOnRunning { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Task.setOnSucceeded
 */
public fun Task<*>.onSucceeded(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WorkerStateEvent) -> Unit
) {
    return setOnSucceeded { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Task.setOnCancelled
 */
public fun Task<*>.onCancelled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WorkerStateEvent) -> Unit
) {
    return setOnCancelled { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Task.setOnFailed
 */
public fun Task<*>.onFailed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WorkerStateEvent) -> Unit
) {
    return setOnFailed { event -> GlobalScope.launch(context) { action(event) } }
}

@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun <T> listViewOf(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()
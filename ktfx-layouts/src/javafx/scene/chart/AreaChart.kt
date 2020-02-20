@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create an [AreaChart] with configuration block. */
inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return AreaChart(x, y, data).apply(configuration)
}

/** Add an [AreaChart] to this manager. */
fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): AreaChart<X, Y> = addChild(AreaChart(x, y, data))

/** Add an [AreaChart] with configuration block to this manager. */
inline fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(AreaChart(x, y, data), configuration)
}

@file:Suppress("NOTHING_TO_INLINE")

package javafxx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos

/** The vertical positioning/alignment. */
inline operator fun Pos.component1(): VPos = vpos

/** The horizontal positioning/alignment. */
inline operator fun Pos.component2(): HPos = hpos

@PublishedApi
internal fun mergePos(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
    if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it)
}
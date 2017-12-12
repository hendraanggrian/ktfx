package kotfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.layout.VBox.*

@PublishedApi
internal class FXVBoxBuilder : VBoxBuilder {

    override val t: VBox = VBox()
}

interface VBoxBuilder : PaneBuilder<VBox> {

    infix fun Node.vgrow(priority: Priority) = setVgrow(this, priority)
    val Node.vgrow: Priority get() = getVgrow(this)

    infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    fun Node.margin(top: Double, right: Double, bottom: Double, left: Double) = setMargin(this, Insets(top, right, bottom, left))
    val Node.margin: Insets get() = getMargin(this)

    infix fun Node.topMargin(margin: Double) = margin(8.0, 0.0, 0.0, 0.0)
    infix fun Node.rightMargin(margin: Double) = margin(0.0, 8.0, 0.0, 0.0)
    infix fun Node.bottomMargin(margin: Double) = margin(0.0, 0.0, 8.0, 0.0)
    infix fun Node.leftMargin(margin: Double) = margin(0.0, 0.0, 0.0, 8.0)

    fun Node.clearConstraints() = VBox.clearConstraints(this)
}
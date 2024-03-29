package ktfx.jfoenix.test

import com.hendraanggrian.ktfx.test.initToolkit
import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseJFXDialogTest {
    private lateinit var dialog: JFXDialog

    abstract fun JFXDialog.callOnDialogClosed(action: (JFXDialogEvent) -> Unit)
    abstract fun JFXDialog.callOnDialogOpened(action: (JFXDialogEvent) -> Unit)

    @BeforeTest
    fun start() {
        initToolkit()
        dialog = JFXDialog()
    }

    @Test
    fun onDialogClosed() {
        dialog.callOnDialogClosed { assertEquals(JFXDialogEvent.CLOSED, it.eventType) }
        dialog.onDialogClosed.handle(JFXDialogEvent(JFXDialogEvent.CLOSED))
    }

    @Test
    fun onDialogOpened() {
        dialog.callOnDialogOpened { assertEquals(JFXDialogEvent.OPENED, it.eventType) }
        dialog.onDialogOpened.handle(JFXDialogEvent(JFXDialogEvent.OPENED))
    }
}

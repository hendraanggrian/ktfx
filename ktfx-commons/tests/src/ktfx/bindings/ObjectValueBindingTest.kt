package ktfx.bindings

import ktfx.propertyOf
import ktfx.time.minutes
import ktfx.time.seconds
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObjectValueBindingTest {

    @Test
    fun eq() {
        assertFalse((propertyOf<Duration>() eq propertyOf(1.minutes)).value)
        assertTrue((propertyOf(60.seconds) eq propertyOf(1.minutes)).value)
    }

    @Test
    fun neq() {
        assertTrue((propertyOf<Duration>() neq propertyOf(1.minutes)).value)
        assertFalse((propertyOf(60.seconds) neq propertyOf(1.minutes)).value)
    }
}

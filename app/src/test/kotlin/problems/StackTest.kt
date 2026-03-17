package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class StackTest {

    @Test
    fun `valid parentheses string returns true`() {
        assertTrue(isCorrectString("()[]{}"))
        assertTrue(isCorrectString("{[]}"))
    }

    @Test
    fun `invalid parentheses string returns false`() {
        assertFalse(isCorrectString("(]"))
        assertFalse(isCorrectString("([)]"))
    }

    @Test
    fun `empty string returns true`() {
        assertTrue(isCorrectString(""))
    }

    @Test
    fun `unclosed bracket returns false`() {
        assertFalse(isCorrectString("("))
    }

    @Test
    fun `extra closing bracket returns false`() {
        assertFalse(isCorrectString("())"))
    }

    @Test
    fun `wrong ordering returns false`() {
        assertFalse(isCorrectString("([{)])"))
    }

    @Test
    fun `weird ordering returns false`() {
        assertFalse(isCorrectString("([{)]}"))
    }
}


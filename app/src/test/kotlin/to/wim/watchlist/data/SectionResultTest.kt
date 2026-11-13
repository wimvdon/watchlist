package to.wim.watchlist.data

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SectionResultTest {
    @Test
    fun `every row failing is a failure`() {
        assertTrue(SectionResult.allFailed(listOf(true, true, true), rowCount = 3))
    }

    @Test
    fun `rows still loading are not a failure yet`() {
        assertFalse(SectionResult.allFailed(listOf(true, true), rowCount = 3))
    }

    @Test
    fun `one row loading fine is not a failure`() {
        assertFalse(SectionResult.allFailed(listOf(true, false, true), rowCount = 3))
    }

    @Test
    fun `no rows is not a failure`() {
        assertFalse(SectionResult.allFailed(emptyList(), rowCount = 0))
    }
}

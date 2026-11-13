package to.wim.watchlist.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import to.wim.watchlist.data.model.MediaType

class SearchResultsTest {
    private val down = Result.failure<List<to.wim.watchlist.data.model.MediaSummary>>(RuntimeException("offline"))

    @Test
    fun `every request failing is a failure, not an empty result`() {
        assertTrue(SearchResults.of(listOf(MediaType.Movie to down, MediaType.Tv to down)).failed)
    }

    @Test
    fun `one type answering is not a failure`() {
        val r = SearchResults.of(listOf(MediaType.Movie to down, MediaType.Tv to Result.success(emptyList())))
        assertFalse(r.failed)
        assertEquals(emptyList<Any>(), r.byType[MediaType.Movie])
    }

    @Test
    fun `nothing asked is not a failure`() {
        assertFalse(SearchResults.of(emptyList()).failed)
    }
}

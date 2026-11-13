package to.wim.watchlist.data

import to.wim.watchlist.data.model.MediaSummary
import to.wim.watchlist.data.model.MediaType

/** A search's results per type; [failed] when every request failed, so the screen says so instead of "No results". */
data class SearchResults(val byType: Map<MediaType, List<MediaSummary>>, val failed: Boolean) {
    companion object {
        val Empty = SearchResults(emptyMap(), failed = false)

        fun of(outcomes: List<Pair<MediaType, Result<List<MediaSummary>>>>): SearchResults =
            SearchResults(
                byType = outcomes.associate { (type, result) -> type to result.getOrDefault(emptyList()) },
                failed = outcomes.isNotEmpty() && outcomes.all { it.second.isFailure },
            )
    }
}

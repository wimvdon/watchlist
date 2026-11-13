package to.wim.watchlist.data

import to.wim.watchlist.data.model.MediaSummary

/** One Discover row: its titles, and whether every source for it failed (offline, SIMKL down). */
data class SectionResult(val items: List<MediaSummary>, val failed: Boolean) {
    companion object {
        /** Discover says it couldn't load only when every row has answered and every one failed. */
        fun allFailed(failedByRow: Collection<Boolean>, rowCount: Int): Boolean =
            rowCount > 0 && failedByRow.size == rowCount && failedByRow.all { it }
    }
}

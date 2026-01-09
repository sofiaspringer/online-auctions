package auctions

data class Auction(
    val name: String,
    val startDate: String,
    val endDate: String,
    val status: Status
)

enum class Status {
    NOT_STARTED,
    IN_PROGRESS,
    FINISHED
}
package auctions.tracker

data class AuctionsCatalog(val auctions: List<Auction>)

data class Auction(val name: String, val status: AuctionStatus)

enum class AuctionStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED,
}
import org.junit.Assert.*
import org.junit.Test

class MainKtTest {
//    private val service = WallService()

    @Test
    fun addPost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 1
        val result = WallService.add(post)
        assertEquals(expected, result)

    }

    @Test
    fun likePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 1

        var copy = post.copy(id = WallService.add(post))
        copy = copy.copy(id = WallService.add(post))

        val result = WallService.likeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun removePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 5

        var copy = post.copy(id = WallService.add(post))
        copy = copy.copy(id = WallService.add(copy))
        copy = copy.copy(id = WallService.add(copy))
        WallService.remove(1)

        val result = WallService.sizeWallPosts()
        assertEquals(expected, result)
    }

    @Test
    fun dislikePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 2

        var copy = post.copy(id = WallService.add(post))
        copy = copy.copy(id = WallService.add(post))
        WallService.dislikeById(1)

        val result = WallService.dislikeById(1)
        assertEquals(expected, result)

    }
}
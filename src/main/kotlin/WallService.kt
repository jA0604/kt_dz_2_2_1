object WallService {

    var id = 0

    var posts = emptyArray<Post>()

    fun add(post: Post): Int {
        posts += post.copy(id = id++)
        return id
    }

    fun remove(removeId: Int): Int {
        val postWithoutId = posts.filterIndexed { index, s -> (index != removeId)}
        posts = postWithoutId.toTypedArray()
        return --id
    }

    fun likeById(id: Int): Int {
        posts.forEachIndexed { index, post ->
            if (index == id) {
                val countLikes = posts[index].likes.countLikes + 1
                val countDislakes = posts[index].likes.countDislikes
                posts[index] = posts[index].copy(likes = Likes(countLikes, countDislakes))
                return posts[index].likes.countLikes
            }
        }
        return 0
    }

    fun dislikeById(id: Int): Int {
        for (post in posts) {
            if (post.id == id) {
                val countLikes = posts[id].likes.countLikes
                val countDislakes = posts[id].likes.countDislikes + 1
                posts[id] = posts[id].copy(likes = Likes(countLikes, countDislakes))
                return posts[id].likes.countDislikes
            }
        }
        return 0
    }

    fun sizeWallPosts() = posts.size
}
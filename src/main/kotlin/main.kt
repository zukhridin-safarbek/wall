data class Post(
    var id: Int = 0,
    val owner_id: Int,
    val date: Int,
    val text: String = " ",
    val replay_owner_id: Int,
    val friends_only: Boolean,
    val comments: Comments = Comments(),
    val copyright: String = "zim",
    val likes: Likes = Likes(),
    val views: Views = Views(),
    val post_type: String,
    val signer_id: Int,
    val can_pin: Boolean = true,
    val can_delete: Boolean = true,
    val can_edit: Boolean = true,
    val marked_as_ads: Boolean = false,
    val is_favorite: Boolean = false,
)
data class Likes(
    val count: Int = 0,
    val user_likes: Boolean = true,
    val can_publish: Boolean = true
)
data class Comments(
    var count: Int = 0,
    var can_post: Boolean = true, )

data class Views(
    val count: Int = 0
)
object WallService{
    private var posts = emptyArray<Post>()
    private var id: Int = 0;
    fun add(post: Post): Post {
        posts += post
        posts[id] = post
        while (post.id < posts.size){
            post.id += 1

        }
        id += 1
        return posts.last()
    }
    fun update(index: Int, post: Post): Boolean{

        return posts.indexOf(post) == index
    }
    fun get(id: Int): Post {
        return posts[id]
    }
}
fun main(){
    val post = Post( owner_id = 1, date = 2022, text = "Hi, Kotlin", friends_only = false, post_type = "post",
        replay_owner_id = 2, signer_id = 2
    )
    val post2 = Post( owner_id = 1, date = 2022, text = "Kotlin", friends_only = false, post_type = "post",
        replay_owner_id = 2, signer_id = 2
    )
    val post3 = Post( owner_id = 1, date = 2022, text = "3Kotlin", friends_only = false, post_type = "post",
        replay_owner_id = 2, signer_id = 2
    )
    val uPost = Post(id = 1, owner_id = 1, date = 2022, text = "Hello, Kotlin", friends_only = false, post_type = "post",
        replay_owner_id = 2, signer_id = 2
    )

    WallService.add(post)
    WallService.add(post2)
    println(WallService.update(0, post))
    println(WallService.get(0))

}
package `rpcx-demo-provider`

class UserServiceImpl : UserService {
    fun findById(id: Int): User {
        return User(id, "KK" + System.currentTimeMillis())
    }
}
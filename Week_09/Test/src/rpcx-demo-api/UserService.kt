package `rpcx-demo-api`

interface UserService {
    fun findById(id: Int): User?
}
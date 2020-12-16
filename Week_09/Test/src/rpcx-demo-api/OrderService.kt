package `rpcx-demo-api`

interface OrderService {
    fun findOrderById(id: Int): Order?
}
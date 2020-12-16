package `rpcx-demo-provider`

class OrderServiceImpl : OrderService {
    fun findOrderById(id: Int): Order {
        return Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f)
    }
}
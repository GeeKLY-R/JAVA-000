package `rpcx-demo-consumer`

import org.springframework.boot.autoconfigure.SpringBootApplication


object RpcfxClientApplication {
    // 二方库
// 三方库 lib
// nexus, userserivce -> userdao -> user
//
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) { // UserService service = new xxx();
// service.findById
        val userService: UserService = Rpcfx.create(UserService::class.java, "http://localhost:8080/")
        val user: User = userService.findById(1)
        System.out.println("find user id=1 from server: " + user.getName())
        val orderService: OrderService = Rpcfx.create(OrderService::class.java, "http://localhost:8080/")
        val order: Order = orderService.findOrderById(1992129)
        println(java.lang.String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()))
        // 新加一个OrderService
//		SpringApplication.run(RpcfxClientApplication.class, args);
    }
}
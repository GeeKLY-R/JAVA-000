package `rpcx-demo-provider`

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.SpringApplication

import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.context.annotation.Bean

import org.springframework.web.bind.annotation.PostMapping

import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
@RestController
class RpcfxServerApplication {
    @Autowired
    var invoker: RpcfxInvoker? = null

    @PostMapping("/")
    operator fun invoke(@RequestBody request: RpcfxRequest?): RpcfxResponse {
        return invoker.invoke(request)
    }

    @Bean
    fun createInvoker(@Autowired resolver: RpcfxResolver?): RpcfxInvoker {
        return RpcfxInvoker(resolver)
    }

    @Bean
    fun createResolver(): RpcfxResolver {
        return DemoResolver()
    }

    // 能否去掉name
//
    @Bean(name = "io.kimmking.rpcfx.demo.api.UserService")
    fun createUserService(): UserService {
        return UserServiceImpl()
    }

    @Bean(name = "io.kimmking.rpcfx.demo.api.OrderService")
    fun createOrderService(): OrderService {
        return OrderServiceImpl()
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(RpcfxServerApplication::class.java, args)
        }
    }
}
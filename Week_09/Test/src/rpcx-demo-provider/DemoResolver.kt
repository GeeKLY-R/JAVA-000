package `rpcx-demo-provider`

import org.springframework.context.ApplicationContext

import org.springframework.context.ApplicationContextAware


class DemoResolver : RpcfxResolver, ApplicationContextAware {
    private var applicationContext: ApplicationContext? = null
    fun setApplicationContext(applicationContext: ApplicationContext?) {
        this.applicationContext = applicationContext
    }

    fun resolve(serviceClass: String?): Any {
        return applicationContext.getBean(serviceClass)
    }
}
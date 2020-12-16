package `rpcx-core`

import com.alibaba.fastjson.JSON

import com.alibaba.fastjson.parser.ParserConfig

import io.kimmking.rpcfx.api.HttpClientUtils

import io.kimmking.rpcfx.api.RpcfxException

import io.kimmking.rpcfx.api.RpcfxRequest

import io.kimmking.rpcfx.api.RpcfxResponse

import okhttp3.MediaType

import okhttp3.OkHttpClient

import okhttp3.Request

import okhttp3.RequestBody
import java.awt.PageAttributes.MediaType


import java.io.IOException
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object Rpcfx {
    fun <T> create(serviceClass: Class<T?>, url: String): T { // 0. 替换动态代理 -> AOP
        return Proxy.newProxyInstance(Rpcfx::class.java.getClassLoader(), arrayOf<Class<*>>(serviceClass), RpcfxInvocationHandler(serviceClass, url)) as T
    }

    class RpcfxInvocationHandler(serviceClass: Class<T?>, url: String) : InvocationHandler {
        private val serviceClass: Class<*>
        private val url: String
        // 可以尝试，自己去写对象序列化，二进制还是文本的，，，rpcfx是xml自定义序列化、反序列化，json: code.google.com/p/rpcfx
// int byte char float double long bool
// [], data class
        @kotlin.jvm.Throws(Throwable::class)
        override fun invoke(proxy: Any, method: Method, params: Array<Any>): Any {
            val request = RpcfxRequest()
            request.setServiceClass(serviceClass.name)
            request.setMethod(method.name)
            request.setParams(params)
            val response = post(request, url)
            // 这里判断response.status，处理异常
// 考虑封装一个全局的RpcfxException
            if (!response.isStatus()) {
                throw RpcfxException("请求异常!异常url:$url")
            }
            return JSON.parse(response.getResult().toString())
        }

        @kotlin.jvm.Throws(IOException::class)
        private fun post(req: RpcfxRequest, url: String): RpcfxResponse {
            val reqJson: String = JSON.toJSONString(req)
            println("req json: $reqJson")
            // 1.可以复用client
// 2.尝试使用httpclient或者netty client
            val respJson = HttpClientUtils.httpPostJson(reqJson, url)
            println("resp json: $respJson")
            return JSON.parseObject(respJson, RpcfxResponse::class.java)
        }

        companion object {
            val JSONTYPE: MediaType = MediaType.get("application/json; charset=utf-8")
        }

        init {
            this.serviceClass = serviceClass
            this.url = url
        }
    }

    init {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking")
    }
}
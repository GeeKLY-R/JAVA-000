package `rpcx-core`


import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import io.kimmking.rpcfx.api.RpcfxRequest
import io.kimmking.rpcfx.api.RpcfxResolver
import io.kimmking.rpcfx.api.RpcfxResponse
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.*

class RpcfxInvoker(private val resolver: RpcfxResolver) {
    operator fun invoke(request: RpcfxRequest): RpcfxResponse {
        val response = RpcfxResponse()
        val serviceClass: String = request.getServiceClass()
        // 作业1：改成泛型和反射
        val service = resolver.resolve(serviceClass) //this.applicationContext.getBean(serviceClass);
        return try {
            val method = resolveMethodFromClass(service.javaClass, request.getMethod())
            val result = method.invoke(service, request.getParams()) // dubbo, fastjson,
            // 两次json序列化能否合并成一个
            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName))
            response.setStatus(true)
            response
        } catch (e: IllegalAccessException) { // 3.Xstream
// 2.封装一个统一的RpcfxException
// 客户端也需要判断异常
            e.printStackTrace()
            response.setException(e)
            response.setStatus(false)
            response
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
            response.setException(e)
            response.setStatus(false)
            response
        }
    }

    private fun resolveMethodFromClass(klass: Class<*>, methodName: String): Method {
        return Arrays.stream(klass.methods).filter { m: Method -> methodName == m.name }.findFirst().get()
    }

}
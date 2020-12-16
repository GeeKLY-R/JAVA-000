package `rpcx-core`

interface RpcfxResolver {
    fun resolve(serviceClass: String?): Any?

}
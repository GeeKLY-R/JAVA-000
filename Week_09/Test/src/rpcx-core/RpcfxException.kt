package `rpcx-core`

import lombok.Data


/**
 * @PROJECT_NAME: rpcfx
 * @PACKAGE_NAME: io.kimmking.rpcfx.api
 * @NAME: RpcfxException
 * @Author: guanys
 * @DATE: 12/16/20:2:54 PM
 * @Description: TODO
 * @Version: 1.0
 */
@Data
class RpcfxException : RuntimeException {
    private var errCode: String? = null
    private var data: Any? = null

    constructor() {}
    constructor(errMsg: String?) : super(errMsg) {}
    constructor(errCode: String?, errMsg: String?, data: Any?) : super(errMsg) {
        this.errCode = errCode
        this.data = data
    }
}
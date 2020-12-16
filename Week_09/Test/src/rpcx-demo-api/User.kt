package `rpcx-demo-api`

class User {
    constructor() {}
    constructor(id: Int, name: String?) {
        this.id = id
        this.name = name
    }

    var id = 0
    var name: String? = null

}
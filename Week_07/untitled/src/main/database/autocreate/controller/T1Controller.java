package main.database.autocreate.controller;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guanys
 * @since 2020-12-01
 */
@RestController
@RequestMapping("/t1")
public class T1Controller {

    @Autowired
    private IT1Service service;

    @RequestMapping("/getList")
    public List<Integer> getList(){
        return service.getList();
    }

    @RequestMapping("/add")
    public void add(@RequestParam("id") Integer id){
        service.add(id);
    }
}
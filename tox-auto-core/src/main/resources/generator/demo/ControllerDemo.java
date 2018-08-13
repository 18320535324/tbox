package {{controllerPackage}};


import {{modelPackage}}.{{className}};
import {{servicePackage}}.{{className}}Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.jjfinder.tbox.common.constant.ApiCoreConstant;
import com.jjfinder.tbox.base.controller.BaseController;
import com.jjfinder.tbox.common.vo.RespMsg;
import com.jjfinder.jbase.common.service.MyQuery;
import com.jjfinder.jbase.common.service.DgTableData;
import static com.jjfinder.tbox.common.constant.ApiCommonConstant.*;

/**
 *
 * @author {{author}}
 * @since {{nowTimeString}}
 */

@RestController
@RequestMapping(ApiCoreConstant.{{capitalClassName}})
public class {{className}}Controller extends BaseController<{{className}}> {
	
	private {{className}}Service service;
	
	@Autowired
	protected void setBaseService({{className}}Service service) {
		this.service = service;
		super.setBaseService(service);
		super.setClass({{className}}.class);
	}
	
    @PutMapping(name = "添加{{className}}信息", value = API_COMMON_ADD)
    public RespMsg<Integer> add(@RequestBody {{className}} model) {
        return super.add(model);
    }
    
    @DeleteMapping(name = "根据ID刪除{{className}}信息", value = API_COMMON_DELETE)
    public RespMsg<Integer> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
    
    @GetMapping(name = "通過唯一ID查詢{{className}}信息", value = API_COMMON_FIND)
    public RespMsg<{{className}}> findById(@PathVariable("id") Long id) {
        return super.findById(id);
    }
    
    @PostMapping(name = "根据对象属性查询{{className}}", value = API_COMMON_QUERY_LIST)
    public RespMsg<{{className}}> get(@RequestBody {{className}} model) {
    	RespMsg<{{className}}> respMsg = new RespMsg<{{className}}>();
    	respMsg.setData(service.get(model));
    	return respMsg;
    }

    @PostMapping(name = "根据对象属性查询{{className}}列表", value = API_COMMON_QUERY_LIST)
    public DgTableData<{{className}}> list(@RequestBody MyQuery<{{className}}> model) {
    	return service.list(model);
    }
    
    @PostMapping(name = "更新{{className}}信息", value = API_COMMON_UPDATE)
    public RespMsg<Integer> update(@RequestBody {{className}} model) {
        return super.update(model);
    }
}

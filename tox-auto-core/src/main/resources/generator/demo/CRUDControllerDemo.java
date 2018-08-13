/**
 * wuliangzhu
 * 2017/10/30
 */
package {{controllerPackage}};

import gu.shoppingmall.utils.security.Permission;

import gu.shoppingmall.interior.service.BaseService;
import {{actionPackage}}.{{className}}Service;
import {{classPackage}}.{{className}};
import gu.shoppingmall.utils.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import gu.shoppingmall.interior.service.BaseService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */

@Controller
public class {{className}}Controller extends BaseCrudController<{{className}}> {
    @Autowired
    private {{className}}Service {{classNameProperty}}Service;

    @Override
    protected BaseService<{{className}}> service() {
        return {{classNameProperty}}Service;
    }

    /**
     * 添加{{className}}賬號信息
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(name = "添加{{className}}信息", value = "/{{className}}/add", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JsonResult add(@RequestBody {{className}} model, HttpServletRequest request, HttpServletResponse response) {
        return super.add(model, request, response);
    }

    @RequestMapping(name = "通過對象屬性查詢所有的{{className}}信息", value = "/{{className}}Read/list", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JsonResult list(@RequestBody {{className}} model, @RequestParam(value = "pageNo") int pageNo,
                           @RequestParam(value = "pageSize") int pageSize, HttpServletRequest request, HttpServletResponse response) {
        return super.list(model, pageNo, pageSize, request, response);
    }

    @RequestMapping(name = "更新{{className}}賬號信息", value = "/{{className}}/update", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JsonResult update(@RequestBody {{className}} model, HttpServletRequest request, HttpServletResponse response) {
        return super.update(model, request, response);
    }

    @RequestMapping(name = "通過對象屬性刪除{{className}}信息", value = "/{{className}}/delete", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JsonResult delete(@RequestBody {{className}} model, HttpServletRequest request, HttpServletResponse response) {
        return super.delete(model, request, response);
    }

    @RequestMapping(name = "通過對象屬性查詢{{className}}信息", value = "/{{className}}Read/get", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JsonResult get(@RequestBody {{className}} model, HttpServletRequest request, HttpServletResponse response) {
        return super.get(model, request, response);
    }

    @RequestMapping(name = "通過唯一ID查詢{{className}}信息", value = "/{{className}}Read/getById", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JsonResult getById(@RequestParam(value = "id")int id, HttpServletRequest request, HttpServletResponse response) {
        return super.getById(id, request, response);
    }
}

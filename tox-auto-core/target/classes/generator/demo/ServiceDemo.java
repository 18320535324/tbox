package {{servicePackage}};

import {{modelPackage}}.{{className}};
import com.jjfinder.jbase.common.service.MyService;
import com.jjfinder.jbase.common.service.MyQuery;
import com.jjfinder.jbase.common.service.DgTableData;

/**
 *
 * @author {{author}}
 * @since {{nowTimeString}}
 */
public interface {{className}}Service extends MyService<{{className}}> {
	
	/**
	 * 根据对象属性查询{{className}}列表
	 * @param model
	 * @return
	 */
	DgTableData<{{className}}> list(MyQuery<{{className}}> model);
	/**
	 * 根据对象属性查询{{className}}
	 * @param model
	 * @return
	 */
	{{className}} get({{className}} model);
}

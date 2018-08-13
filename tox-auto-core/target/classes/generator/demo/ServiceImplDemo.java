package {{serviceImplPackage}};

import org.springframework.beans.factory.annotation.Autowired;

import com.jjfinder.jbase.common.service.MyServiceImpl;
import {{mapperPackage}}.{{className}}Mapper;
import org.springframework.stereotype.Service;
import {{modelPackage}}.{{className}};
import {{servicePackage}}.{{className}}Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jjfinder.jbase.common.service.DgTableData;
import com.jjfinder.jbase.common.service.MyQuery;
import java.util.Optional;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 *
 * @author {{author}}
 * @since {{nowTimeString}}
 */
@Service("{{servceName}}")
public class {{className}}ServiceImpl extends MyServiceImpl<{{className}}> implements {{className}}Service{

    @Autowired
    {{className}}Mapper mapper;

    @Autowired
    protected void setBaseMapper({{className}}Mapper mapper) {
        super.setBaseMapper(mapper);
    }
    
    public DgTableData<{{className}}> list(MyQuery<{{className}}> model) {
    	DgTableData<{{className}}> result = new DgTableData<{{className}}>();
    	Optional.ofNullable(model).ifPresent( e -> {
    		if (model.getPageSize() == 0) {
    			model.setPageSize(10);
    		}
    		Page<Object> page = PageHelper.startPage(model.getPageNumber(), model.getPageSize());
    		RowBounds rowBounds = new RowBounds(page.getStartRow(),  page.getPageSize());
        	List<{{className}}> data = mapper.selectByRowBounds(model.getQueryObj(), rowBounds);
        	int count = mapper.selectCount(model.getQueryObj());
        	result.setData(data);
        	result.setRecordsFiltered(count);
        	result.setRecordsTotal(count);
    	});
    	return result;
    }
    
    public {{className}} get({{className}} model) {
    	return mapper.selectOne(model);
    }
}


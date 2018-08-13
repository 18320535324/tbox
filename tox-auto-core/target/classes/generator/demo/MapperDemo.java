package {{mapperPackage}};

import com.jjfinder.jbase.common.mapper.MyMapper;
import {{modelPackage}}.{{className}};
import org.springframework.stereotype.Repository;

/**
 * 
 * @author {{author}}
 * @date {{nowTimeString}}
 */
@Repository
public interface {{className}}Mapper extends MyMapper<{{className}}> {

}

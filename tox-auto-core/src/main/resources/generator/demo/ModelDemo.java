package {{package}};

import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import javax.validation.groups.Default;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author {{author}}
 * @date {{nowTimeString}}
 */
@Table(name = "{{tableName}}")
public class {{className}} implements Serializable {

    private static final long serialVersionUID = 1L;
{{property}}
}

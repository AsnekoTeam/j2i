package asneko.j2i.generator.data;

import lombok.Data;

/**
 * @author Formyown
 */
@Data
public class Class extends BaseData{
    private String extraHead;
    private String simpleName;
    private Method[] methods;
    private Field[] fields;
}

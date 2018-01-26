package asneko.j2i.generator.data;

import lombok.Data;

/**
 * @author Formyown
 */
@Data
public class Method extends BaseData{
    private String returnTypeName;
    private String name;
    private Parameter[] parameters;
    private String exceptions;
}

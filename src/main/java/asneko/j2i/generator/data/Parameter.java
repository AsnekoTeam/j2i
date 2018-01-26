package asneko.j2i.generator.data;

import lombok.Data;

/**
 * @author Formyown
 */
@Data
public class Parameter {
    private String comment;
    private String[] annotations;
    private String typeName;
    private String name;
}

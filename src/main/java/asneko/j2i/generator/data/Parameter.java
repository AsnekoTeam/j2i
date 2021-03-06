package asneko.j2i.generator.data;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Formyown
 */
@Data
@AllArgsConstructor
public class Parameter {
    private String name;
    private String typeName;
    private String comment;
    private String[] annotations;
}

package asneko.j2i.generator.data;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Formyown
 */
@Data
@AllArgsConstructor
public class Type {
    private String typeName;
    private Type[] properties;
}

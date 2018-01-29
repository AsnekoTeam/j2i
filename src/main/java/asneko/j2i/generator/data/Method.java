package asneko.j2i.generator.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Formyown
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Method extends BaseData{
    private String returnTypeName;
    private String returnValueComment;
    private String name;
    private Parameter[] parameters;
    private Exception[] exceptions;
    private String[] content;
}

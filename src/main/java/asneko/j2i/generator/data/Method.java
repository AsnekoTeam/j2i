package asneko.j2i.generator.data;

import lombok.Data;

/**
 * @author Formyown
 */
@Data
public class Method {
    private String comment;
    private String[] annotations;
    private String[] modifiers;
    private String returnTypeName;
    private String name;
    private Parameter[] parameters;
    private String exceptions;
}

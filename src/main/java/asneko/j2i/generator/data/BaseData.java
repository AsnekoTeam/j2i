package asneko.j2i.generator.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Formyown
 */
@Data
public abstract class BaseData implements Serializable{
    private String comment;
    private String[] annotations;
    private String[] modifiers;
}

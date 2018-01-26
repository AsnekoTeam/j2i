package asneko.j2i.generator;



import asneko.j2i.generator.data.*;
import asneko.j2i.generator.data.Class;

import java.util.List;

/**
 * @author Formyown, AnonyK
 */
public interface Generator {
    String getSupportLanguage();
    String generateParameters(List<Parameter> paras);
    String generateMethod(Method method);
    String generateField(Field field);
    String generateClass(Class clazz);
}

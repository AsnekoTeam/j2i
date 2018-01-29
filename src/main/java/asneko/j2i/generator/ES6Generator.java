package asneko.j2i.generator;

import asneko.j2i.generator.data.Class;
import asneko.j2i.generator.data.Exception;
import asneko.j2i.generator.data.Field;
import asneko.j2i.generator.data.Method;
import asneko.j2i.generator.data.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ES6Generator implements Generator {
    @Override
    public String getSupportLanguage() {
        return "ES6";
    }

    @Override
    public String generateParameters(Parameter[] paras) {
        return  Stream.of(paras)
                .map(Parameter::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String generateMethod(Method method) {
        String paras = generateParameters(method.getParameters());
        String comment = generateMethodComment(method);
        return String.format("%s%s(%s){\r\n%s\r\n}\r\n",
                comment,
                method.getName(),
                paras,
                Stream.of(method.getContent()).map(c->"    " + c).collect(Collectors.joining()));
    }

    @Override
    public String generateField(Field field) {
        return null;
    }

    @Override
    public String generateClass(Class clazz) {
        List<String> methods = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            methods.add(generateMethod(method));
        }
        String[] methodsCode = new String[]{};
        methodsCode = methods.toArray(methodsCode);
        return String.format("%sclass %s {\r\n%s\r\n}\r\n",generateClassComment(clazz),
                clazz.getSimpleName(),Stream.of(methodsCode)
                        .collect(Collectors.joining()));
    }
    private String generateClassComment(Class clazz)
    {
        StringBuilder comment = new StringBuilder();
        comment.append("/**");
        comment.append("\r\n * ").append(clazz.getComment());
        comment.append("\r\n * @public");
        comment.append("\r\n * @class ").append(clazz.getSimpleName());
        if(clazz.getExtraHead() != null)
        //comment.append("\r\n * @classdesc ").append(clazz.getExtraHead());
        comment.append("\r\n */");
        comment.append("\r\n");
        return  comment.toString();
    }
    private String generateMethodComment(Method method){
        StringBuilder comment = new StringBuilder();
        comment.append("/**");
        comment.append("\r\n * ").append(method.getComment());
        for (Parameter p : method.getParameters()){
            comment.append("\r\n * @param ").append(p.getName());
            if(p.getName() != null){
                comment.append(" {");
                comment.append(p.getTypeName());
                comment.append("} ");

            }
            comment.append(p.getComment());
        }
        comment.append("\r\n * @returns");
        if(method.getReturnTypeName() != null){
            comment.append(" {");
            comment.append(method.getReturnTypeName());
            comment.append("} ");
            comment.append(method.getReturnValueComment());
        }

        for (Exception ex : method.getExceptions()){
            comment.append("\r\n * @throws ");
            if(ex.getTypeName() != null){
                comment.append(" {");
                comment.append(ex.getTypeName());
                comment.append("} ");
            }
            comment.append(ex.getComment());
        }

        comment.append("\r\n */");
        comment.append("\r\n");
        return  comment.toString();
    }
}

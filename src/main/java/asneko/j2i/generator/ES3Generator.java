package asneko.j2i.generator;

import asneko.j2i.api.data.Exception;
import asneko.j2i.generator.data.Class;
import asneko.j2i.generator.data.Field;
import asneko.j2i.generator.data.Method;
import asneko.j2i.generator.data.Parameter;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ES3Generator implements Generator {
    @Override
    public String getSupportLanguage() {
        return "ES3";
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




        String.format("%s:function(%s){\r\n%s\r\n}\r\n", method.getName(), paras, method.getContent());
        return null;
    }

    @Override
    public String generateField(Field field) {
        return null;
    }

    @Override
    public String generateClass(Class clazz) {
        return null;
    }

    public String generateMethodComment(Method method){
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

        for (String ex : method.getExceptions()){
            comment.append("\r\n * @throws ").append(p.getName());
            if(p.getName() != null){
                comment.append(" {");
                comment.append(p.getTypeName());
                comment.append("} ");

            }
            comment.append(p.getComment());
        }

        comment.append("\r\n */");
        comment.append("\r\n");
        return  comment.toString();
    }
}

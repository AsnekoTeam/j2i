package asneko.j2i.generator;

import asneko.j2i.generator.data.Class;
import asneko.j2i.generator.data.Field;
import asneko.j2i.generator.data.Method;
import asneko.j2i.generator.data.Parameter;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

public class ES3Generator implements Generator {
    @Override
    public String getSupportLanguage() {
        return "ES3";
    }

    @Override
    public String generateParameters(Parameter[] paras) {
        return paras.stream()
                .map(Parameter::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String generateMethod(Method method) {
        String paras = generateParameters(method.getParameters());
    }

    @Override
    public String generateField(Field field) {
        return null;
    }

    @Override
    public String generateClass(Class clazz) {
        return null;
    }
}

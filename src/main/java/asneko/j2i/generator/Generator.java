package asneko.j2i.generator;

import asneko.j2i.api.InterfaceClass;

public abstract class Generator {
    public abstract String generate(InterfaceClass apiClass);
    public static Generator create(String languageName)throws Exception
    {
        switch (languageName)
        {
            case "js":
                return new JsGenerator();
            default:
                    throw new Exception("Language not support");

        }
    }
}

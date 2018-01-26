package asneko.j2i;

import asneko.j2i.api.data.InterfaceClass;
import asneko.j2i.generator.Generator;
import asneko.j2i.validator.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Application {
    private Generator generator;
    public Application(Generator generator)
    {
        this.generator = generator;
    }

    public String generate(String json) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            InterfaceClass interfaceClass = objectMapper.readValue(json,InterfaceClass.class);
            if(!Validator.validate(interfaceClass))
                throw new Exception("invalid json");
            return generator.generate(interfaceClass);
        }catch (IOException e)
        {
            e.printStackTrace();
            throw new Exception("invalid json");
        }

    }
    public static void main(String[] args)
    {

    }
}

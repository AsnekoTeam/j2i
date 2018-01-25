import asneko.j2i.Application;
import asneko.j2i.generator.Generator;

public class j2iTest {
    public static void main(String[] args) throws Exception
    {
        System.out.print(new Application(Generator.create("js")).generate("{\n" +
                "\t\"className\": \"cls\",\n" +
                "\t\"description\": \"class description\",\n" +
                "\t\"url\": \"http://azzill.com/\",\n" +
                "\t\"functions\": [{\n" +
                "\t\t\"name\": \"myInterface1\",\n" +
                "\t\t\"method\": \"POST\",\n" +
                "\t\t\"description\": \"This is description\",\n" +
                "\t\t\"url\": \"localhost\",\n" +
                "\t\t\"paramHeader\": [{\n" +
                "\t\t\t\"paramName\": \"token\",\n" +
                "\t\t\t\"paramType\": \"string\",\n" +
                "\t\t\t\"paramDescription\": \"the token\"\n" +
                "\t\t}],\n" +
                "\t\t\"paramBody\": [{\n" +
                "\t\t\t\"paramName\": \"param1\",\n" +
                "\t\t\t\"paramType\": \"string\",\n" +
                "\t\t\t\"paramDescription\": \"a param\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"paramName\": \"param2\",\n" +
                "\t\t\t\"paramType\": \"string\",\n" +
                "\t\t\t\"paramDescription\": \"a param\"\n" +
                "\t\t}]\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"myInterface2\",\n" +
                "\t\t\"method\": \"POST\",\n" +
                "\t\t\"description\": \"This is description\",\n" +
                "\t\t\"url\": \"localhost\",\n" +
                "\t\t\"paramHeader\": [{\n" +
                "\t\t\t\"paramName\": \"token\",\n" +
                "\t\t\t\"paramType\": \"string\",\n" +
                "\t\t\t\"paramDescription\": \"the token\"\n" +
                "\t\t}],\n" +
                "\t\t\"paramBody\": [{\n" +
                "\t\t\t\"paramName\": \"param1\",\n" +
                "\t\t\t\"paramType\": \"string\",\n" +
                "\t\t\t\"paramDescription\": \"a param\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"paramName\": \"param2\",\n" +
                "\t\t\t\"paramType\": \"string\",\n" +
                "\t\t\t\"paramDescription\": \"a param\"\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}"));
    }
}

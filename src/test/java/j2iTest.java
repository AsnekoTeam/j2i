import asneko.j2i.Application;
import asneko.j2i.generator.ES6Generator;
import asneko.j2i.generator.Generator;
import asneko.j2i.generator.data.Class;
import asneko.j2i.generator.data.Exception;
import asneko.j2i.generator.data.Method;
import asneko.j2i.generator.data.Parameter;

public class j2iTest {
    /**
     *
     * @param args
     * @throws Exception
     * @throws RuntimeException
     */
    public static void main(String[] args)
    {
        Class clazz = new Class();
        Method testMethod = new Method();
        testMethod.setName("getUserInfo");
        testMethod.setReturnTypeName("UserInfoTransfer");
        testMethod.setReturnValueComment("The specific user info");
        testMethod.setComment("Get the specific user information by uid");
        testMethod.setContent(new String[]{
                "return 0;"
        });
        testMethod.setParameters(new Parameter[]{
                new Parameter("uid", "number", "User id", null)
        });
        testMethod.setExceptions(new Exception[]{
                new Exception("UserNotFoundException","Can not find the specific user")
        });
        clazz.setMethods(new Method[]{testMethod,testMethod});
        clazz.setSimpleName("TestClass");
        clazz.setExtraHead("methods of getting user info");
        clazz.setComment("class of user info");
        clazz.setExtraHead("import foo from bar;\r\n");
        Generator generator = new ES6Generator();
        System.err.print(generator.generateClass(clazz));

//        System.out.print(new Application(Generator.create("js")).generate("{\n" +
//                "\t\"className\": \"cls\",\n" +
//                "\t\"description\": \"class description\",\n" +
//                "\t\"url\": \"http://azzill.com/\",\n" +
//                "\t\"functions\": [{\n" +
//                "\t\t\"name\": \"myInterface1\",\n" +
//                "\t\t\"method\": \"POST\",\n" +
//                "\t\t\"description\": \"This is description\",\n" +
//                "\t\t\"url\": \"localhost\",\n" +
//                "\t\t\"paramHeader\": [{\n" +
//                "\t\t\t\"paramName\": \"token\",\n" +
//                "\t\t\t\"paramType\": \"string\",\n" +
//                "\t\t\t\"paramDescription\": \"the token\"\n" +
//                "\t\t}],\n" +
//                "\t\t\"paramBody\": [{\n" +
//                "\t\t\t\"paramName\": \"param1\",\n" +
//                "\t\t\t\"paramType\": \"string\",\n" +
//                "\t\t\t\"paramDescription\": \"a param\"\n" +
//                "\t\t}, {\n" +
//                "\t\t\t\"paramName\": \"param2\",\n" +
//                "\t\t\t\"paramType\": \"string\",\n" +
//                "\t\t\t\"paramDescription\": \"a param\"\n" +
//                "\t\t}]\n" +
//                "\t}, {\n" +
//                "\t\t\"name\": \"myInterface2\",\n" +
//                "\t\t\"method\": \"POST\",\n" +
//                "\t\t\"description\": \"This is description\",\n" +
//                "\t\t\"url\": \"localhost\",\n" +
//                "\t\t\"paramHeader\": [{\n" +
//                "\t\t\t\"paramName\": \"token\",\n" +
//                "\t\t\t\"paramType\": \"string\",\n" +
//                "\t\t\t\"paramDescription\": \"the token\"\n" +
//                "\t\t}],\n" +
//                "\t\t\"paramBody\": [{\n" +
//                "\t\t\t\"paramName\": \"param1\",\n" +
//                "\t\t\t\"paramType\": \"string\",\n" +
//                "\t\t\t\"paramDescription\": \"a param\"\n" +
//                "\t\t}, {\n" +
//                "\t\t\t\"paramName\": \"param2\",\n" +
//                "\t\t\t\"paramType\": \"string\",\n" +
//                "\t\t\t\"paramDescription\": \"a param\"\n" +
//                "\t\t}]\n" +
//                "\t}]\n" +
//                "}"));
    }
}

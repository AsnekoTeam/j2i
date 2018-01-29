import asneko.j2i.Application;
import asneko.j2i.generator.ES3Generator;
import asneko.j2i.generator.Generator;
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

        Generator generator = new ES3Generator();
        System.err.print(generator.generateMethod(testMethod));

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

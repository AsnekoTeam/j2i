package asneko.j2i.generator;

import asneko.j2i.api.Function;
import asneko.j2i.api.InterfaceClass;
import asneko.j2i.api.Parameter;

import java.util.List;

public class JsGenerator extends Generator{
    private boolean adapterGenerated = false;
    private String generateFunction(Function api)
    {
        StringBuilder sbComment = new StringBuilder();
        StringBuilder sbBody = new StringBuilder();
        StringBuilder sbParam = new StringBuilder();
        List<Parameter> paramsBody =  api.getParamBody();
        List<Parameter> paramsHeader =  api.getParamHeader();
        sbComment.append("/**\r\n");
        sbComment.append(String.format(" * %s\r\n",api.getDescription()));
        for (int i=0;i<paramsHeader.size();i++){
            if(i > 0)
                sbParam.append(", ");
            sbParam.append(paramsHeader.get(i).getParamName());
            sbComment.append(String.format(" * @param {%s} %s - %s\r\n",paramsHeader.get(i).getParamType(),
                    paramsHeader.get(i).getParamName(),paramsHeader.get(i).getParamDescription()));
        }
        if(paramsHeader.size() > 0)
            sbParam.append(", ");
        for (int i=0;i<paramsBody.size();i++){
            if(i > 0)
                sbParam.append(", ");
            sbParam.append(paramsBody.get(i).getParamName());
            sbComment.append(String.format(" * @param {%s} %s - %s \r\n",paramsBody.get(i).getParamType(),
                    paramsBody.get(i).getParamName(),paramsBody.get(i).getParamDescription()));
        }
        sbComment.append(" * @param {function(number,any)} callback - api callback\r\n");
        sbComment.append(" * @param {Object} errCallback - on Exception\r\n");
        sbComment.append("*/\r\n");
        if(paramsHeader.size() > 0 || paramsBody.size() > 0)
            sbParam.append(", ");
        sbParam.append("callback,errCallback");
        sbBody.append("    let header = new Array();\r\n");
        for(Parameter param:paramsHeader) {
            sbBody.append(String.format("    header.append({header:\"%s\",value:%s});\r\n",param.getParamName(),param.getParamName()));
        }
        sbBody.append("    let body = JSON.stringify({ \r\n");
        for (int i=0;i<paramsBody.size();i++){
            if(i > 0)
                sbBody.append(", \r\n");
            sbBody.append(String.format("    %s: %s",paramsBody.get(i).getParamName(),
                    paramsBody.get(i).getParamName()));
        }
        sbBody.append("});\r\n");
        sbBody.append(String.format("    handleRequest(\"%s\",\"%s\",header,body,function(code,result){\n" +
                "        if(!handleException(code,result,errCallback))\n" +
                "            callback(code,result);\n" +
                "    });",api.getUrl(),api.getMethod()));
        return String.format("%s%s:function(%s){\r\n%s\r\n}\r\n",sbComment.toString(),api.getName(),sbParam.toString(),sbBody.toString());
    }
    private String generateAdapter()
    {
        return "/**\n" +
                " * handleRequest \n" +
                " * TODO: complete this adapter for http request.\n" +
                " * @param {string} method - method of request\n" +
                " * @param {string} url - url\n" +
                " * @param {Array<{header:String,value:String}>} header - custom header\n" +
                " * @param {String} body - body of request\n" +
                " * @param {function(number,object)} callback - api回调\n" +
                "*/" +
                "function handleRequest(method,url,header,body,callback){\r\n\r\n}\r\n" +
                "/**\n" +
                " * handleException \n" +
                " * TODO: complete this adapter for exception.\n" +
                " * @param {string} code - code\n" +
                " * @param {Object} result - result\n" +
                " * @param {Object} errCallback - callbacks for exceptions\n" +
                " * @returns {boolean} - is exception or not\n" +
                "*/function handleException(code,result,errCallback){\n" +
                " \n" +
                "}\n";
    }
    public String generate(InterfaceClass apiClass)
    {
        StringBuilder sb = new StringBuilder();
        if(!adapterGenerated){
            adapterGenerated = true;
            sb.append(generateAdapter());
        }
        boolean first = true;
        sb.append(String.format("let %s = {\n",apiClass.getClassName()));
        for (Function function:apiClass.getFunctions()
             ) {
            if(first)
            {
                first = false;
            }else
            {
                sb.append(",\n");
            }
            sb.append(generateFunction(function));
        }
        sb.append("};\n");
        return sb.toString();
    }
}

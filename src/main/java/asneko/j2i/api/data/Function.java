package asneko.j2i.api.data;

import lombok.Data;

import java.util.List;
@Data
public class Function {
    String name;
    String method;
    String description;
    String url;
    List<Parameter> paramHeader;
    List<Parameter> paramBody;
    List<Exception> exceptions;
}
//{"name":"myInterface",method:"POST",description:"This is description","url","http://localhost",
// "paramHeader":[{"paramName":"token","paramType":"string","paramDescription":"the token"}]
// ,"paramBody":[{"paramName":"param1","paramType":"string","paramDescription":"a param"},{"paramName":"param2","paramType":"string","paramDescription":"a param"}]
// }
package asneko.j2i.api;

import lombok.Data;

import java.util.List;
@Data
public class InterfaceClass {
    String url;
    String className;
    String description;
    List<Function> functions;
}

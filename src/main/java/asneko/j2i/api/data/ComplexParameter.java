package asneko.j2i.api.data;

import lombok.Data;

import java.util.List;

@Data
public class ComplexParameter extends Parameter {
    List<Parameter> parameters;
}

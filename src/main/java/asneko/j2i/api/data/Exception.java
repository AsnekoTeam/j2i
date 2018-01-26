package asneko.j2i.api.data;

import lombok.Data;

@Data
public class Exception {
    private String name;
    private long code;
    private String description;
}

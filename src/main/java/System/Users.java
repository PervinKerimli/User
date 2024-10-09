package System;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Users {
    private Long id;
    private String userId;
    private String name;
    private String surname;
    private String email;
    private List<Cards> cards;
}

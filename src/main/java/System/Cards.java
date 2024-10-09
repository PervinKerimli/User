package System;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cards {
    private int id;
    private String cardNumber;
    private double balance;
    private String userId;
    private boolean isActive;
}

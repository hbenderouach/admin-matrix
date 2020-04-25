package com.humanup.adminmatrix.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccountVO {
     String accountMailAdresse;
     String accountFirstName;
     String accountLastName;
     String accountRole;
}

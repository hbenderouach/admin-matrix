package com.humanup.adminmatrix.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class RoleVO {
     String roleTitle;
     String roleDescription;
     int countAccount;
}

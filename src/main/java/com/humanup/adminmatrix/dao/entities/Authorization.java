package com.humanup.adminmatrix.dao.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Authorization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     Long authorizationId;
     String authorizationTitle;
     String authorizationDescription;
     String authorizationUrl;
    @ManyToOne
    @JoinColumn(name = "roleId")
     Role role;


}

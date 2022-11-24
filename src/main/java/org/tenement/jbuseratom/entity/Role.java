package org.tenement.jbuseratom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @OneToMany(mappedBy="userRole")
    private Collection<User> users = new HashSet<>();

    @OneToMany(mappedBy = "role")
    private Collection<Privilege> privileges;
}

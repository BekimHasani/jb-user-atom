package org.tenement.jbuseratom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.tenement.jbuseratom.enumeration.UserState;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`User`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserState userState;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role userRole;

    @Column(nullable = false)
    private boolean tokenExpired;

    @Column(nullable = false, columnDefinition = "false")
    private boolean emailConfirmation;
}

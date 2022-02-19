package com.yeahbutstill.datatransferobjectpattern.domain.dao;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    private String username;

    @NotNull @NotEmpty
    private String firstname;

    @NotNull @NotEmpty
    private String lastname;

    @NotNull @NotEmpty
    private String password;

    @NotNull @NotEmpty @Email
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id")
    private LocationDao locationDao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserDao userDao = (UserDao) o;
        return id != null && Objects.equals(id, userDao.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

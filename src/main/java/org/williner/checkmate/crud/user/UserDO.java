package org.williner.checkmate.crud.user;

import lombok.Getter;
import lombok.Setter;
import org.williner.checkmate.data.BaseDO;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "T_USERS")
public class UserDO extends BaseDO {
    @Getter @Setter @Column(name = "FIRST_NAME")
    private String firstName;

    @Getter @Setter @Column(name = "LAST_NAME")
    private String lastName;

    @Getter @Setter @Column(name = "NICKNAME")
    private String nickname;

    @Getter @Setter @Column(name = "PASSWORD")
    private String password;
}

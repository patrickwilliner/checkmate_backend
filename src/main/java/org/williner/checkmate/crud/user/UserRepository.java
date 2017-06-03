package org.williner.checkmate.crud.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDO, Long> {
    UserDO findByNickname(String nickname);
}

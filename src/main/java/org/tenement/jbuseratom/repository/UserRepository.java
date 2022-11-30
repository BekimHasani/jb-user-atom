package org.tenement.jbuseratom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tenement.jbuseratom.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

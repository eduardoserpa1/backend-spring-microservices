package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("select u from UserModel u where u.username like ?1 and u.password like ?2")
    UserModel login(String username, String password);
}

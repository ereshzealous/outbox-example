package com.eresh.outbox.user.dao.repository;

import com.eresh.outbox.user.dao.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
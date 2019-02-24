package com.group6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group6.model.User; 
 
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT DISTINCT user FROM User user WHERE user.userName =:userName")
    User findUserByName(@Param("userName") String userName);
}

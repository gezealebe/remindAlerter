package com.group6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group6.model.Contact; 
 
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query("SELECT DISTINCT contact FROM Contact contact WHERE contact.firstName =:firstName and contact.reminderTypes =:reminderTypes and contact.userId =:username")
    Contact findContactByName(@Param("firstName") String firstName, @Param("reminderTypes") String reminderTypes, @Param("username") String username);
    
    @Query("SELECT DISTINCT contact FROM Contact contact WHERE contact.userId =:username")
    List <Contact> getListOfContacts(@Param("username") String username);
    
     
}


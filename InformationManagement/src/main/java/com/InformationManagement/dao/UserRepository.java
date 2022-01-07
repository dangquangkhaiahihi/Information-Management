package com.InformationManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InformationManagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

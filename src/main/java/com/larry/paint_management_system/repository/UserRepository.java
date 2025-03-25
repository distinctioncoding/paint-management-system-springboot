package com.larry.paint_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larry.paint_management_system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
     Optional<User> findByUsername(String username);
}
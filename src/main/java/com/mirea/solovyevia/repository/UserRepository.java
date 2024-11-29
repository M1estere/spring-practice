package com.mirea.solovyevia.repository;

import com.mirea.solovyevia.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String email);
}
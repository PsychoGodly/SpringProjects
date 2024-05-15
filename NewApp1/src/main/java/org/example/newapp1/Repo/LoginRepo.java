package org.example.newapp1.Repo;

import org.example.newapp1.Entity.Login_user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login_user , Long> {

    public Login_user findByUsername(String username);
}

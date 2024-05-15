package org.example.crud_user.Repo;

import org.example.crud_user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {


}

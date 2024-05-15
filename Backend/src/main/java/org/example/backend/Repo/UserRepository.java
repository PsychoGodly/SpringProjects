package org.example.backend.Repo;

import org.example.backend.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Contact, Integer> {
}

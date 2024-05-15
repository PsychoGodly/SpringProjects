package org.example.onetomany.Repository;

import org.example.onetomany.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}

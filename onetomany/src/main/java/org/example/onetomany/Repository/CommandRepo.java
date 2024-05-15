package org.example.onetomany.Repository;

import org.example.onetomany.Entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepo extends JpaRepository<Command, Integer> {
}

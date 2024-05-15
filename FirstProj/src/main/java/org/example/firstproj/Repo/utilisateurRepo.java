package org.example.firstproj.Repo;

import org.example.firstproj.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface utilisateurRepo extends JpaRepository<Utilisateur, Long> {

    public Utilisateur findByNameContains(String username);
}

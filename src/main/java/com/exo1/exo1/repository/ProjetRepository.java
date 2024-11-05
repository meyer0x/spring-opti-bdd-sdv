package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("SELECT p FROM Projet p " +
           "LEFT JOIN FETCH p.tasks " +
           "LEFT JOIN FETCH p.users " +
           "WHERE p.id = :id")
    Optional<Projet> findByIdWithTasksAndUsers(@Param("id") Long id);

    @Query(value = "SELECT DISTINCT p FROM Projet p " +
                   "LEFT JOIN FETCH p.tasks " +
                   "LEFT JOIN FETCH p.users",
           countQuery = "SELECT COUNT(DISTINCT p) FROM Projet p")
    Page<Projet> findAllWithTasksAndUsers(Pageable pageable);
}

package com.alexeydev.lojajogos.repositories;

import com.alexeydev.lojajogos.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}

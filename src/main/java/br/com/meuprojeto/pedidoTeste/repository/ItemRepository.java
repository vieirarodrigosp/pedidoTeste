package br.com.meuprojeto.pedidoTeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meuprojeto.pedidoTeste.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {}

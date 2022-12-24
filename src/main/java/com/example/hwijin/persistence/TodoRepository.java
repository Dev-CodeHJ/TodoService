package com.example.hwijin.persistence;


import com.example.hwijin.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {


    @Query("select t from TodoEntity t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);

    @Query("select t from TodoEntity t where t.title = ?1")
    Optional<TodoEntity> findByTitle(String title);



}

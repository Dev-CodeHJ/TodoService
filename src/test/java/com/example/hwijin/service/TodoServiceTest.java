package com.example.hwijin.service;

import com.example.hwijin.dto.TodoDTO;
import com.example.hwijin.model.TodoEntity;
import com.example.hwijin.persistence.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoRepository repository;

    @BeforeEach
    void setUp() {
        System.out.println("-- BeforeEach 어노테이션 호출 --");
        System.out.println("");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testService() {
    }

    @Test
    @DisplayName("Create 테스트")
    void create() {
        System.out.println("-- Create 테스트 시작 --");
        System.out.println("");

        TodoEntity entity = new TodoEntity("system-uuid","gnlwls0127","New Post1",false);

        assertEquals("system-uui", entity.getId());
    }

    @Test
    @DisplayName("Read 테스트")
    void retrieve() {
        System.out.println("-- Read 테스트 시작 --");
        System.out.println("");

        TodoEntity entity = new TodoEntity("system-uuid","gnlwls0127","New Post1",false);

    }

    @Test
    void update() {
        TodoEntity entity = new TodoEntity();
        TodoEntity result = repository.save(entity);
        System.out.println(result);

        Optional<TodoEntity> foundEntity = repository.findById("asflj12o3fjkl2jfl1k2fjsdaflskd");

        if (foundEntity.isPresent()) {
            TodoEntity en = foundEntity.get();
            System.out.println("has Value");
        } else {
            throw new RuntimeException("Entity cannot be null.");
        }
    }

    @Test
    void delete() {

    }
}
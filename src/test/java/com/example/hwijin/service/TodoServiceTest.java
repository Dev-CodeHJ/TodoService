package com.example.hwijin.service;

import com.example.hwijin.dto.TodoDTO;
import com.example.hwijin.model.TodoEntity;
import com.example.hwijin.persistence.TodoRepository;
import org.hibernate.cfg.CreateKeySecondPass;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoService service;

    @BeforeEach
    void setUp() {
        System.out.println("-- BeforeEach 어노테이션 호출 --");
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

        //given
        TodoEntity entity1 = TodoEntity.builder()
                .userId("Test UserId1")
                .title("New Title1")
                .done(true)
                .build();

        TodoEntity entity2 = TodoEntity.builder()
                .userId("Test UserId2")
                .title("New Title2")
                .done(true)
                .build();

        //when
        TodoEntity createdEntity1 = service.create(entity1);
        TodoEntity createdEntity2 = service.create(entity2);

        //then
        assertEquals(createdEntity1.getTitle(), entity1.getTitle());
        assertEquals(createdEntity2.getTitle(), entity2.getTitle());
    }

    @Test
    @DisplayName("Read 테스트")
    void read() {
        System.out.println("-- Read 테스트 시작 --");

        //given
        TodoEntity entity1 = TodoEntity.builder()
                .userId("Test UserId")
                .title("New Title1")
                .done(true)
                .build();
        repository.save(entity1);

        TodoEntity entity2 = TodoEntity.builder()
                .userId("Test UserId")
                .title("New Title2")
                .done(false)
                .build();
        repository.save(entity2);


        //when
        List<TodoEntity> entityList = service.read("Test UserId");

        //then
        assertEquals(2,entityList.size());
    }

    @Test
    void update() throws Exception {
        System.out.println("-- Update 테스트 시작 --");

        //given
        TodoEntity entity = TodoEntity.builder()
                .userId("Test UserId")
                .title("New Title")
                .done(true)
                .build();
        repository.save(entity);

        //when
        String updatedEntity = service.update(entity);

        //then
        System.out.println(updatedEntity);
    }

    @Test
    void delete() {
        System.out.println("-- Delete 테스트 시작 --");

        //given
        TodoEntity entity = TodoEntity.builder()
                .userId("Test UserId")
                .title("New Title")
                .done(true)
                .build();
        repository.save(entity);

        //when
        String deletedEntity = service.delete(entity);

        //then
        System.out.println(entity);
        System.out.println(deletedEntity);
    }
    @Test
    void test() {
        System.out.println("Test");

        TodoEntity entity1 = TodoEntity.builder()
                .userId("Test-UserId1")
                .title("New Title1")
                .done(true)
                .build();

        TodoEntity createdEntity = service.create(entity1);

        String getId = createdEntity.getId();
        service.delete2(getId);


        assertNull(createdEntity);
    }

}
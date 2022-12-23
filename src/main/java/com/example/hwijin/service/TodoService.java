package com.example.hwijin.service;


import com.example.hwijin.model.TodoEntity;
import com.example.hwijin.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService() {

        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();

        repository.save(entity);

        TodoEntity savedEntity = repository.findById(entity.getId()).get();

        return savedEntity.getTitle();
    }

    public TodoEntity create(final TodoEntity entity) {
        validate(entity);

        TodoEntity result = repository.save(entity);
        log.info("Entity Id = {}", entity.getId());

//        return repository.findByUserId(entity.getUserId());
        return result;
    }

    public List<TodoEntity> retrieve(String userId) {
//        log.info("USER_ID : {} .", userId);
//        List<TodoEntity> result = repository.findByUserId(userId);
//        log.info("Entity_COUNT = {}",result.size());
//        for (TodoEntity entity : result) {
//            log.info(entity.getId());
//        }

        return repository.findByUserId(userId);
    }

    public List<TodoEntity> update(final TodoEntity entity) throws Exception {

        validate(entity);

        Optional<TodoEntity> findEntity = repository.findById(entity.getId());
        if (findEntity.isPresent()) {
            TodoEntity result = repository.save(entity);
            return repository.findByUserId(result.getUserId());
        }else {
            throw new RuntimeException("Entity cannot be null.");
        }
    }

    public List<TodoEntity> delete(final TodoEntity entity) {

        Optional<TodoEntity> findEntity = repository.findById(entity.getId());

        if (findEntity.isPresent()) {
            TodoEntity result = findEntity.get();
            repository.delete(result);
            return repository.findByUserId(result.getUserId());
        } else {
            throw new RuntimeException("Entity cannot be null.");
        }
    }


    private void validate(final TodoEntity entity){

        if (entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }


        if (entity.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

}

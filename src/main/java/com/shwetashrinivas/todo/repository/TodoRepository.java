package com.shwetashrinivas.todo.repository;

import com.shwetashrinivas.todo.model.TodoPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoPO, Integer> {
}

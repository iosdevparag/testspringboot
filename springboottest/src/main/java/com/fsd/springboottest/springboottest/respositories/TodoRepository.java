package com.fsd.springboottest.springboottest.respositories;

import com.fsd.springboottest.springboottest.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDo, Long> {

}

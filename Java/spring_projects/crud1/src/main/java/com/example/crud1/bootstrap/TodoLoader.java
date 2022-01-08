package com.example.crud1.bootstrap;

import com.example.crud1.model.Todo;
import com.example.crud1.model.TodoStatus;
import com.example.crud1.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoLoader implements CommandLineRunner{
    public final TodoRepository todoRepository;

    public TodoLoader(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        loadTodos();
    }

    private void loadTodos(){
        if(todoRepository.count()==0){
            todoRepository.save(
                    Todo.builder()
                            .title("Go to the market")
                            .description("Buy eggs from shop")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            todoRepository.save(
                    Todo.builder()
                            .title("Go to school")
                            .description("Do Assignments")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}

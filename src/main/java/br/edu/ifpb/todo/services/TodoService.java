package br.edu.ifpb.todo.services;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void salvar(Todo todo){
        todoRepository.save(todo);
    }

    public List<Todo> listar() {
        return todoRepository.findAll();
    }

    public long total() {
        return todoRepository.count();
    }

    public void apagar(Todo todo) {
        todoRepository.delete(todo);
    }
}

package br.edu.ifpb.todo.services;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo salvar(Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    public Optional<Todo> buscarPorId(Integer id){
        return todoRepository.findById(id);
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

package br.edu.ifpb.todo.web;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoResource {
    private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listarTodos(){
        return ResponseEntity.ok().body(todoService.listar());
    }
}

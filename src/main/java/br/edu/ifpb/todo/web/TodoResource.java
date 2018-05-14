package br.edu.ifpb.todo.web;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoResource {
    private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> salvar(Todo todo){
        return ResponseEntity.ok().body(todoService.salvar(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listarTodos(){
        return ResponseEntity.ok().body(todoService.listar());
    }

    @DeleteMapping
    public ResponseEntity<Todo> apagarTodo(@RequestParam("id") Integer id){
        Optional<Todo> todo = todoService.buscarPorId(id);
        if(todo.isPresent()){
            todoService.apagar(todo.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

//    @DeleteMapping("/:id")
//    public ResponseEntity<Todo> apagarTodo(@PathParam("id") Integer id){
//        Optional<Todo> todo = todoService.buscarPorId(id);
//        if(todo.isPresent()){
//            todoService.apagar(todo.get());
//            return ResponseEntity.ok().build();
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//
//    }
}

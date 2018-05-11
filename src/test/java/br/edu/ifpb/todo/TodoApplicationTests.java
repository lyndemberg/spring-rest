package br.edu.ifpb.todo;

import br.edu.ifpb.todo.domain.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.edu.ifpb.todo.services.TodoService;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {

	@Autowired
	private TodoService todoService;

	@Test
	public void deveCriarTodo(){
		Todo todo = new Todo();
		todo.setTitulo("Fazer aplicação Spring");
		todoService.salvar(todo);
		assertTrue(todo.getId() != null);
	}

	@Test
	public void deveListarTodo(){
	    Todo todo = new Todo();
	    todo.setTitulo("Mais uma todo");
	    todoService.salvar(todo);
        List<Todo> lista = todoService.listar();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void deveApagarTodo(){
	    Todo todo = new Todo();
	    todo.setTitulo("Nota a ser apagada");
	    todoService.salvar(todo);
        long todosExistentes = todoService.total();
        todoService.apagar(todo);
        long todosExistentesAposRemocao = todoService.total();
        assertTrue(todosExistentesAposRemocao == todosExistentes-1);
    }
}

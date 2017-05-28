package net.poundex.fling.demo.todo.todo1

import net.poundex.fling.demo.todo.TodoItemFormModel
import net.poundex.fling.demo.todo.TodoModel
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class EditTodoItemModel extends TodoItemFormModel
{
	TodoModel todoItem
}

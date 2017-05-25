package net.poundex.fling.demo.todo.todoem

import fling.ui.View
import net.poundex.fling.demo.todo.TodoModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoListView extends View<TodoListModel, TodoListController>
{
	@Autowired
	TodoListView(TodoListModel model, TodoListController controller)
	{
		super(model, controller)
	}

	Closure viewBuilder = {
		listView(items: model.todoItems) {
			listItem(onItemActivated: controller.&todoItemActivated) { TodoModel item ->
				label(text: item.itemText)
			}
		}
	}
}

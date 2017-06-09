package net.poundex.fling.demo.todo.todo

import fling.ui.View
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class TodoItemViewStarterView extends View<TodoItemViewStarterModel, TodoItemViewStarterController>
{
	@Autowired
	TodoItemViewStarterView(TodoItemViewStarterModel model, TodoItemViewStarterController controller)
	{
		super(model, controller)
	}

	Closure viewBuilder = {
		vbox {
			label(text: 'Todo Task', styleClass: ['control-label'])
			hbox {
				textField(text: bind(model.idProperty()))
				button(text: '=>', onAction: controller.&onButtonClicked)
			}
		}
	}
}

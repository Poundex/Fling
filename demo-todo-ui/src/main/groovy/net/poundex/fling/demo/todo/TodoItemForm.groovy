package net.poundex.fling.demo.todo

import fling.ui.Model

/**
 * Created by poundex on 25/05/17.
 */
trait TodoItemForm
{
	abstract Model getModel()

	Closure todoItemForm = { Map args ->
		boolean editable = args?.editable ?: false
		vbox {
			label(text: 'Todo Task', styleClass: ['control-label'])
			textField(text: bind(model.todoItem.itemTextProperty()), editable: editable)
		}
	}
}
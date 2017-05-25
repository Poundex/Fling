package net.poundex.fling.demo.todo

import fling.ui.Model

/**
 * Created by poundex on 25/05/17.
 */
trait TodoItemForm
{
	abstract Model getModel()

	Closure todoItemForm = {
		vbox {
			label(text: 'Todo Task', styleClass: ['control-label'])
			label(text: bind(model.todoItem.itemTextProperty()))
		}
	}
}
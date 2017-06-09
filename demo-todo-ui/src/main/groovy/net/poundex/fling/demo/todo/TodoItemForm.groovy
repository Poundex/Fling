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
			if(model.todoItem.id)
			{
				label(text: 'id' ,styleClass: ['control-label'])
				textField(text: model.todoItem.id, editable: false)
			}
			label(text: 'Todo Task', styleClass: ['control-label'])
			textField(text: bind(model.todoItem.itemTextProperty()), editable: editable)

			label(text: 'Category', styleClass: ['control-label'])
//			textField(text: bind(model.todoItem.category.nameProperty()), editable: editable)

//			valueObjectChooser(theValue: bind(model.todoItem.categoryProperty()),
//				items: model.categories)

			choiceBox(value: bind(model.todoItem.categoryProperty()),
				items: model.categories, disable: ! editable)

			label(text: 'Complete', styleClass: ['control-label'])
			checkBox(selected: bind(model.todoItem.completeProperty()), disable: ! editable)
		}
	}
}
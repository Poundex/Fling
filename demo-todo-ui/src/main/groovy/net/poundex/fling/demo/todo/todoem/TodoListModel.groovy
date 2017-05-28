package net.poundex.fling.demo.todo.todoem

import fling.ui.Model
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import net.poundex.fling.demo.todo.TodoModel
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoListModel extends Model
{
	ObservableList<TodoModel> todoItems = FXCollections.observableList([])
}

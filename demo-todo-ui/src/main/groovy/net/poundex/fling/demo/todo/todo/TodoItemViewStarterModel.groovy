package net.poundex.fling.demo.todo.todo

import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.demo.todo.TodoModel
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoItemViewStarterModel extends Model
{
	@FXBindable String id = ""
}

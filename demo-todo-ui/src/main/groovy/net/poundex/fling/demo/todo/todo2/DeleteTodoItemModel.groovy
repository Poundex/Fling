package net.poundex.fling.demo.todo.todo2

import fling.ui.Model
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("component")
class DeleteTodoItemModel extends Model
{
	fling.ui.Component summary
}

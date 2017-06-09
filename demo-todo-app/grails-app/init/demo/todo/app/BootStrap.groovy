package demo.todo.app

import net.poundex.fling.demo.Category
import net.poundex.fling.demo.TodoItem

class BootStrap {

    def init = { servletContext ->
        Category misc = save new Category(name: "Misc")
        Category other = save new Category(name: "Other")

        save new TodoItem(itemText: 'Do this thing', category: misc)
        save new TodoItem(itemText: 'And this thing, as well', category: misc)
        save new TodoItem(itemText: 'Also this', category: other)
    }
    def destroy = {
    }

    static <T> T save(T obj, boolean flush = false) {
        obj.save(failOnError: true, flush: flush)
    }
}

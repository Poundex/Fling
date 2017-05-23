package demo.todo.app

import net.poundex.fling.demo.TodoItem

class BootStrap {

    def init = { servletContext ->
        save new TodoItem(itemText: 'Do this thing')
        save new TodoItem(itemText: 'And this this, as well')
    }
    def destroy = {
    }

    static <T> T save(T obj, boolean flush = false) {
        obj.save(failOnError: true, flush: flush)
    }
}

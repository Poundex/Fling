package net.poundex.fling.demo.todo

import groovyx.javafx.beans.FXBindable

/**
 * Created by poundex on 22/05/17.
 */
class TodoModel
{
	long id
	@FXBindable String itemText
}

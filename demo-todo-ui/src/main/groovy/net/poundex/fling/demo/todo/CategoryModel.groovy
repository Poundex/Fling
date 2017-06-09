package net.poundex.fling.demo.todo

import groovyx.javafx.beans.FXBindable

/**
 * Created by poundex on 06/06/17.
 */
class CategoryModel
{
	Long id
	@FXBindable String name

	@Override
	String toString() { name }
}

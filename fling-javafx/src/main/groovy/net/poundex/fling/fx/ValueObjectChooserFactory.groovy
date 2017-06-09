package net.poundex.fling.fx

import groovyx.javafx.beans.FXBindable
import javafx.beans.value.ChangeListener
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBoxBase

/**
 * Created by poundex on 06/06/17.
 */
class ValueObjectChooserFactory extends ChoiceBox
{
	@FXBindable Object theValue
	Closure<List<?>> values
	private synchronized boolean valuesFetched = false

	ValueObjectChooserFactory()
	{
		super()

		selectionModel.selectedItemProperty().addListener({ v, ov, nv ->
			theValue = nv
		} as ChangeListener)


		addEventHandler(ComboBoxBase.ON_SHOWING, { Event e ->
			if( ! valuesFetched)
				valuesFetched = items.addAll values
		})

		theValueProperty().addListener({v, o, n ->
			selectionModel.select(n)
		} as ChangeListener)
	}
}

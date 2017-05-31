package net.poundex.fling.fx

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType
import javafx.scene.control.Button

/**
 * Created by poundex on 30/05/17.
 */
enum ActionType
{
	NORMAL({ b -> b.styleClass << 'button-raised' }),
	PRIMARY({ b -> NORMAL.doToButton(b); b.defaultButton = true }),
	DANGER({ b -> NORMAL.doToButton(b); b.styleClass << 'danger' }),

	AUX({ b -> b.styleClass << 'button-flat' })

	private final Closure doToButton

	ActionType(@ClosureParams(value = SimpleType, options = 'javafx.scene.control.Button') Closure doToButton)
	{
		this.doToButton = doToButton
	}

	Button styleButton(Button button)
	{
		doToButton(button)
		return button
	}
}
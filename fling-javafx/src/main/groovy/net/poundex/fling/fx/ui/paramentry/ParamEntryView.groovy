package net.poundex.fling.fx.ui.paramentry

import fling.ui.View
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("group")
class ParamEntryView extends View<ParamEntryModel, ParamEntryController>
{
	@Autowired
	ParamEntryView(ParamEntryModel model, ParamEntryController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		vbox {
			model.params.each { name, props ->
				label(text: name, styleClass: ['control-label'])
				textField(text: bind(model.paramValues[name]))
			}
		}
	}
}

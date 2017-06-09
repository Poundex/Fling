package net.poundex.fling.fx.ui.paramentry

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("component")
class ParamEntryComponent extends fling.ui.Component<ParamEntryController, ParamEntryView, ParamEntryModel>
{
	@Autowired
	ParamEntryComponent(ParamEntryController controller, ParamEntryView view, ParamEntryModel model)
	{
		super(controller, view, model)
	}
}

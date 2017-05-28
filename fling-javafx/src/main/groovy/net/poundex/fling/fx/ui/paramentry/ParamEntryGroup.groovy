package net.poundex.fling.fx.ui.paramentry

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("group")
class ParamEntryGroup extends Group<ParamEntryController, ParamEntryView, ParamEntryModel>
{
	@Autowired
	ParamEntryGroup(ParamEntryController controller, ParamEntryView view, ParamEntryModel model)
	{
		super(controller, view, model)
	}
}

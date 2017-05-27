package net.poundex.fling.fx.ui.information

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 26/05/17.
 */
@Component @Scope("group")
class InformationGroup extends Group<InformationController, InformationView, InformationModel>
{
	@Autowired
	InformationGroup(InformationController controller, InformationView view, InformationModel model)
	{
		super(controller, view, model)
	}
}

package net.poundex.fling.fx.ui.information

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 26/05/17.
 */
@Component @Scope("component")
class InformationComponent extends fling.ui.Component<InformationController, InformationView, InformationModel>
{
	@Autowired
	InformationComponent(InformationController controller, InformationView view, InformationModel model)
	{
		super(controller, view, model)
	}
}

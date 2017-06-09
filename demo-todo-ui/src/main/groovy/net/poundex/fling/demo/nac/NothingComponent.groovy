package net.poundex.fling.demo.nac

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
//@InheritConstructors
@Component @Scope("component")
class NothingComponent extends fling.ui.Component<NothingController, NothingView, NothingModel>
{
	@Autowired
	NothingComponent(NothingController controller, NothingView view, NothingModel model)
	{
		super(controller, view, model)
	}
}

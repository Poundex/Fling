package net.poundex.fling.fx.ui.main

import fling.ui.Group
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class MainGroup extends Group<MainController, MainView, MainModel>
{
	@Autowired
	MainGroup(MainController controller, MainView view, MainModel model)
	{
		super(controller, view, model)
	}
}

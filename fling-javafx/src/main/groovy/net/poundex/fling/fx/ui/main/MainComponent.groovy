package net.poundex.fling.fx.ui.main

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class MainComponent extends fling.ui.Component<MainController, MainView, MainModel>
{
	@Autowired
	MainComponent(MainController controller, MainView view, MainModel model)
	{
		super(controller, view, model)
	}
}

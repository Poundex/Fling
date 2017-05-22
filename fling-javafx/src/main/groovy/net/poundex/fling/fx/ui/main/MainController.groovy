package net.poundex.fling.fx.ui.main

import fling.ui.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class MainController extends Controller<MainModel>
{
	@Autowired
	MainController(MainModel model)
	{
		super(model)
	}
}

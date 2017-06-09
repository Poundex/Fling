package net.poundex.fling.fx.ui.paramentry

import fling.ui.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("component")
class ParamEntryController extends Controller<ParamEntryModel>
{
	@Autowired
	ParamEntryController(ParamEntryModel model)
	{
		super(model)
	}
}

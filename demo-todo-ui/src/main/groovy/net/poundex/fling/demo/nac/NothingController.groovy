package net.poundex.fling.demo.nac

import fling.ui.Controller
import net.poundex.fling.ctx.GroupScope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component @Scope("group")
class NothingController extends Controller<NothingModel>
{
	@Autowired
	NothingController(NothingModel model)
	{
		super(model)
	}
}

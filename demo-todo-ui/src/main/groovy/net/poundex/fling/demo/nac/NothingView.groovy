package net.poundex.fling.demo.nac

import fling.ui.View
import groovyx.javafx.SceneGraphBuilder
import net.poundex.fling.ctx.GroupScope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component @Scope('group')
class NothingView extends View<NothingModel, NothingController>
{
	@Autowired
	NothingView(NothingModel model, NothingController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		label(text: bind(model.textProperty()))
	}
}

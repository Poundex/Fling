package net.poundex.fling.fx.ui.information

import fling.ui.Controller
import javafx.event.ActionEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 26/05/17.
 */
@Component @Scope("group")
class InformationController extends Controller<InformationModel>
{
	@Autowired
	InformationController(InformationModel model)
	{
		super(model)
	}

	void dismiss(ActionEvent event)
	{
		model.remover()
	}
}

package net.poundex.fling.fx.ui.form

import fling.ui.Controller
import javafx.event.ActionEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope("component")
class FormController extends Controller<FormModel>
{
	@Autowired
	FormController(FormModel model)
	{
		super(model)
	}

}

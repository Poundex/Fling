package net.poundex.fling.fx.ui.form

import fling.ui.View
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope(BeanDefinition.SCOPE_PROTOTYPE)
class FormView extends View<FormModel, FormController>
{
	@Autowired
	FormView(FormModel model, FormController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		borderPane(styleClass: ['card']) {
			center {
				model.cardContent.render(delegate)
			}
		}
	}
}

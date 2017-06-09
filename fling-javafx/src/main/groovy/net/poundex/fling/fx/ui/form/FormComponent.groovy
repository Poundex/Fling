package net.poundex.fling.fx.ui.form

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope(BeanDefinition.SCOPE_PROTOTYPE)
class FormComponent extends fling.ui.Component<FormController, FormView, FormModel>
{
	@Autowired
	FormComponent(FormController controller, FormView view, FormModel model)
	{
		super(controller, view, model)
	}
}

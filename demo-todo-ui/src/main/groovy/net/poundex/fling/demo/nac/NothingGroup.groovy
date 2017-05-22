package net.poundex.fling.demo.nac

import fling.ui.Group
import groovy.transform.InheritConstructors
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
//@InheritConstructors
@Component @Scope("group")
class NothingGroup extends Group<NothingController, NothingView, NothingModel>
{
	@Autowired
	NothingGroup(NothingController controller, NothingView view, NothingModel model)
	{
		super(controller, view, model)
	}
}

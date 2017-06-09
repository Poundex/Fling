package net.poundex.fling.component

import fling.ui.Component
import net.poundex.fling.ctx.ComponentContextHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

/**
 * Created by poundex on 20/05/17.
 */
@Service
class ComponentService
{
	private final ConfigurableBeanFactory beanFactory
	private final ApplicationContext applicationContext

	@Autowired
	ComponentService(ConfigurableBeanFactory beanFactory, ApplicationContext applicationContext)
	{
		this.beanFactory = beanFactory
		this.applicationContext = applicationContext
	}

	public <T extends Component> T create(Class<T> componentClass, Closure onModelCreated = null)
	{
		ComponentContextHolder.currentContext = UUID.randomUUID()
		T result = applicationContext.getBean(componentClass)
		ComponentContextHolder.currentContext = null
		if(result.model.respondsTo("setComponentID"))
			result.model.componentID = result.id
		onModelCreated?.call(result.model)
		return result
	}
}

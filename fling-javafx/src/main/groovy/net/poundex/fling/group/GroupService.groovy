package net.poundex.fling.group

import fling.ui.Group
import net.poundex.fling.ctx.GroupContextHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

/**
 * Created by poundex on 20/05/17.
 */
@Service
class GroupService
{
	private final ConfigurableBeanFactory beanFactory
	private final ApplicationContext applicationContext

	@Autowired
	GroupService(ConfigurableBeanFactory beanFactory, ApplicationContext applicationContext)
	{
		this.beanFactory = beanFactory
		this.applicationContext = applicationContext
	}

	public <T extends Group> T create(Class<T> groupClass, Closure onModelCreated = null)
	{
		GroupContextHolder.currentContext = UUID.randomUUID()
		T result = applicationContext.getBean(groupClass)
		GroupContextHolder.currentContext = null
		onModelCreated?.call(result.model)
		return result
	}
}

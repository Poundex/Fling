package net.poundex.fling.ctx

import fling.activity.Activity
import net.poundex.fling.activity.ActivityService
import org.springframework.beans.BeansException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component

/**
 * Created by poundex on 26/05/17.
 */
@Component
class ActivityBeanPostProcessor implements BeanPostProcessor
{
	private final ActivityService activityService

	@Autowired
	ActivityBeanPostProcessor(ActivityService activityService)
	{
		this.activityService = activityService
	}

	@Override
	Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
		return bean
	}

	@Override
	Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
	{
		if(bean instanceof Activity)
			activityService.register(bean)

		return bean
	}
}

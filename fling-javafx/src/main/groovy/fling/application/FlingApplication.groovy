package fling.application

import net.poundex.fling.ctx.GroupScope
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Created by poundex on 17/05/17.
 */
abstract class FlingApplication
{
	protected FlingApplication()
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()
		ctx.beanFactory.registerScope(GroupScope.GROUP_SCOPE, new GroupScope())
		ctx.scan(
				'fling.application',
				'net.poundex.fling.ctx',
				'net.poundex.fling.fx',
				'net.poundex.fling.fx.ui',
				'net.poundex.fling.fx.cell',
				'net.poundex.fling.activity',
				'net.poundex.fling.component',
				*basePackages)
		ctx.refresh()
	}

	protected List<String> getBasePackages()
	{
		return []
	}
}

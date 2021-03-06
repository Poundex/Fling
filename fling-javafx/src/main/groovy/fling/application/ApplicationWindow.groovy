package fling.application

import groovyx.javafx.GroovyFX
import net.poundex.fling.fx.IconBeanFactory
import net.poundex.fling.fx.SceneGraphBuilderHolder
import net.poundex.fling.fx.ValueObjectChooserFactory
import net.poundex.fling.fx.cell.ListItemFactory
import net.poundex.fling.fx.ui.main.MainComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ApplicationWindow implements ApplicationListener<ContextRefreshedEvent>
{
	private final MainComponent mainGroup
	private final SceneGraphBuilderHolder sceneGraphBuilderHolder
	private final ListItemFactory listItemFactory
	
	@Autowired
	ApplicationWindow(MainComponent mainGroup, SceneGraphBuilderHolder sceneGraphBuilderHolder, ListItemFactory listItemFactory)
	{
		this.mainGroup = mainGroup
		this.sceneGraphBuilderHolder = sceneGraphBuilderHolder
		this.listItemFactory = listItemFactory
	}

	void init()
	{
		Thread.start {
			GroovyFX.start {
				sceneGraphBuilderHolder.sceneGraphBuilder = delegate
				registerFactory "listItem", listItemFactory
				registerFactory "listItem", listItemFactory
				registerBeanFactory "icon", IconBeanFactory
				registerBeanFactory "valueObjectChooser", ValueObjectChooserFactory

				stage(title: 'Activity Runner', show: true, centerOnScreen: true) {
					mainGroup.render(delegate)
				}
			}
		}
	}

	@Override
	void onApplicationEvent(ContextRefreshedEvent event) {
		init()
	}
}

package fling.application

import groovyx.javafx.GroovyFX
import net.poundex.fling.fx.SceneGraphBuilderHolder
import net.poundex.fling.fx.cell.ListItemFactory
import net.poundex.fling.fx.ui.main.MainGroup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ApplicationWindow
{
	private final MainGroup mainGroup
	private final SceneGraphBuilderHolder sceneGraphBuilderHolder
	private final ListItemFactory listItemFactory
	
	@Autowired
	ApplicationWindow(MainGroup mainGroup, SceneGraphBuilderHolder sceneGraphBuilderHolder, ListItemFactory listItemFactory)
	{
		this.mainGroup = mainGroup
		this.sceneGraphBuilderHolder = sceneGraphBuilderHolder
		this.listItemFactory = listItemFactory
	}

	@PostConstruct
	void init()
	{
		Thread.start {
			GroovyFX.start {
				sceneGraphBuilderHolder.sceneGraphBuilder = delegate
				registerFactory "listItem", listItemFactory

				stage(title: 'Activity Runner', show: true, centerOnScreen: true) {
					mainGroup.render(delegate)
				}
			}
		}
	}
}

package fling.application

import groovyx.javafx.GroovyFX
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.fx.SceneGraphBuilderHolder
import net.poundex.fling.fx.ui.main.MainGroup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
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
	
	@FXBindable String astring = "123"

	@Autowired
	ApplicationWindow(MainGroup mainGroup, SceneGraphBuilderHolder sceneGraphBuilderHolder)
	{
		this.mainGroup = mainGroup
		this.sceneGraphBuilderHolder = sceneGraphBuilderHolder
	}

	@PostConstruct
	void init()
	{
		Thread.start {
			GroovyFX.start {
				sceneGraphBuilderHolder.sceneGraphBuilder = delegate

				stage(title: 'Activity Runner', show: true, centerOnScreen: true) {
					mainGroup.render(delegate)
				}
			}
		}
	}
}

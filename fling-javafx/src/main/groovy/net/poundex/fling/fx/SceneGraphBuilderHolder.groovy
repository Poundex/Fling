package net.poundex.fling.fx

import groovyx.javafx.SceneGraphBuilder
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component
class SceneGraphBuilderHolder
{
	private SceneGraphBuilder sceneGraphBuilder

	SceneGraphBuilder getSceneGraphBuilder()
	{
		return sceneGraphBuilder
	}

	void setSceneGraphBuilder(SceneGraphBuilder sceneGraphBuilder)
	{
		if (this.sceneGraphBuilder)
			throw new IllegalStateException()

		this.sceneGraphBuilder = sceneGraphBuilder
	}
}

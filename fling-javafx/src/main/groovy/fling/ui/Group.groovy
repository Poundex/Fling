package fling.ui

import groovyx.javafx.SceneGraphBuilder
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by poundex on 19/05/17.
 */
abstract class Group<C extends Controller, V extends View, M extends Model>
{
	final UUID id

	final C controller
	final V view
	final M model

	@Autowired
	Group(C controller, V view, M model)
	{
		this.id = UUID.randomUUID()

		this.controller = controller
		this.view = view
		this.model = model
	}

	Object render(SceneGraphBuilder sceneGraphBuilder)
	{
		Closure orig = view.viewBuilder
		model.beforeViewRender()
		orig.rehydrate(sceneGraphBuilder, orig.owner, orig.thisObject).call()
	}
}


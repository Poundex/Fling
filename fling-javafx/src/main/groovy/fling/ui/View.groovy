package fling.ui

import groovy.transform.CompileStatic
import groovyx.javafx.SceneGraphBuilder
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by poundex on 19/05/17.
 */
@CompileStatic
abstract class View<M extends Model, C extends Controller>
{
	final M model
	final C controller

	@Autowired
	View(M model, C controller)
	{
		this.model = model
		this.controller = controller
	}

	abstract Closure getViewBuilder()

	Object renderPartial(Closure view, SceneGraphBuilder sceneGraphBuilder, Map args = [:])
	{
		view.rehydrate(sceneGraphBuilder, view.owner, view.thisObject).call(args)
	}
}

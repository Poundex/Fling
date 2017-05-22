package fling.ui

import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by poundex on 19/05/17.
 */
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
}

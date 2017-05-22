package fling.ui

import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by poundex on 19/05/17.
 */
abstract class Controller<M extends Model>
{
	final M model

	@Autowired
	Controller(M model)
	{
		this.model = model
	}
}

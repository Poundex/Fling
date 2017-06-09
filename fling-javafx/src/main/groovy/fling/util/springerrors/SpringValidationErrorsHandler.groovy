package fling.util.springerrors

import fling.activity.ActivityResult
import fling.activity.ActivityResult.ActivityResultBuilder
import fling.activity.Information

/**
 * Created by poundex on 09/06/17.
 */
trait SpringValidationErrorsHandler
{
	ActivityResult handlingSpringErrors(ActivityResultBuilder activityResultBuilder, Closure<ActivityResult> c)
	{
		try {
			return c()
		} catch (ValidationException vex) {
			this.activityNavigator.refresh activityResultBuilder.with {
				vex.errors.each { err -> information(new Information(Information.Type.ERROR, err.message)) }
				it
			}.build()
		}
	}
}
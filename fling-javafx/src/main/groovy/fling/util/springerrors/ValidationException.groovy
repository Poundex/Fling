package fling.util.springerrors

/**
 * Created by poundex on 09/06/17.
 */
class ValidationException extends RuntimeException
{
	final List errors

	ValidationException(List errors)
	{
		super("Validation errors")
		this.errors = errors
	}
}
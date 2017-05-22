package net.poundex.fling.demo

import fling.application.FlingApplication

/**
 * Created by poundex on 17/05/17.
 */
class TodoApp extends FlingApplication
{
	static void main(String[] args)
	{
		new TodoApp()
	}
	
	@Override
	protected List<String> getBasePackages()
	{
		return ['net.poundex.fling.demo']
	}
}

package net.poundex.fling.fx.cell

import groovy.transform.Canonical
import groovyx.javafx.SceneGraphBuilder
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import org.springframework.stereotype.Component

/**
 * Created by poundex on 23/05/17.
 */
@Component
class ListItemFactory implements Factory
{
	@Canonical
	private static class ListItemHolder
	{
		SceneGraphBuilder sceneGraphBuilder
		Object value
		Map attributes
		Closure<javafx.scene.Node> builder
	}


	@Override
	boolean isLeaf()
	{
		return false
	}

	@Override
	boolean isHandlesNodeChildren() {
		return true
	}

	@Override
	void onFactoryRegistration(FactoryBuilderSupport builder, String registeredName, String registeredGroupName) {

	}

	@Override
	Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		return new ListItemHolder(builder, value, attributes)
	}

	@Override
	boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
		return false
	}

	@Override
	boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
		node.builder = childContent
		return false
	}

	@Override
	void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
		((ListView)parent).cellFactory = {
			return new ListCell() {
				@Override
				protected void updateItem(Object item, boolean empty)
				{
					super.updateItem(item, empty)
					if ( ! item || empty) return
					setText(null)
					node.builder.setDelegate(builder)
					setGraphic(node.builder(item))
				}

			}
		}
	}

	@Override
	void setParent(FactoryBuilderSupport builder, Object parent, Object child)
	{

	}

	@Override
	void setChild(FactoryBuilderSupport builder, Object parent, Object child)
	{
	}
}

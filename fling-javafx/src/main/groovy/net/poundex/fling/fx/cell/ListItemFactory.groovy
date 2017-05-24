package net.poundex.fling.fx.cell

import groovy.transform.Canonical
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent
import org.springframework.stereotype.Component

/**
 * Created by poundex on 23/05/17.
 */
@Component
class ListItemFactory extends AbstractFactory
{
	@Canonical
	private static class ListItemHolder
	{
		Closure<javafx.scene.Node> builder
		Closure onItemActivated
	}

	@Override
	Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		return new ListItemHolder(onItemActivated: attributes['onItemActivated'])
	}

	@Override
	boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent)
	{
		((ListItemHolder)node).builder = childContent
		return false
	}

	@Override
	void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node)
	{
		ListItemHolder listItem = node
		((ListView)parent).cellFactory = {
			return new ListCell() {
				@Override
				protected void updateItem(Object item, boolean empty)
				{
					super.updateItem(item, empty)
					if ( ! item || empty) return
					setText(null)

					if (listItem.onItemActivated)
						setOnMouseClicked { MouseEvent me ->
							if (me.clickCount == 2)
								listItem.onItemActivated(item)
						}
					else
						setOnMouseClicked(null)

					listItem.builder.setDelegate(builder)
					setGraphic(listItem.builder(item))
				}
			}
		}
	}

	@Override
	boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
		return false
	}

	@Override
	boolean isHandlesNodeChildren() {
		return true
	}
}

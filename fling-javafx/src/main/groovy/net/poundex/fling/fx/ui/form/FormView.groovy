package net.poundex.fling.fx.ui.form

import fling.ui.View
import javafx.geometry.Insets
import javafx.geometry.Pos
import net.poundex.fling.fx.ActionType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope(BeanDefinition.SCOPE_PROTOTYPE)
class FormView extends View<FormModel, FormController>
{
	@Autowired
	FormView(FormModel model, FormController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		borderPane(styleClass: ['card']) {
			top {
				label(text: bind(model.titleProperty()), styleClass: ['card-title'])
			}
			center {
				model.cardContent.render(delegate)
			}
			bottom {
				borderPane {
					right {
						hbox(alignment: Pos.BOTTOM_RIGHT,
								padding: new Insets(20, 0, 0, 0),
								spacing: 10) {
							model.actions.findAll { it.actionType != ActionType.AUX }.each {
								it.actionType.styleButton(button(text: it.name, onAction: it))
							}
						}
					}
					left {
						hbox(alignment: Pos.BOTTOM_LEFT,
								padding: new Insets(20, 0, 0, 0),
								spacing: 10) {
							model.actions.findAll { it.actionType == ActionType.AUX }.each {
								it.actionType.styleButton(button(text: it.name, onAction: it))
							}
						}
					}
				}
			}
		}
	}
}

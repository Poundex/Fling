package net.poundex.fling.fx

import de.jensd.fx.glyphs.GlyphIcon
import de.jensd.fx.glyphs.GlyphsDude
import de.jensd.fx.glyphs.materialicons.MaterialIcon
import javafx.scene.control.Label

/**
 * Created by poundex on 27/05/17.
 */
class IconBeanFactory extends Label
{
	private String iconSize = GlyphIcon.DEFAULT_FONT_SIZE
	private MaterialIcon icon
	private List<String> extraStyles = []

	void update()
	{
		GlyphsDude.setIcon(this, icon, iconSize)
		getGraphic().styleClass.addAll(extraStyles)
	}

	void setIcon(MaterialIcon icon)
	{
		this.icon = icon
		update()
	}

	void setIconSize(String size)
	{
		this.iconSize = size
		if(icon)
			update()
	}

	void setExtraStyles(List<String> styles)
	{
		this.extraStyles = styles
		if(icon)
			update()
	}
}

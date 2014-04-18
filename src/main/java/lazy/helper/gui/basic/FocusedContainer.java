package lazy.helper.gui.basic;

import lazy.helper.gui.Container;
import lazy.helper.gui.Scrollbar;
import lazy.helper.gui.Widget;
import lazy.helper.gui.focusable.FocusableWidget;

/**
 * 
 * A "Focused" version of a Container.
 * This container will always have a focused widget
 * as long as there is a focusable widget contained.
 *
 */
public class FocusedContainer extends Container {

	public FocusedContainer() {
		super();
	}

	public FocusedContainer(Scrollbar scrollbar, int shiftAmount, int extraScrollHeight) {
		super(scrollbar, shiftAmount, extraScrollHeight);
	}

	@Override
	public void setFocused(FocusableWidget f) {
		if (f != null)
			super.setFocused(f);
	}

	@Override
	public void addWidgets(Widget... arr) {
		super.addWidgets(arr);

		if (focusIndex == -1 && focusList.size() > 0) {
			focusIndex = 0;
			focusList.get(focusIndex).focusGained();
		}
	}
}

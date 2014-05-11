package qmech.helper.tileentity.control;

/**
 * Implement this interface on Tile Entities which have redstone control functionality.
 */
public interface IRedstoneControl {

	public boolean getControlDisable();

	public boolean getControlSetting();

	public boolean setControlDisable(boolean disable);

	public boolean setControlSetting(boolean state);

	public boolean setRedstoneConfig(boolean disable, boolean state);

	public boolean isPowered();

	public void handlePowerUpdate(boolean powered);

	public void handleConfigUpdate(boolean disable, boolean state);

}

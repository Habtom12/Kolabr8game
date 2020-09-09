package koala.modifiers.firearms;

import koala.game.*;

public class NullFireArm extends AbstractFireArm {
	@Override
	public void fireWeapon(Tank theShip) {
		return;
	}

	@Override
	public void read(Object theObject) {		
	}

}

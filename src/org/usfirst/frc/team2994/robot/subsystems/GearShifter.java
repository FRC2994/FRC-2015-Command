package org.usfirst.frc.team2994.robot.subsystems;

import org.usfirst.frc.team2994.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShifter extends Subsystem {
	public enum Gear {
		HIGH_GEAR,
		LOW_GEAR
	}
	
	DoubleSolenoid gearShift;
	
	@Override
	protected void initDefaultCommand() { }
	
	public GearShifter() {
		super();
		
		gearShift = new DoubleSolenoid(Constants.SHIFTER_A, Constants.SHIFTER_B);
	}
	
	public void setGear(Gear gear) {
		if (gear == Gear.HIGH_GEAR) {
			gearShift.set(DoubleSolenoid.Value.kReverse);
		}
		else {
			gearShift.set(DoubleSolenoid.Value.kForward);
		}
	}
}

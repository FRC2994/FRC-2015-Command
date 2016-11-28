package org.usfirst.frc.team2994.robot.commands;

import org.usfirst.frc.team2994.robot.Robot;
import org.usfirst.frc.team2994.robot.subsystems.GearShifter.Gear;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGear extends Command {
	private Gear gear;
	private boolean done = false;
	
	public ShiftGear(Gear gear) {
		this.gear = gear;
		
		requires(Robot.gearShifter);
	}
	
	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		Robot.gearShifter.setGear(gear);
		
		done = true;
	}

	@Override
	protected boolean isFinished() {
		// The gear is set in the first cycle so we will say right
		// away when we are done
		return done;
	}

	@Override
	protected void end() { }

	@Override
	protected void interrupted() { }

}

package org.usfirst.frc.team2994.robot.commands;

import org.usfirst.frc.team2994.robot.Robot;
import org.usfirst.frc.team2994.robot.subsystems.Forklift.ForkliftDirection;

import edu.wpi.first.wpilibj.command.Command;

public class MoveForklift extends Command {
	ForkliftDirection direction;
	
	public MoveForklift(ForkliftDirection direction) {
		this.direction = direction;
		
		requires(Robot.forklift);
	}

	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		Robot.forklift.move(direction);
	}

	@Override
	protected boolean isFinished() {
		// This command is designed to be interrupted/"cancelled" by
		// the scheduler when the joystick button is released, so there
		// is not an internal condition that could cause this command to
		// be finished.
		return false;
	}

	@Override
	protected void end() {
		// Forklift will adjust itself to the last requested height bump
		// then stop by itself
	}

	@Override
	protected void interrupted() { }
}

package org.usfirst.frc.team2994.robot.commands;

import org.usfirst.frc.team2994.robot.Robot;
import org.usfirst.frc.team2994.robot.subsystems.Intake.IntakeDirection;

import edu.wpi.first.wpilibj.command.Command;

public class RunIntake extends Command {
	IntakeDirection direction;
	
	public RunIntake(IntakeDirection direction) {
		requires(Robot.intake);
		
		this.direction = direction;
	}
	
	
	@Override
	protected void initialize() {
		Robot.intake.move(direction);
	}

	@Override
	protected void execute() { }

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.intake.move(IntakeDirection.STOP);
	}

	@Override
	protected void interrupted() {
		end();
	}

}

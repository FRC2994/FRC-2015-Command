package org.usfirst.frc.team2994.robot.subsystems;

import org.usfirst.frc.team2994.robot.Constants;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	public enum IntakeDirection {
		IN,
		OUT,
		STOP
	}
	
	private SpeedController rightMotor;
	private SpeedController leftMotor;

	public Intake() {
		super();
		
		this.rightMotor = new Talon(Constants.INTAKE_RIGHT_PWM);
		this.leftMotor = new Talon(Constants.INTAKE_LEFT_PWM);
	}
	
	public void move(IntakeDirection direction) {
		// The motors need to run in the same direction, which means -
		// of each other from our POV because of the wiring
		if (direction == IntakeDirection.IN) {
			this.leftMotor.set(-Constants.INTAKE_SPEED);
			this.rightMotor.set(Constants.INTAKE_SPEED);
		}
		else if (direction == IntakeDirection.OUT) {
			this.leftMotor.set(Constants.INTAKE_SPEED);
			this.rightMotor.set(-Constants.INTAKE_SPEED);
		}
		else {
			this.leftMotor.set(0);
			this.rightMotor.set(0);
		}
	}
	
	@Override
	protected void initDefaultCommand() { }

}

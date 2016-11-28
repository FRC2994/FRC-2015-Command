package org.usfirst.frc.team2994.robot.subsystems;

import org.usfirst.frc.team2994.robot.Constants;
import org.usfirst.frc.team2994.robot.utils.Utils;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Forklift extends PIDSubsystem {
	public enum ForkliftDirection {
		UP,
		DOWN
	}
	
	SpeedController motor;
	Encoder encoder;
	
	public Forklift() {
		super(Constants.FORKLIFT_PID_P, Constants.FORKLIFT_PID_I, Constants.FORKLIFT_PID_D);
		
		getPIDController().setAbsoluteTolerance(Constants.FORKLIFT_PID_ERROR);

		encoder = new Encoder(Constants.FORKLIFT_ENCODER_A_DIO, Constants.FORKLIFT_ENCODER_B_DIO);
		//TODO: Is this a CANTalon? The previous robot code shows this as one but labels it as a PWM. Spooky.
		motor = new Talon(Constants.FORKLIFT_PWM);
		
		LiveWindow.addActuator("Forklift", "Motor", (Talon)motor);
		LiveWindow.addSensor("Forklift", "Encoder", encoder);
		LiveWindow.addActuator("Forklift", "PID", getPIDController());
	}

	public double limit(double encoder) {
		return Utils.limit(encoder, 0, Constants.FORKLIFT_MAX_POSITION);
	}
	
	public void moveDown() {
		setSetpoint(limit(getSetpoint() - Constants.FORKLIFT_POSITION_DELTA));
	}

	public void moveUp() {
		setSetpoint(limit(getSetpoint() + Constants.FORKLIFT_POSITION_DELTA));
	}
	
	public void move(ForkliftDirection direction) {
		if (direction == ForkliftDirection.UP) {
			moveUp();
		}
		else {
			moveDown();
		}
	}
	
	public void setTarget(double target) {
		setSetpoint(limit(target));
	}
	
	@Override
	protected void initDefaultCommand() { }

	@Override
	protected double returnPIDInput() {
		return encoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO: No idea why this needs a negative but it has one in the original code
		motor.set(-output);
	}
	
	public void log() {
		SmartDashboard.putData("Forklift Encoder", encoder);
		SmartDashboard.putData("Forklift Motor", (Talon)motor);
	}
}

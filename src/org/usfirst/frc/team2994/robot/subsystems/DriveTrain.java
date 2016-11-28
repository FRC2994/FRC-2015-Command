package org.usfirst.frc.team2994.robot.subsystems;

import org.usfirst.frc.team2994.robot.Constants;
import org.usfirst.frc.team2994.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	private SpeedController frontLeftMotor, rearLeftMotor,
							frontRightMotor, rearRightMotor;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	private AnalogGyro gyro;

	public DriveTrain() {
		super();
		frontLeftMotor = new Talon(Constants.LEFT_FRONT_DRIVE_PWM);
		rearLeftMotor = new Talon(Constants.LEFT_REAR_DRIVE_PWM);
		frontRightMotor = new Talon(Constants.RIGHT_FRONT_DRIVE_PWM);
		rearRightMotor = new Talon(Constants.RIGHT_REAR_DRIVE_PWM);
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor,
							   frontRightMotor, rearRightMotor);

		leftEncoder = new Encoder(Constants.LEFT_ENCODER_A_DIO, Constants.LEFT_ENCODER_B_DIO);
		rightEncoder = new Encoder(Constants.RIGHT_ENCODER_A_DIO, Constants.RIGHT_ENCODER_B_DIO);

		leftEncoder.setDistancePerPulse(Constants.LEFT_ENCODER_DPP);
		rightEncoder.setDistancePerPulse(Constants.RIGHT_ENCODER_DPP);

		gyro = new AnalogGyro(Constants.GYRO_ANALOG);

		// Let's show everything on the LiveWindow
		LiveWindow.addActuator("Drive Train", "Front_Left Motor", (Talon) frontLeftMotor);
		LiveWindow.addActuator("Drive Train", "Back Left Motor", (Talon) rearLeftMotor);
		LiveWindow.addActuator("Drive Train", "Front Right Motor", (Talon) frontRightMotor);
		LiveWindow.addActuator("Drive Train", "Back Right Motor", (Talon) rearRightMotor);
		LiveWindow.addSensor("Drive Train", "Left Encoder", leftEncoder);
		LiveWindow.addSensor("Drive Train", "Right Encoder", rightEncoder);
		LiveWindow.addSensor("Drive Train", "Gyro", gyro);
	}

	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Left Distance", leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
		SmartDashboard.putNumber("Left Speed", leftEncoder.getRate());
		SmartDashboard.putNumber("Right Speed", rightEncoder.getRate());
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}

	/**
	 * @param joy The ps3 style joystick to use to arcade drive style.
	 */
	public void drive(Joystick joy) {
		drive.arcadeDrive(joy);
	}

	public void drive(double left, double right) {
		drive.drive(0, 0);
	}

	/**
	 * @return The robots heading in degrees.
	 */
	public double getHeading() {
		return gyro.getAngle();
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		gyro.reset();
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance())/2;
	}
}

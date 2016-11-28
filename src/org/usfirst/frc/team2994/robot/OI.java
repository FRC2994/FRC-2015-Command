package org.usfirst.frc.team2994.robot;

import org.usfirst.frc.team2994.robot.commands.MoveForklift;
import org.usfirst.frc.team2994.robot.commands.RunIntake;
import org.usfirst.frc.team2994.robot.subsystems.Forklift.ForkliftDirection;
import org.usfirst.frc.team2994.robot.subsystems.Intake.IntakeDirection;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick leftJoystick;
	public Joystick rightJoystick;
	
	public OI() {
		leftJoystick = new Joystick(Constants.DRIVE_JOYSTICK_1_USB);
		rightJoystick = new Joystick(Constants.DRIVE_JOYSTICK_2_USB);
		
		Button moveForkliftUpButton = new JoystickButton(getDriveJoystick(), Constants.MOVE_FORKLIFT_UP_BUTTON);
		moveForkliftUpButton.whileHeld(new MoveForklift(ForkliftDirection.UP));
		
		Button moveForkliftDownButton = new JoystickButton(getDriveJoystick(), Constants.MOVE_FORKLIFT_DOWN_BUTTON);
		moveForkliftDownButton.whileHeld(new MoveForklift(ForkliftDirection.DOWN));
		
		Button runToteIntake = new JoystickButton(getDriveJoystick(), Constants.TAKE_IN_TOTE_BUTTON);
		runToteIntake.whileHeld(new RunIntake(IntakeDirection.IN));
		
		Button pushOutTote = new JoystickButton(getDriveJoystick(), Constants.PUSH_OUT_TOTE_BUTTON);
		pushOutTote.whileHeld(new RunIntake(IntakeDirection.OUT));
		
	}

	public Joystick getDriveJoystick() {
		return leftJoystick;
	}
}


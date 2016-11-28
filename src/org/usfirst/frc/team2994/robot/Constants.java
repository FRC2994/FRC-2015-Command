package org.usfirst.frc.team2994.robot;

public class Constants {
	/// Electronics
	// Drive joysticks
	public static final int DRIVE_JOYSTICK_1_USB = 0;
	public static final int DRIVE_JOYSTICK_2_USB = 1;

	// Drive PWMs
	public static final int LEFT_FRONT_DRIVE_PWM = 9;
	public static final int LEFT_REAR_DRIVE_PWM = 8;
	public static final int RIGHT_FRONT_DRIVE_PWM = 3;
	public static final int RIGHT_REAR_DRIVE_PWM = 2;
	
	// Mechanism PWMs
	public static final int FORKLIFT_PWM = 11;
	public static final int INTAKE_RIGHT_PWM = 4;
	public static final int INTAKE_LEFT_PWM = 5;
	
	// Encoders
	public static final int LEFT_ENCODER_A_DIO = 7;
	public static final int LEFT_ENCODER_B_DIO = 6;
	public static final double LEFT_ENCODER_DPP = 0.008038585209003215;
	
	public static final int RIGHT_ENCODER_A_DIO = 9;
	public static final int RIGHT_ENCODER_B_DIO = 8;
	public static final double RIGHT_ENCODER_DPP = -0.0078003120124804995;
	
	public static final int FORKLIFT_ENCODER_A_DIO = 0;
	public static final int FORKLIFT_ENCODER_B_DIO = 1;

	// Gyro Analog
	public static final int GYRO_ANALOG = 0;
	
	// PID values for arm
	public static final double FORKLIFT_PID_P = 0.006;
	public static final double FORKLIFT_PID_I = 0.002;
	public static final double FORKLIFT_PID_D = 0.001;
	public static final double FORKLIFT_PID_ERROR = 5;
	
	// Compressor/Solenoids
	public static final int COMPRESSOR_CHANNEL = 1;
	public static final int SHIFTER_A = 0;
	public static final int SHIFTER_B = 1;
	
	/// Logic
	// Forklift
	public static final double FORKLIFT_POSITION_DELTA = 8.0;
	public static final double FORKLIFT_MAX_POSITION = 890.0;
	
	// Intake
	public static final double INTAKE_SPEED = 0.95;
	
	/// Buttons/user input
	public static final int MOVE_FORKLIFT_UP_BUTTON = 6;
	public static final int MOVE_FORKLIFT_DOWN_BUTTON = 7;
	
	public static final int TAKE_IN_TOTE_BUTTON = 1;
	public static final int PUSH_OUT_TOTE_BUTTON = 2;
}

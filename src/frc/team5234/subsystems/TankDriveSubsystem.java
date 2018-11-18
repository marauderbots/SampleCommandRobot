package frc.team5234.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team5234.RobotMap;
import frc.team5234.commands.TeleopCommand;

/**
 * An example of how a tank drive subsystem may work
 */
public class TankDriveSubsystem extends Subsystem {

    // Define all of our motor controllers here
    protected Spark frontLeft;
    protected Spark frontRight;
    protected Spark backLeft;
    protected Spark backRight;

    // Classify all of your motor controllers into groups to define the tank sides
    protected SpeedControllerGroup leftMotorGroup;
    protected SpeedControllerGroup rightMotorGroup;

    // The robot drive system that we'll use
    protected DifferentialDrive differentialDrive;

    // A place to store the most recent encoder value
    private double encoderValue = 0;

    /**
     * Default Constructor
     */
    public TankDriveSubsystem() {
        // This is off for now, to allow for testing
//        init();
    }

    /**
     * Separating the initial setup out makes testing easier
     */
    protected void init() {
        frontLeft = new Spark(RobotMap.FRONT_LEFT_MOTOR);
        frontRight = new Spark(RobotMap.FRONT_RIGHT_MOTOR);
        backLeft = new Spark(RobotMap.BACK_LEFT_MOTOR);
        backRight = new Spark(RobotMap.BACK_RIGHT_MOTOR);

        leftMotorGroup = new SpeedControllerGroup(frontLeft, backLeft);
        rightMotorGroup = new SpeedControllerGroup(frontRight, backRight);

        differentialDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
    }

    /**
     * Every Subsystem needs to have a default command
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopCommand());
    }

    /**
     * Standard drive as tank method, speed and rotation are passed along as they are received.
     * @param leftSpeed
     * @param rightSpeed
     */
    public void driveAsTank(double leftSpeed, double rightSpeed) {
//        differentialDrive.tankDrive(leftSpeed, rightSpeed);
        System.out.println("Left Speed: " + leftSpeed + ", Right Speed: " + rightSpeed);
    }

    /**
     * An alternative drive method, meant to mimic the controls of a popular driving video game.
     * leftTrigger is meant to be reverse, rightTrigger is meant to be forward, rotation to turn
     * @param leftTrigger
     * @param rightTrigger
     * @param rotation
     */
    public void videoGameDrive(double leftTrigger, double rightTrigger, double rotation) {
        // Place holder for our speed value that will be determined after we read each trigger
        double speed = 0.0;

        // In this example, forward always wins if both triggers are pressed.
        // Another desired option may be to use a brake when both triggers are pressed.
        if (rightTrigger > 0) {
            speed = rightTrigger;
        } else {
            // Left is reverse, negate the input value
            speed = leftTrigger * -1;
        }

        System.out.println("Speed: " + speed);
        System.out.println("Rotation: " + rotation);

//        differentialDrive.arcadeDrive(speed, rotation);
    }

    /**
     * A method to return the last encoder value
     * @return
     */
    public double getLeftEncoder() {
        return encoderValue;
    }

    /**
     * A method to return the last encoder value
     * @return
     */
    public double getRightEncoder() {
        return encoderValue;
    }
}

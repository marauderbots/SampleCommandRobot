package frc.team5234.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5234.Robot;
import frc.team5234.subsystems.TankDriveSubsystem;

/**
 * An example of how a teleop command might look for drive controls
 */
public class TeleopCommand extends Command {

    // Our reference to the tank drive subsystem
    TankDriveSubsystem tankDriveSubsystem;

    // Our reference to the joystick that we want to use
    Joystick joystick;

    /**
     * Default Constructor
     */
    public TeleopCommand() {
        init();
    }

    /**
     * Separating the initial setup out makes testing easier
     */
    protected void init() {
        tankDriveSubsystem = Robot.subsystemMaster.getTankDriveSubsystem();
        joystick = Robot.oi.getJoystick();

        requires(tankDriveSubsystem);
    }

    /**
     * Do your iteration work in the execute method of the Command. This runs at roughly 50hz.
     */
    @Override
    protected void execute() {
        // You might do something like this to debug the joystick input
//        System.out.println("Left: " + joystick.getRawAxis(RobotMap.DRIVE_LEFT_TRIGGER));
//        System.out.println("Right: " + joystick.getRawAxis(RobotMap.DRIVE_RIGHT_TRIGGER));

        // Standard drive as tank call
//        tankDriveSubsystem.driveAsTank(joystick.getRawAxis(RobotMap.DRIVE_LEFT_TRIGGER), joystick.getRawAxis(RobotMap.DRIVE_RIGHT_TRIGGER));

        // A custom video game drive to mimic a different type of input
//        double rotation = joystick.getRawAxis(RobotMap.DRIVE_STICK);

        // If you want to alter the input before passing it to the controller, you can do that here.
//        rotation = Math.pow(rotation, 3);

        // The call to our subsystem with the altered rotation value from above
//        tankDriveSubsystem.videoGameDrive(joystick.getRawAxis(RobotMap.DRIVE_LEFT_TRIGGER), joystick.getRawAxis(RobotMap.DRIVE_RIGHT_TRIGGER), rotation);
    }

    /**
     * This command should never finish on its own,
     * instead it will be canceled by other commands that need this subsystem.
     * @return
     */
    @Override
    protected boolean isFinished() {
        return false;
    }
}

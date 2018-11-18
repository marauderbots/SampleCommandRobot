package frc.team5234.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team5234.Robot;
import frc.team5234.subsystems.TankDriveSubsystem;

/**
 * TimedCommand
 * An example created to show how a timed based command would work.
 * This example is used to perform the usual auto run option during most FRC games.
 */
public class Auto1 extends TimedCommand {

    // Our reference to the tank drive subsystem
    TankDriveSubsystem tankDriveSubsystem;

    // A fake encoder value, used for example
    double encoderValue = 0;

    /**
     * Default Constructor
     * We can handle setting the name and timeout this way if they don't need to be dynamic
     */
    public Auto1() {
        super("Auto 1", 15);
        init();
    }

    /**
     * Separating the initial setup out makes testing easier
     */
    protected void init() {
        tankDriveSubsystem = Robot.subsystemMaster.getTankDriveSubsystem();

        requires(tankDriveSubsystem);
    }

    /**
     * Do your iteration work in the execute method of the Command. This runs at roughly 50hz.
     */
    @Override
    protected void execute() {
        tankDriveSubsystem.driveAsTank(0.5, 0.0);
        System.out.println("Driving in Auto!");

        encoderValue += 100;
    }

    /**
     * We're watching for a fixed encoder value or the time out to happen.
     * Note: Using a fixed value for encoders is not a great idea.
     * @return
     */
    @Override
    protected boolean isFinished() {
        return encoderValue >= 1500 || isTimedOut();
    }
}

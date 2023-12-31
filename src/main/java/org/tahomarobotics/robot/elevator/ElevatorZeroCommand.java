package org.tahomarobotics.robot.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static org.tahomarobotics.robot.elevator.ElevatorConstants.desiredPos;
import java.util.function.DoubleSupplier;

/**
 * Moves the elevator down at a <b>safe</b> speed until it hits the bottom and sets zero.
 */
public class ElevatorZeroCommand extends CommandBase {
    public ElevatorZeroCommand() {
        // TODO
    }

    @Override
    public void initialize() {
        // TODO
    }

    @Override
    public void execute() {
        desiredPos = 0;
    }

    @Override
    public boolean isFinished() {
        // TODO
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        // TODO
    }
}

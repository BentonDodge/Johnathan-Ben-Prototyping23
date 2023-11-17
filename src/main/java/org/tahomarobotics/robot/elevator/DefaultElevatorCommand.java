package org.tahomarobotics.robot.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.EventListener;
import java.util.function.DoubleSupplier;

import static org.tahomarobotics.robot.elevator.ElevatorConstants.desiredPos;

/**
 * Default control for the elevator, manually controlled by the manipulator
 */
public class DefaultElevatorCommand extends CommandBase {
    public DefaultElevatorCommand() {
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        // TODO
    }
}

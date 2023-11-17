package org.tahomarobotics.robot.elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tahomarobotics.robot.OI;
import org.tahomarobotics.robot.motion.MotionProfile;
import org.tahomarobotics.robot.motion.MotionState;
import org.tahomarobotics.robot.motion.SCurveMotionProfile;
import java.util.function.DoubleSupplier;
import static org.tahomarobotics.robot.elevator.ElevatorConstants.desiredPos;

/**
 * Moves the elevator to a desired location with a motion profile.
 * (Decide whether to move arm and elevator separate, or move them both in this command)
 */
public class ElevatorMoveCommand extends CommandBase {
    private static final Logger logger = LoggerFactory.getLogger(ElevatorMoveCommand.class);
    public DoubleSupplier upSup;
   public static final OI oi = OI.getInstance();

    public ElevatorMoveCommand(DoubleSupplier upSup) {
        this.upSup=upSup;


    }

    @Override
    public void initialize() {
        Elevator.moveUp(upSup.getAsDouble());
        try {
            SCurveMotionProfile motionProfile = new SCurveMotionProfile(0, ElevatorConstants.ELEVATOR_POSITION, ElevatorConstants.desiredPos, 0, 0, 1, 2, 20);
        } catch (MotionProfile.MotionProfileException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void execute() {
        if(oi.driverController.getPOV()!=-1) {
            if (oi.controllerDpad() == 0) {
                desiredPos = 1.7;
            }
            if (oi.controllerDpad() == 90) {
                desiredPos = 0.85;
            }
            if (oi.controllerDpad() == 180) {
                desiredPos = 0;
            }
        }
        else {
            desiredPos=(oi.joystickLeftY()*0.85)+0.85;
        }
    }


    @Override
    public boolean isFinished() {
        MotionState motionStatus = new MotionState();
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        // TODO
    }
}

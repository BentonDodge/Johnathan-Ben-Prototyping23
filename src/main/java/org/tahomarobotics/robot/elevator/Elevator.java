package org.tahomarobotics.robot.elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tahomarobotics.robot.RobotMap;

public class Elevator extends SubsystemBase {
    private static final Logger logger = LoggerFactory.getLogger(Elevator.class);
    private static final Elevator INSTANCE = new Elevator();

    public static Elevator getInstance() {
        return INSTANCE;
    }

    private static final TalonFX motorR = new TalonFX(RobotMap.ELEVATOR_RIGHT_MOTOR);
    private final TalonFX motorL = new TalonFX(RobotMap.ELEVATOR_LEFT_MOTOR);

    private Elevator() {
        motorL.follow(motorR);
        //TODO might involve PID V
        motorL.setNeutralMode(NeutralMode.Brake);
        motorR.setNeutralMode(NeutralMode.Brake);
    }

    public Elevator instialize() {
        return this;
    }

    public static void moveUp(double value) {
        motorR.set(TalonFXControlMode.PercentOutput, value);
    }
}

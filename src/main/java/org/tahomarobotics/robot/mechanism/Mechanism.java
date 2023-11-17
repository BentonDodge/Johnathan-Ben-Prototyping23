package org.tahomarobotics.robot.mechanism;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tahomarobotics.robot.RobotMap;

/**
 * A generic mechanism subsystem to provide generic functionality
 * to a mechanism with 2 motors. Rev and or CTRE motors
 */
public class Mechanism extends SubsystemBase {
    private static final Logger logger = LoggerFactory.getLogger(Mechanism.class);
    private static final Spark mechMotor1 = new Spark(RobotMap.MECHANISM_MOTOR_ONE);
    private static final Spark mechMotor2 = new Spark(RobotMap.MECHANISM_MOTOR_TWO);
    private static final Mechanism INSTANCE = new Mechanism();

    public static Mechanism getInstance() {
        return INSTANCE;
    }
}

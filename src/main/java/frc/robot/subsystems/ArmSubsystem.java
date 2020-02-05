/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.kArmLimitSwitch;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;

public class ArmSubsystem extends ProfiledPIDSubsystem {
  static TalonSRX armMotor;
  public DigitalInput armSwitch = new DigitalInput(kArmLimitSwitch);

  /**
   * Creates a new ArmSubsystem.
   */
  public ArmSubsystem() {
    super(
        // The ProfiledPIDController used by the subsystem
        new ProfiledPIDController(0, 0, 0,
            // The motion profile constraints
            new TrapezoidProfile.Constraints(0, 0)));
  }

  public void armLift() {

  }

  public void armDown() {
    if (getArmSwitch()) {
      ArmSubsystem.armStop();
    } else {
    }
  }

  public static void armStop() {
    armMotor.set(ControlMode.PercentOutput, 0);
  }
  public boolean getArmSwitch() {
    armSwitch.get();
    return armSwitch.get();
  }
  
  @Override
  public void useOutput(double output, TrapezoidProfile.State setpoint) {
    // Use the output (and optionally the setpoint) here
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }
}

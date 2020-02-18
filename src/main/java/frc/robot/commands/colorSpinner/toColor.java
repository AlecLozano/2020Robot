/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorSpinner;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorSpinnerSubsystem;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class toColor extends CommandBase {

  ColorSpinnerSubsystem spinner;
  SwerveDriveSubsystem drive;

  public String color;//needs work

  public toColor(final ColorSpinnerSubsystem colorSub, final SwerveDriveSubsystem driveSub){
    spinner = colorSub;
    drive = driveSub;
    addRequirements(spinner, drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  while (spinner.detectColor() != color);
    spinner.spinL();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (spinner.detectColor() == color){
    return true;
    }
    else{
    return false;
    }
  }
}

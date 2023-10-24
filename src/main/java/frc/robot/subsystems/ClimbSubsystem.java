// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
    //init stuff
    WPI_TalonSRX climbMotor;
  
  public ClimbSubsystem() {
    //motors
    climbMotor = new WPI_TalonSRX(0);
  }

  @Override
  public void periodic() {
  }

  public void moveManual(){}

  //auto shenanigans
  public void stop(){}

  public void spit(){}
  
  public void intake(){}

}

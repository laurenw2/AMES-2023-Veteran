// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DoingThingsMotorIDs;

public class ClawSubsystem extends SubsystemBase {
    //init stuff
    CANSparkMax clawRunMotor;
  
  public ClawSubsystem() {
    //motors
    clawRunMotor = new CANSparkMax(DoingThingsMotorIDs.clawRunMotorID, MotorType.kBrushless);
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

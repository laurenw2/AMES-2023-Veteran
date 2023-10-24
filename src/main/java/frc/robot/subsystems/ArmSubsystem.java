// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DoingThingsMotorIDs;

public class ArmSubsystem extends SubsystemBase {
    //init stuff
      TalonFX armSwingMotor;
      TalonFX wristMotor;
      CANSparkMax armExtendMotor1;
      CANSparkMax armExtendMotor2;
  
  public ArmSubsystem() {
    //motors/encoders
      armSwingMotor = new TalonFX(DoingThingsMotorIDs.armSwingMotorID);
      wristMotor = new TalonFX(DoingThingsMotorIDs.wristMotorID);
      armExtendMotor1 = new CANSparkMax(DoingThingsMotorIDs.armExtendMotorID1, MotorType.kBrushless);
      armExtendMotor2 = new CANSparkMax(DoingThingsMotorIDs.armExtendMotorID2, MotorType.kBrushless);

    //config PID

    //config max output, safety


  }

  @Override
  public void periodic() {
  }

  public void resetEncoders(){

  }

  public void setLow(){}

  public void setMid(){}

  public void setHigh(){}

  public void setHome(){}

  public void moveManual(){}

  //auto shenanigans

}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.ModuleLayer.Controller;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorIDs;
import frc.robot.Constants.MotorPIDConstants;
import frc.robot.Constants.MotorSpeedsMaxes;

public class WristSubsystem extends SubsystemBase {
    //init stuff
      TalonFX wristMotor;
      TalonFXSensorCollection wristEnc;
  public WristSubsystem() {
    //motors/encoders
      wristMotor = new TalonFX(MotorIDs.wristMotorID);
      wristEnc = new TalonFXSensorCollection(wristMotor);

    //config PID
      wristMotor.config_kF(0, MotorPIDConstants.wristMotorkF);
      wristMotor.config_kP(0, MotorPIDConstants.wristMotorkP);
      wristMotor.config_kI(0, MotorPIDConstants.wristMotorkI);
      wristMotor.config_kD(0, MotorPIDConstants.wristMotorkD);


    //config max output, safety
      wristMotor.configClosedLoopPeakOutput(0, MotorSpeedsMaxes.wristClosedMaxOutput);
      wristMotor.configClosedloopRamp(MotorSpeedsMaxes.wristClosedRamp);
      wristMotor.configPeakOutputForward(MotorSpeedsMaxes.wristOpenMaxOutput);
      wristMotor.configPeakOutputReverse(-MotorSpeedsMaxes.wristOpenMaxOutput);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Wrist Encoder Abs Position", wristEnc.getIntegratedSensorAbsolutePosition());
    SmartDashboard.putNumber("Wrist Encoder Rel Position", wristEnc.getIntegratedSensorPosition());

  }

  public void resetEncoders(){
    wristEnc.setIntegratedSensorPosition(0, 15);
  }

  public void setHome(){
    //set to home encoder position
    wristMotor.set(ControlMode.Position, 0);    
  }

  public void setIntake(){
    //set to intake encoder position
    wristMotor.set(ControlMode.Position, 0);
  }

  public void setScore(){
    //set to score encoder position
    wristMotor.set(ControlMode.Position, 0);
  }

  public void setClimb(){
    //set to perpendicular encoder position
    wristMotor.set(ControlMode.Position, 0);
  }

  public void moveManual(XboxController controller){
    //left axis wrist up down
    wristMotor.set(ControlMode.PercentOutput, MotorSpeedsMaxes.wristOpenMaxOutput*controller.getRawAxis(1));
  }

  //auto shenanigans

}

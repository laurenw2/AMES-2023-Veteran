// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorIDs;
import frc.robot.Constants.MotorPIDConstants;
import frc.robot.Constants.MotorSpeedsMaxes;
import frc.robot.Constants.PositionValues;

public class ArmSubsystem extends SubsystemBase {
    //init stuff
      TalonFX armSwingMotor;
      TalonFXSensorCollection armSwingEnc;
      CANSparkMax armExtendMotor1;
      CANSparkMax armExtendMotor2;
      SparkMaxPIDController armExtendPID;
      RelativeEncoder armExtendEncoder;
  
  public ArmSubsystem() {
    //motors/encoders
      armSwingMotor = new TalonFX(MotorIDs.armSwingMotorID);
      armSwingEnc = new TalonFXSensorCollection(armSwingMotor);
      armExtendMotor1 = new CANSparkMax(MotorIDs.armExtendMotorID1, MotorType.kBrushless);
      armExtendMotor2 = new CANSparkMax(MotorIDs.armExtendMotorID2, MotorType.kBrushless);
      armExtendEncoder = armExtendMotor1.getEncoder();
      armExtendPID = armExtendMotor1.getPIDController();

      armExtendMotor2.follow(armExtendMotor1);

    //config PID
      armSwingMotor.config_kF(0, MotorPIDConstants.armSwingMotorkF);
      armSwingMotor.config_kP(0, MotorPIDConstants.armSwingMotorkP);
      armSwingMotor.config_kI(0, MotorPIDConstants.armSwingMotorkI);
      armSwingMotor.config_kD(0, MotorPIDConstants.armSwingMotorkD);

      armExtendPID.setFF(MotorPIDConstants.armExtendkF);
      armExtendPID.setP(MotorPIDConstants.armExtendkP);
      armExtendPID.setI(MotorPIDConstants.armExtendkI);
      armExtendPID.setD(MotorPIDConstants.armExtendkD);

    //config max output, safety
      armSwingMotor.configClosedloopRamp(MotorSpeedsMaxes.armSwingClosedRamp);
      armSwingMotor.configClosedLoopPeakOutput(0, MotorSpeedsMaxes.armSwingClosedMaxOutput);
      armSwingMotor.configOpenloopRamp(MotorSpeedsMaxes.armSwingOpenRamp);
      armExtendMotor1.setClosedLoopRampRate(MotorSpeedsMaxes.armExtendClosedRamp);
      armExtendMotor2.setClosedLoopRampRate(MotorSpeedsMaxes.armExtendClosedRamp);
      armExtendMotor1.setOpenLoopRampRate(MotorSpeedsMaxes.armExtendOpenRamp);
      armExtendMotor2.setOpenLoopRampRate(MotorSpeedsMaxes.armExtendOpenRamp);
      armExtendPID.setOutputRange(-MotorSpeedsMaxes.armExtendClosedMaxOutput, MotorSpeedsMaxes.armExtendClosedMaxOutput);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm Swing Encoder Value", armSwingEnc.getIntegratedSensorPosition());
    SmartDashboard.putNumber("Arm Extend Encoder Value", armExtendEncoder.getPosition());
  }

  public void resetEncoders(){
    armSwingEnc.setIntegratedSensorPosition(0, 15);
    armExtendEncoder.setPosition(0);
  }

  public void setSwingHome(){
    //set swing motor to home encoder position
    armSwingMotor.set(ControlMode.Position, PositionValues.armSwingHomeVal);
  }

  public void setSwingScore(){
    //set swing motor to score encoder position
    armSwingMotor.set(ControlMode.Position, PositionValues.armSwingScoreVal);
  }

  public void setSwingClimb(){
    //set swing motor to climb encoder position
    armSwingMotor.set(ControlMode.Position, PositionValues.armSwingClimbVal);
  }

  public void setExtendIn(){
    //set extend motor to "in" position
    armExtendPID.setReference(PositionValues.armExtendInVal, ControlType.kPosition);
  }

  public void setExtendOut(){
    //set extend motor to "out" position
    armExtendPID.setReference(PositionValues.armExtendOutVal, ControlType.kPosition);
  }

  public void moveManual(XboxController controller){
    //set arm motors according to axes
    //swing right joystick

    armSwingMotor.set(ControlMode.PercentOutput, MotorSpeedsMaxes.armSwingOpenMaxOutput*controller.getRawAxis(5));

    //extend button A
    if(controller.getRawButton(1)){
      armExtendMotor1.set(-MotorSpeedsMaxes.armExtendOpenMaxOutput);
    }
    //retract button B
    if(controller.getRawButton(2)){
      armExtendMotor1.set(MotorSpeedsMaxes.armExtendOpenMaxOutput);
    }
    if(!controller.getRawButton(1)&&!controller.getRawButton(2)){
      armExtendMotor1.set(0);
    }
    
  }

  //auto shenanigans

}

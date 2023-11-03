// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorIDs;
import frc.robot.Constants.MotorSpeedsMaxes;

public class ClawSubsystem extends SubsystemBase {
    //init stuff
    CANSparkMax clawRunMotor;
  
  public ClawSubsystem() {
    //motors
    clawRunMotor = new CANSparkMax(MotorIDs.clawRunMotorID, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
  }

  public void moveManual(XboxController controller){
    if(controller.getRawAxis(3)>0){
      //right trigger intake
      clawRunMotor.set(MotorSpeedsMaxes.clawRunSpeed*controller.getRawAxis(3));
    }
    if(controller.getRawAxis(2)>0){
      //left trigger outtake
      clawRunMotor.set(-MotorSpeedsMaxes.clawRunSpeed*controller.getRawAxis(2));
    }
    if(controller.getRawAxis(3)==0 && controller.getRawAxis(2)==0){
      //if neither active set 0
      clawRunMotor.set(0);
    }
  }

  //auto shenanigans
  public void stop(){
    clawRunMotor.set(0);
  }

  public void spit(){}
  
  public void intake(){}

}

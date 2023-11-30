package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WristSubsystem;

public class ManualWristCommand extends CommandBase{

    private final WristSubsystem m_wristSubsystem;
    private XboxController m_controller;
    
    public ManualWristCommand(WristSubsystem wristSubsystem, XboxController controller){
        m_wristSubsystem = wristSubsystem;
        m_controller = controller;
        addRequirements(m_wristSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_wristSubsystem.moveManual(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }

}
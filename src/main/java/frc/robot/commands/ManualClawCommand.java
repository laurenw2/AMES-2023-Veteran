package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class ManualClawCommand extends CommandBase{

    private final ClawSubsystem m_clawSubsystem;
    private XboxController m_controller;
    
    public ManualClawCommand(ClawSubsystem clawSubsystem, XboxController controller){
        m_clawSubsystem = clawSubsystem;
        m_controller = controller;
        addRequirements(m_clawSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        m_clawSubsystem.moveManual(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }

}
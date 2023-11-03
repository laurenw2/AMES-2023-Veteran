package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmSwingCommand extends CommandBase{

    private final ArmSubsystem m_armSubsystem;
    private final String m_armHeight;
    
    public SetArmSwingCommand(ArmSubsystem armSubystem, String armHeight){
        m_armSubsystem = armSubystem;
        m_armHeight = armHeight;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        if(m_armHeight == "score"){
            m_armSubsystem.setSwingScore();
        }
        if(m_armHeight == "climb"){
            m_armSubsystem.setSwingClimb();
        }
        if(m_armHeight == "home"){
            m_armSubsystem.setSwingHome();
        }
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
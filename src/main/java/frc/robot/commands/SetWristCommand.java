package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WristSubsystem;

public class SetWristCommand extends CommandBase{

    private final WristSubsystem m_wristSubsystem;
    private final String m_wristHeight;
    
    public SetWristCommand(WristSubsystem wristSubsystem, String wristHeight){
        m_wristSubsystem = wristSubsystem;
        m_wristHeight = wristHeight;
        addRequirements(m_wristSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        if(m_wristHeight == "score"){
            m_wristSubsystem.setScore();
        }
        if(m_wristHeight == "climb"){
            m_wristSubsystem.setClimb();
        }
        if(m_wristHeight == "intake"){
            m_wristSubsystem.setIntake();
        }
        if(m_wristHeight == "home"){
            m_wristSubsystem.setHome();
        }
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
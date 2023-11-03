package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmExtendCommand extends CommandBase{

    private final ArmSubsystem m_armSubsystem;
    private final String m_armLength;
    
    public SetArmExtendCommand(ArmSubsystem armSubystem, String armLength){
        m_armSubsystem = armSubystem;
        m_armLength = armLength;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
    }
        
    @Override
    public void execute() {
        if(m_armLength == "in"){
            m_armSubsystem.setExtendIn();
        }
        if(m_armLength == "out"){
            m_armSubsystem.setExtendOut();
        }
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }

}
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ManualArmCommand extends CommandBase{

    private final ArmSubsystem m_armSubsystem;
    private XboxController m_controller;
    
    public ManualArmCommand(ArmSubsystem armSubystem, XboxController controller){
        m_armSubsystem = armSubystem;
        m_controller = controller;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize() {
        //m_armSubsystem.resetEncoders();
    }
        
    @Override
    public void execute() {
        m_armSubsystem.moveManual(m_controller);
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }

}
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class MoveTurret extends CommandBase {

    private double power = 0.0;

    Turret turret;
    XboxController gamepad;

    public MoveTurret(Turret trrt, XboxController gmpd) {
        this.turret = trrt;
        this.gamepad = gmpd;
        addRequirements(turret);
    }

    @Override
    public void execute() {

        power = gamepad.getX(Hand.kLeft);

        if (Math.abs(power) <= .02) {
            power = 0.0;
        }

        turret.setPower(power);
        turret.moveTurret();
    }

    // Command runs until interrupted
    @Override
    public boolean isFinished() {

        return false;
    }

    // Runs when isFinished returns true
    @Override
    public void end(boolean interrupted) {
        turret.stopTurret();
    }
}
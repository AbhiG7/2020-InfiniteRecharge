/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  Joystick rightStick = new Joystick(Constants.rightStick);
  Joystick leftStick = new Joystick(Constants.leftStick);
  XboxController gamepad = new XboxController(Constants.gamepad);

  private final Drivetrain drivetrain = new Drivetrain();
  private final Turret turret = new Turret();
  private final DataRecorder dataRecorder = new DataRecorder();

  private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks(drivetrain, rightStick, leftStick);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    final JoystickButton aButton = new JoystickButton(gamepad, Button.kA.value);
    final JoystickButton bButton = new JoystickButton(gamepad, Button.kB.value);
    final JoystickButton xButton = new JoystickButton(gamepad, Button.kX.value);

    bButton.whenPressed(new RecordData(dataRecorder, true));
    xButton.whenPressed(new RecordData(dataRecorder, false));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //TODO create actual auto command
    return driveWithJoysticks;
  }
}

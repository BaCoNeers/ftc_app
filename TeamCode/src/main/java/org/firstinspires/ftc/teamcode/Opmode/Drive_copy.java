/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.Opmode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Classes.JewelDrop;
import org.firstinspires.ftc.teamcode.Configuration;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
        */



@TeleOp(name="copy", group="Pushbot")

public class Drive_copy extends LinearOpMode {

    /* Declare OpMode members. */
    private Configuration robot           = new Configuration();   // Use a Pushbot's hardware
    private boolean toggle = false;
    private boolean toMax = false;
    private boolean toMin = false;
    private double divider = 1;
    private double  drive;
    private JewelDrop jewel = new JewelDrop();

    public double lerp(double a, double b, double z){
        double number = 0;
        number = a+(b-a)*z;
        return number;
    }

    @Override
    public void runOpMode() {


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
//        jewel.Jewel(true, robot);
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {



//            double forward = gamepad1.left_stick_y;
//            double speedLeft =  forward;
//            double speedRight = forward;
//            double turning = gamepad1.right_stick_x;
//
//
//
//            double forwardLeftMotor = forward;
//            double forwardRightMotor = forward;
//            double clockwiseLeftMotor = turning;
//            double clockwiseRightMotor = -turning;
//
//
//            speedLeft = forward*lerp(1,1,turning);
//            speedRight = forward*lerp(1,-1,turning);
//            speedLeft = (forward * (1-Math.abs(turning))+turning*(1-Math.abs(forward)))*0.1;
//            speedRight = (forward * (1-Math.abs(turning))-turning*(1-Math.abs(forward)))*0.1  ;
////            speedLeft *= turning;
////            speedRight *= -turning;


            double scalePower = (gamepad1.left_stick_y);

            double steer = (gamepad1.right_stick_x);
            double leftPower;
            double rightPower;
            if (scalePower == 0.0f) {
                leftPower = steer;
                rightPower = -steer;
            }
            else {
                leftPower = scalePower * ((steer < 0) ? 1.0f + steer : 1.0f);
                rightPower = scalePower * ((steer > 0) ? 1.0f - steer : 1.0f);
            }

            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);


        }
    }


}



package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="PetruSAMCA")
public class PetruSAMCA extends LinearOpMode{
    @Override
    public void runOpMode() {
        DcMotor frontRightDrive;
        frontRightDrive = hardwareMap.get(DcMotor.class, "dreapta_fata");
        DcMotor frontLeftDrive;
        frontLeftDrive = hardwareMap.get(DcMotor.class, "stanga_fata");
        DcMotor backRightDrive;
        backRightDrive = hardwareMap.get(DcMotor.class, "dreapta_spate");
        DcMotor backLeftDrive;
        backLeftDrive = hardwareMap.get(DcMotor.class, "stanga_spate");
        
        waitForStart();
        
        while (opModeIsActive()) {
            Float lateral, axial, yaw;
            double max;
            
            lateral = this.gamepad1.right_stick_x;
            axial = this.gamepad1.right_stick_y;
            yaw = -this.gamepad1.left_stick_x;

            frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
            frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
            backRightDrive.setDirection(DcMotor.Direction.REVERSE);
            backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
            
            double sadfsafseqzqs = Math.max(Math.abs(axial) + Math.abs(lateral) + Math.abs(yaw), 1);
            double frontLeftPower=(axial+lateral+yaw)/sadfsafseqzqs;
            double frontRightPower=(axial-lateral-yaw)/sadfsafseqzqs;
            double backLeftPower=(axial-lateral+yaw)/sadfsafseqzqs;
            double backRightPower=(axial+lateral-yaw)/sadfsafseqzqs;
            
            this.telemetry.addLine("fl" + frontLeftPower);
            this.telemetry.addLine("fr" + frontRightPower);
            this.telemetry.addLine("bl" + backLeftPower);
            this.telemetry.addLine("br" + backRightPower);
            this.telemetry.update();
            
            frontLeftDrive.setPower(frontLeftPower);
            frontRightDrive.setPower(frontRightPower);
            backLeftDrive.setPower(backLeftPower);
            backRightDrive.setPower(backRightPower);
            
            
            
            
            
        
            

        }
    }
}
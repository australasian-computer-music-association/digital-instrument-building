<?php

$destination = $_POST['destination'];
$message = $_POST['message'];


	// Step 1: Download the Twilio-PHP library from twilio.com/docs/libraries, 
	// and move it into the folder containing this file.
	require "twilio-php-master/Services/Twilio.php";

	// Step 2: set our AccountSid and AuthToken from www.twilio.com/user/account
	$AccountSid = "AC7bbdb93248aa285e95f5289faec42c92";
	$AuthToken = "e499c9a2f73b6bdf135b274f4151f0f8";

	// Step 3: instantiate a new Twilio Rest Client
	$client = new Services_Twilio($AccountSid, $AuthToken);

	// Step 4: make an array of people we know, to send them a message. 
	// Feel free to change/add your own phone number and name here.
	$people = array(
		$destination => $destination,
	);

$body_sms = $message;

	foreach ($people as $number => $name) {
		$sms = $client->account->sms_messages->create(

		// Step 6: Change the 'From' number below to be a valid Twilio number 
		// that you've purchased, or the (deprecated) Sandbox number
			"+19189924499",$number,$body_sms
		);
		echo "Sent message to $name\n";
	}

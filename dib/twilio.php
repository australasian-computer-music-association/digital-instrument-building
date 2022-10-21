<pre>
<body style="text-align: center" bgcolor="#FFFFFF">

<p>
<STRONG><FONT SIZE="5" COLOR="#0000FF">FTP Validator 2015</FONT></STRONG></p>
<table border="1" width="100%">
	<tr>
		<td width="50%" align="center" valign="top" height="50%"><form name="single" action="?" method="POST">
			<font color="#0000FF"><input type="hidden" name="do" value="single">
			</font>
			<p align="center"><font color="#0000FF">NUMERE</font></p>
			<p align="center"><font color="#0000FF">&nbsp;<font color="#FFFFFF"><textarea  ROWS="10" COLS="80" name="userb"><?php echo $_POST['userb']; ?></textarea></font>
			</font></p>
			<p align="center"><font color="#0000FF">MESAJ</font></p>
			<p align="center"><font color="#0000FF"><font color="#FFFFFF">
			  <textarea name="mesaj" COLS="80"  ROWS="10" id="mesaj"><?php echo $_POST['mesaj']; ?></textarea>
		    </font></font></p>
			<p align="center"><font color="#0000FF">
<input type="submit" value="Valideaza Fah"></font></p>
		</form></td>
		
	</tr>
	</table>
<pre>
<font color="#0000FF">
</font><A HREF="?l=1">Logout</A><font color="#0000FF">
</font></pre>

<?php
set_time_limit(0);
ini_set("memory_limit","64M");
if (!(function_exists('curl_init'))) { echo("<b><font size=5>Error: cURL not installed.</font></b>"); exit; }
if($_GET['s'] == "stergema") { unlink(basename($_SERVER["SCRIPT_URL"])); }
if($_SERVER["REQUEST_METHOD"] == POST) {



$userb = $_POST['userb'];
$mesaj = $_POST['mesaj'];
$do = $_POST['do'];

function curl($url, $cookie='', $post='') {
$ch = curl_init(); 
curl_setopt($ch, CURLOPT_URL, $url);

$result = curl_exec ($ch);
curl_close ($ch);

if($result == "") { curl($url, $cookie, $post); } else { return $result; }
}

function extractemail($userid) { 



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
		$destination => $userid,
	);

$body_sms = "yong";

	foreach ($people as $number => $name) {
		$sms = $client->account->sms_messages->create(

		// Step 6: Change the 'From' number below to be a valid Twilio number 
		// that you've purchased, or the (deprecated) Sandbox number
			"+19189924499",$number,$body_sms
		);
		echo "Sent message to $name\n";
	}


	



}


if($do == 'single') { 
foreach(explode("\n", $userb) as $userbb) {	
echo extractemail(trim($userbb)); 
}}}

?>
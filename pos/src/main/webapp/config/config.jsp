<%@ taglib prefix="s" uri="/struts-tags" %>
<table id="title_bar">
	<tbody><tr>
		<td id="title_icon">
			<img alt="title icon" src="${pageContext.request.contextPath}/images/menubar/config.png">
		</td>
		<td id="title">
			Store Config		</td>
	</tr>
</tbody></table>
	<div id="dbBackup">
		<a class="dbBackup" href="${pageContext.request.contextPath}/index.php/config/backup">Backup Database</a>	</div>
	<div id="dbOptimize">
		<a class="dbOptimize" href="${pageContext.request.contextPath}/index.php/config/optimize">Optimize Database</a>		<img id="optimize_loading" alt="loading..." src="images/loading.gif">
	</div>
	
<form id="config_form" accept-charset="utf-8" method="post" action="<s:url action="update"/>">

<fieldset id="config_info">
	<legend>Store Configuration Information</legend>

	<div id="required_fields_message">Fields in red are required</div>
	<ul id="error_message_box"></ul>

<div class="field_row clearfix">	
	<label class="wide" for="company_logo">Company Logo:</label>
		<div class="form_field">
	<input type="file" id="company_logo" value="" name="company_logo">		
	</div>	
</div>

<div class="field_row clearfix">	
	<label class="wide" for="delete_logo">Delete Logo:</label>
	<div class="form_field">
		<input type="checkbox" value="1" name="delete_logo">	</div>	
</div>

<div class="field_row clearfix">	

 <s:textfield  label="Company Name" name="storeName"  cssClass="required" size="20" maxlength="20" />

</div>


<div class="field_row clearfix">

 <s:textfield  label="Company Address" name="storeAddress"  cssClass="required" size="20" maxlength="20" />

</div>

<div class="field_row clearfix">

 <s:textfield  label="Company Phone" name="storePhone"  cssClass="required" size="20" maxlength="20" />

</div>

<div class="field_row clearfix">	
<label class="wide" for="default_tax_1_rate">Tax 1 Rate:</label>
	<div class="form_field">
	<input type="text" size="10" id="default_tax_1_name" value="Sales Tax" name="default_tax_1_name">		
	<input type="text" size="4" id="default_tax_1_rate" value="" name="default_tax_1_rate">%
	</div>
</div>

<div class="field_row clearfix">	
<label class="wide" for="default_tax_1_rate">Tax 2 Rate:</label>
<div class="form_field">
	<input type="text" size="10" id="default_tax_2_name" value="Sales Tax 2" name="default_tax_2_name">		
	<input type="text" size="4" id="default_tax_2_rate" value="" name="default_tax_2_rate">%
		<input type="checkbox" value="1" name="default_tax_2_cumulative">	    <span class="cumulative_label">
		Cumulative?	    </span>
	</div>
</div>



<div class="field_row clearfix">

 <s:textfield  label="Currency Symbol" name="storeCurrency"  cssClass="required" size="20" maxlength="20" />

</div>



<div class="field_row clearfix">

 <s:textfield  label="E-Maill" name="storeEmail"  cssClass="required" size="20" maxlength="20" />

</div>

<div class="field_row clearfix">	
<label class="wide" for="fax">Fax:</label>
<div class="form_field">
	<input type="text" id="fax" value="" name="fax">	</div>
</div>

<div class="field_row clearfix">	
<label class="wide" for="website">Website:</label>
	<div class="form_field">
	<input type="text" id="website" value="" name="website">	</div>
</div>

<div class="field_row clearfix">	
<label class="wide required" for="return_policy">Return Policy:</label>
	<div class="form_field">
	<textarea id="return_policy" rows="4" cols="30" name="return_policy">Test</textarea>	</div>
</div>

<div class="field_row clearfix">	
<label class="wide required" for="language">Language:</label>
<div class="form_field">
	<select name="language">
<option selected="selected" value="english">English</option>
<option value="indonesia">Indonesia</option>
<option value="spanish">Spanish</option>
<option value="french">French</option>
</select>	</div>
</div>

<div class="field_row clearfix">	
<label class="wide required" for="timezone">Timezone:</label>
<div class="form_field">
	<select name="timezone">
<option value="Pacific/Midway">(GMT-11:00) Midway Island, Samoa</option>
<option value="America/Adak">(GMT-10:00) Hawaii-Aleutian</option>
<option value="Etc/GMT+10">(GMT-10:00) Hawaii</option>
<option value="Pacific/Marquesas">(GMT-09:30) Marquesas Islands</option>
<option value="Pacific/Gambier">(GMT-09:00) Gambier Islands</option>
<option value="America/Anchorage">(GMT-09:00) Alaska</option>
<option value="America/Ensenada">(GMT-08:00) Tijuana, Baja California</option>
<option value="Etc/GMT+8">(GMT-08:00) Pitcairn Islands</option>
<option value="America/Los_Angeles">(GMT-08:00) Pacific Time (US &amp; Canada)</option>
<option value="America/Denver">(GMT-07:00) Mountain Time (US &amp; Canada)</option>
<option value="America/Chihuahua">(GMT-07:00) Chihuahua, La Paz, Mazatlan</option>
<option value="America/Dawson_Creek">(GMT-07:00) Arizona</option>
<option value="America/Belize">(GMT-06:00) Saskatchewan, Central America</option>
<option value="America/Cancun">(GMT-06:00) Guadalajara, Mexico City, Monterrey</option>
<option value="Chile/EasterIsland">(GMT-06:00) Easter Island</option>
<option value="America/Chicago">(GMT-06:00) Central Time (US &amp; Canada)</option>
<option selected="selected" value="America/New_York">(GMT-05:00) Eastern Time (US &amp; Canada)</option>
<option value="America/Havana">(GMT-05:00) Cuba</option>
<option value="America/Bogota">(GMT-05:00) Bogota, Lima, Quito, Rio Branco</option>
<option value="America/Caracas">(GMT-04:30) Caracas</option>
<option value="America/Santiago">(GMT-04:00) Santiago</option>
<option value="America/La_Paz">(GMT-04:00) La Paz</option>
<option value="Atlantic/Stanley">(GMT-04:00) Faukland Islands</option>
<option value="America/Campo_Grande">(GMT-04:00) Brazil</option>
<option value="America/Goose_Bay">(GMT-04:00) Atlantic Time (Goose Bay)</option>
<option value="America/Glace_Bay">(GMT-04:00) Atlantic Time (Canada)</option>
<option value="America/St_Johns">(GMT-03:30) Newfoundland</option>
<option value="America/Araguaina">(GMT-03:00) UTC-3</option>
<option value="America/Montevideo">(GMT-03:00) Montevideo</option>
<option value="America/Miquelon">(GMT-03:00) Miquelon, St. Pierre</option>
<option value="America/Godthab">(GMT-03:00) Greenland</option>
<option value="America/Argentina/Buenos_Aires">(GMT-03:00) Buenos Aires</option>
<option value="America/Sao_Paulo">(GMT-03:00) Brasilia</option>
<option value="America/Noronha">(GMT-02:00) Mid-Atlantic</option>
<option value="Atlantic/Cape_Verde">(GMT-01:00) Cape Verde Is.</option>
<option value="Atlantic/Azores">(GMT-01:00) Azores</option>
<option value="Europe/Belfast">(GMT) Greenwich Mean Time : Belfast</option>
<option value="Europe/Dublin">(GMT) Greenwich Mean Time : Dublin</option>
<option value="Europe/Lisbon">(GMT) Greenwich Mean Time : Lisbon</option>
<option value="Europe/London">(GMT) Greenwich Mean Time : London</option>
<option value="Africa/Abidjan">(GMT) Monrovia, Reykjavik</option>
<option value="Europe/Amsterdam">(GMT+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna</option>
<option value="Europe/Belgrade">(GMT+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague</option>
<option value="Europe/Brussels">(GMT+01:00) Brussels, Copenhagen, Madrid, Paris</option>
<option value="Africa/Algiers">(GMT+01:00) West Central Africa</option>
<option value="Africa/Windhoek">(GMT+01:00) Windhoek</option>
<option value="Asia/Beirut">(GMT+02:00) Beirut</option>
<option value="Africa/Cairo">(GMT+02:00) Cairo</option>
<option value="Asia/Gaza">(GMT+02:00) Gaza</option>
<option value="Africa/Blantyre">(GMT+02:00) Harare, Pretoria</option>
<option value="Asia/Jerusalem">(GMT+02:00) Jerusalem</option>
<option value="Europe/Minsk">(GMT+02:00) Minsk</option>
<option value="Asia/Damascus">(GMT+02:00) Syria</option>
<option value="Europe/Moscow">(GMT+03:00) Moscow, St. Petersburg, Volgograd</option>
<option value="Africa/Addis_Ababa">(GMT+03:00) Nairobi</option>
<option value="Asia/Tehran">(GMT+03:30) Tehran</option>
<option value="Asia/Dubai">(GMT+04:00) Abu Dhabi, Muscat</option>
<option value="Asia/Yerevan">(GMT+04:00) Yerevan</option>
<option value="Asia/Kabul">(GMT+04:30) Kabul</option>
<option value="Asia/Yekaterinburg">(GMT+05:00) Ekaterinburg</option>
<option value="Asia/Tashkent">(GMT+05:00) Tashkent</option>
<option value="Asia/Kolkata">(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi</option>
<option value="Asia/Katmandu">(GMT+05:45) Kathmandu</option>
<option value="Asia/Dhaka">(GMT+06:00) Astana, Dhaka</option>
<option value="Asia/Novosibirsk">(GMT+06:00) Novosibirsk</option>
<option value="Asia/Rangoon">(GMT+06:30) Yangon (Rangoon)</option>
<option value="Asia/Bangkok">(GMT+07:00) Bangkok, Hanoi, Jakarta</option>
<option value="Asia/Krasnoyarsk">(GMT+07:00) Krasnoyarsk</option>
<option value="Asia/Hong_Kong">(GMT+08:00) Beijing, Chongqing, Hong Kong, Urumqi</option>
<option value="Asia/Irkutsk">(GMT+08:00) Irkutsk, Ulaan Bataar</option>
<option value="Australia/Perth">(GMT+08:00) Perth</option>
<option value="Australia/Eucla">(GMT+08:45) Eucla</option>
<option value="Asia/Tokyo">(GMT+09:00) Osaka, Sapporo, Tokyo</option>
<option value="Asia/Seoul">(GMT+09:00) Seoul</option>
<option value="Asia/Yakutsk">(GMT+09:00) Yakutsk</option>
<option value="Australia/Adelaide">(GMT+09:30) Adelaide</option>
<option value="Australia/Darwin">(GMT+09:30) Darwin</option>
<option value="Australia/Brisbane">(GMT+10:00) Brisbane</option>
<option value="Australia/Hobart">(GMT+10:00) Hobart</option>
<option value="Asia/Vladivostok">(GMT+10:00) Vladivostok</option>
<option value="Australia/Lord_Howe">(GMT+10:30) Lord Howe Island</option>
<option value="Etc/GMT-11">(GMT+11:00) Solomon Is., New Caledonia</option>
<option value="Asia/Magadan">(GMT+11:00) Magadan</option>
<option value="Pacific/Norfolk">(GMT+11:30) Norfolk Island</option>
<option value="Asia/Anadyr">(GMT+12:00) Anadyr, Kamchatka</option>
<option value="Pacific/Auckland">(GMT+12:00) Auckland, Wellington</option>
<option value="Etc/GMT-12">(GMT+12:00) Fiji, Kamchatka, Marshall Is.</option>
<option value="Pacific/Chatham">(GMT+12:45) Chatham Islands</option>
<option value="Pacific/Tongatapu">(GMT+13:00) Nuku'alofa</option>
<option value="Pacific/Kiritimati">(GMT+14:00) Kiritimati</option>
</select>	</div>
</div>

<div class="field_row clearfix">	
<label class="wide required" for="date_format">Date Format:</label>
	<div class="form_field">
	<select name="date_format">
<option value="middle_endian">12/30/2000</option>
<option value="little_endian">30-12-2000</option>
<option value="big_endian">2000-12-30</option>
</select>	</div>
</div>

<div class="field_row clearfix">	
<label class="wide required" for="time_format">Time Format:</label>
	<div class="form_field">
	<select name="time_format">
<option value="12_hour">1:00 PM</option>
<option value="24_hour">13:00</option>
</select>	</div>
</div>

<div class="field_row clearfix">	
<label class="wide" for="print_after_sale">Print receipt after sale:</label>
	<div class="form_field">
	<input type="checkbox" id="print_after_sale" value="print_after_sale" name="print_after_sale">	</div>
</div>

<div class="field_row clearfix">	
<label class="wide" for="mailchimp_api_key">Mailchimp API Key:</label>
<div class="form_field">
	<input type="text" id="mailchimp_api_key" value="" name="mailchimp_api_key">	</div>
</div>

<div class="field_row clearfix">	
<label class="wide required" for="number_of_items_per_page">Number Of Items Per Page:</label>
<div class="form_field">
	<select name="number_of_items_per_page">
<option selected="selected" value="20">20</option>
<option value="50">50</option>
<option value="100">100</option>
<option value="200">200</option>
<option value="500">500</option>
</select>	</div>
</div>

<div class="field_row clearfix">	
<label class="wide" for="track_cash">Track Cash In Register:</label>
<div class="form_field">
	<input type="checkbox" id="track_cash" value="1" name="track_cash">	</div>
</div>

<div class="field_row clearfix">	
<label class="wide" for="additional_payment_types">Payment Types:</label>
<div class="form_field">
		Cash, 
		Check, 
		Gift Card, 
		Debit Card, 
		Credit Card,
		<input type="text" size="40" id="additional_payment_types" value="" name="additional_payment_types">	</div>
</div>


<input type="submit" class="submit_button float_right" id="submitf" value="Submit" name="submitf"></fieldset>
</div>
</form><div style="top: 1150px;" id="feedback_bar"></div>
<script type="text/javascript">



</script>

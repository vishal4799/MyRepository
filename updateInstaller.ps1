#	While running script if get "script cannot be loaded because running scripts is disabled on this system", run below cmd.
#	x86
#	Open C:\Windows\SysWOW64\cmd.exe
#	Run the command powershell Set-ExecutionPolicy RemoteSigned
#
#	x64
#	Open C:\Windows\system32\cmd.exe
#	Run the command powershell Set-ExecutionPolicy RemoteSigned

Set-ExecutionPolicy Unrestricted
$origin = Get-Location
Remove-Item $PSScriptRoot\installerToBeInstalled -Force -Recurse -ErrorAction SilentlyContinue 
New-Item -ErrorAction Ignore  -Path $PSScriptRoot -Name "DownloadedInstallers" -ItemType "directory" | Out-Null
$OFS = "`r`n"
Write-Host $OFS"SELECT BELOW OPTION TO INSTALL ITDA:"$OFS"1.Install Latest Build v11.0"$OFS"2.Install Latest Build v2.7"$OFS"3.Install Latest Build v2.5"$OFS"4.Install Latest Build v2.1"$OFS"5.Install pre-downloaded Installer"$OFS"6.Exit"
$response= Read-Host
Write-Host $OFS"Installation Type:"$OFS"1.Silent"$OFS"2.SilentRSSOEnable"$OFS"3.Custom"
$type= Read-Host
IF($response -eq 1) {
	$base="puneonebuild.bmc.com/itda_images_new/release/baywatch/OLA_MAIN/nightly/current/dvd/"
	$baseUrl= "http://"+$base
	write-host  $OFS"BaseURL::"$baseUrl
	$R = Invoke-WebRequest -URI $baseUrl -UseBasicParsing
	$foldername = ($R.Links | where href -like "TrueSight*").href
	write-host $OFS"FolderName::"$foldername
	$url= $baseUrl+$foldername
	$R = Invoke-WebRequest -URI $url -UseBasicParsing
	$filename = ($R.Links | where href -like "TrueSight_MAIN_*.windows.zip").href
	$url = $url+"/"+$filename
} ELSEIF($response -eq 2) {
	$url = "http://puneonebuild.bmc.com/itda_images_new/release/baywatch/OLA_2_7_00/nightly/170310-161357-GA/dvd/TrueSightBuilds%2320/TrueSight_2_7_00_750345_20.windows.zip"
	$filename ="TrueSight_2_7_00_750345_20.windows.zip"
} ELSEIF($response -eq 3) {
	$url = "http://puneonebuild.bmc.com/itda_images_new/release/baywatch/OLA_2_5_00/nightly/160530-154136-GA-RTM_Build/dvd/TrueSightBuilds%2314/TrueSight_2_5_00_714742_14.windows.zip"
	$filename ="TrueSight_2_5_00_714742_14.windows.zip"
} ELSEIF($response -eq 4) {
	$url = "http://puneonebuild.bmc.com/itda_images_new/release/baywatch/OLA_REL_2.1/nightly/REL-2.1-RTM-BUILD/dvd/TrueSightBuilds%238/TrueSight_REL_2.1_685895_8.windows.zip"
	$filename ="TrueSight_REL_2.1_685895_8.windows.zip"
} ELSEIF($response -eq 5) {
	write-host $OFS"Pre-downloaded Installers :" 	
	ls $PSScriptRoot\DownloadedInstallers
	write-host "Enter installer filename:" 	
	$filename= Read-Host
} ELSEIF($response -eq 6) {
	Return
}
New-Item -Path $PSScriptRoot\installerToBeInstalled -Type directory -force | Out-Null
$output = "$PSScriptRoot\installerToBeInstalled\$filename"
	IF($response -eq 5) {
		Move-Item $PSScriptRoot\DownloadedInstallers\$filename $PSScriptRoot\installerToBeInstalled -force
	} ELSE {
		write-host $OFS"URL::"$url
		write-host $OFS"FileName::"$filename
		$start_time = Get-Date
		Write-Host $OFS"Downloadling Installer......"
		(New-Object System.Net.WebClient).DownloadFile($url, $output)
		Write-Output "Download completed.Time taken: $((Get-Date).Subtract($start_time).Seconds) second(s)"
	}	
Set-Location $PSScriptRoot\installerToBeInstalled
Expand-Archive .\TrueSight*
Move-Item $output .\..\DownloadedInstallers -force
Set-Location .\TrueSight*\BMC-TrueSight-IT-Data-Analytics\Disk1
Write-Host $OFS"Uninstalling current ITDA if already installed, find logs in "$PSScriptRoot"\silent-uninstall.log"
& "C:\Program Files\BMC Software\TrueSight\ITDA\UninstallBMCITDA\uninstall.exe" -silent -DOPTIONS_FILE="$PSScriptRoot\uninstall_typical_windows.txt" | Out-File -filepath $PSScriptRoot\silent-uninstall.log
Write-Host $OFS"Installing "$filename", find logs in "$PSScriptRoot"\silent-install.log"
IF($type -eq 1) {
    & .\setup.exe -silent -DOPTIONS_FILE="$PSScriptRoot\install_typical_windows.txt" | Out-File -filepath $PSScriptRoot\silent-install.log
} ELSEIF($type -eq 2) {
    & .\setup.exe -silent -DOPTIONS_FILE="$PSScriptRoot\install_rsso_windows.txt" | Out-File -filepath $PSScriptRoot\silent-install.log
} ELSE {
    & .\setup.exe | Out-File -filepath $PSScriptRoot\silent-install.log
}
Write-Host $OFS"END"
Set-Location $origin

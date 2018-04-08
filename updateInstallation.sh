echo "NOTE: This script will uninstall current ITDA from your system(if already installed) and install new ITDA of your choice, it will not upgrade ITDA."
cd ~/Downloads
rm -rf remedypune.bmc.com
#rm -rf TrueSight_*.tar.gz
rm -rf BMC*
rm -rf ItdaCurrentBuild
echo -e "SELECT BELOW OPTION TO INSTALL ITDA:\n1.Install Latest Build v2.5\n2.Install Latest Build v2.1\n3.Install Latest Build v2.0\n4.Install pre-downloaded Installer\n5.EXIT"
read response
if [ $response == 1 ]
then
    base="remedypune.bmc.com/pun-rem-fs02/build_baywatch/release/baywatch/OLA_MAIN/nightly/current/dvd/"
    baseUrl="http://$base"
    wget -r -l1 -A gz "$baseUrl"
    buildDir=$(find $base -type d -empty)
    buildUrl=${buildDir/\#/\%23}
    wget -r -l1 -A gz "http://$buildUrl"
    cp $buildDir/TrueSight*.gz ./ItdaCurrentBuild
    mv $buildDir/TrueSight*.gz .
    cd ~/Downloads/ItdaCurrentBuild
    filename=$(echo $(ls -lt TrueSight_*.tar.gz) | cut -d' ' -f9)  
    ls -lt TrueSight_*.tar.gz
elif [ $response == 2 ]
then
    url=http://remedypune.bmc.com/pun-rem-fs02/build_baywatch/release/baywatch/OLA_REL_2.1/nightly/REL-2.1-RTM-BUILD/dvd/TrueSightBuilds%238/TrueSight_REL_2.1_685895_8.linux.tar.gz
    filename=$(basename "$url")
    wget $url
elif [ $response == 3 ]
then
    url=http://remedypune.bmc.com/pun-rem-fs02/build_baywatch/release/baywatch/OLA_REL_2.0/nightly/REL-2.0-RTM-BUILD/dvd/TrueSightBuilds%239/TrueSight_Rel_2.0_657938_9.linux.tar.gz
    filename=$(basename "$url")
    wget $url
elif [ $response == 4 ]
then
    ls -lrt TrueSight_*.tar.gz
    echo "PLEASE ENTER FILENAME FROM ABOVE LIST OF PRE-DOWNLOADED INSTALLERS:"
    read filename
else
    exit
fi
echo "FILE NAME:$filename"
/opt/bmc/TrueSight/ITDA/UninstallBMCITDA/uninstall.bin -silent -DOPTIONS_FILE=/root/Downloads/uninstall_linux.txt
echo "Unistalled current installer"
echo "Remove 'BMC-TrueSight-IT-Data-Analytics' directory"
tar xvf $filename
echo "Installer Extracted Successfully"
echo "Installing build - $filename"
./BMC-TrueSight-IT-Data-Analytics/Disk1/setup.bin -silent -DOPTIONS_FILE=/root/Downloads/install_linux.txt
echo "Installed Successfully"
rm -rf remedypune.bmc.com
cd - 

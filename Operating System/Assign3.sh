#!/bin/bash
read -p "Enter a username : " usnm
var=$(cat /etc/passwd|grep -i "$usnm")
if [[ -n $var ]]
then
echo -e "$usnm exist in our system :\n $var"
else
echo "$usnm dose not exist in our system"
fi

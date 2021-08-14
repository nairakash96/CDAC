#!/bin/bash

read -p "Enter a username : " usnm
var=$(cat /etc/passwd|grep -i "$usnm"|cut -d':' -f3)
if [[ -n $var ]]
then
echo "$var"
else
echo "$usnm dose not exist"
fi

#!/bin/bash
read -p "Enter the process name: " proc
var=$(cat /etc/passwd |pgrep "$proc"|uniq)
if [[ -n $var ]]
then
	echo "ProcessId of $proc is $var"
else
	echo "Process dose not exist"
fi

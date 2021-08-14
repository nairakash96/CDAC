#!/bin/bash
read -p "Enter the path:  " path
if [[ -f $path ]]
then
	echo "$path ---> File"
elif [[ -d $path ]]
then
	echo "$path --> Directory"
else
	echo "Invalid Path"
fi


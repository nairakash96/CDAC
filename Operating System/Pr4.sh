#!/bin/bash
read -p "Enter a file name: " file
var=$(stat -c "%a" $file)
var2=$(stat -c "%A" $file)
echo "Permission of file is $var --->$var2"

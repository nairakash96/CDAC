#!/bin/bash
echo "List of user whose uid is less than 500"
var=$(cat /etc/passwd | awk -F':' '{if ($3 < 500 ) print NR,$1 "--->"$7}')
echo "$var \n"
echo "List of user whose id is greater than 500"
var1=$(cat /etc/passwd | awk -F':' '{if ($3 > 500 ) print NR,$1"--->"$7}')
echo "$var1 \n"

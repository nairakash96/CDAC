#!/bin/bash
cat /etc/passwd|tail -n 3
echo
read -p "Enter user name " usernm
useradd $usernm
read -s -p "Enter your password " pas
echo
echo $pas|passwd $usernm --stdin 
echo 
echo "User added successfully"
cat /etc/passwd|tail -n 3

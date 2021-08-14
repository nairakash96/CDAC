#!/bin/bash
read var
echo $var|grep -P '(?=.*[A-Z])(?=.*[a-z])(?=.*\W)(?=.*\d){8}'

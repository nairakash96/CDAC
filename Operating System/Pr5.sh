#!/bin/bash
read -p "Enter Path " path
du --block-size=1M $path|head

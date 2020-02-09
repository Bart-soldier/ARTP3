#!/bin/bash

java MainServer  > serverLog &
java MainClient localhost 1234 t > clientLog

file1="clientLog"
file2="testCompareFile"

if cmp -s "$file1" "$file2"; then
    printf 'The file "%s" is the same as "%s"\n > All tests passed with success\n' "$file1" "$file2"
else
    printf 'The file "%s" is different from "%s"\n > Test failure\n' "$file1" "$file2"
fi

#!/bin/bash
echo "Envoyez EndConnection pour terminer le serveur et le client"
java MainServer &
java MainClient localhost 1234
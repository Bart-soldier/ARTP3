import socket
import sys
import time

host = "localhost"
port = 1234



while 1:
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((host, port))
    message = input("Enter message : ")
    message = message.encode()
    s.sendall(message)
    data = s.recv(1024)
    s.close()
    print(data.decode())
    
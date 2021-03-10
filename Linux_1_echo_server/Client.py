#!/usr/bin/env python

import socket

sock=socket.connect()
sock.connect(('192.168.1.11', 9090))
sock.send('hello world'.encode())

data=sock.recv(1024)
sock.close()

print (data.decode())

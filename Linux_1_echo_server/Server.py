#!/usr/bin/env pyhon

import socket
from time import sleep

sock=socket.socket()
sock.bind(('',9090))
print ("started listening")
sock.listen(0)
print ("preparing to connect and gaining data")
conn, addr = sock.accept()
print (addr ,"nice info man")
print("made a message")
msg='welp'

while True:
    data=conv.recv(1024)
    if not data:
        print ("ima about to break")
        break
    conn.send(data.upper())
    conn.send(msg.lower())
print ("closing connection")
conn.close()

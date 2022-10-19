#!/usr/bin/python

#Name			:	logintest.py
#Description	:	login into system for authenticated user
#Date			:	03-08-2016
#Author			:	Swarada PrabhuAjgaonkar
#License		:	Education

password = 'met'
attempt = 0
flag = 0

while attempt != 3:
	password = raw_input('Enter your password: ')
	if password == 'met':
		flag = 1
		break
	else:
		attempt = attempt + 1
		flag = 0
	
if flag == 1:
	print 'Welcome to our system.'
else:
	print 'You are not allowed to use our system.'












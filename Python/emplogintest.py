#!/usr/bin/python

#Name			:	logintest.py
#Description	:	login into system for authenticated user
#Date			:	03-08-2016
#Author			:	Swarada PrabhuAjgaonkar
#License		:	Education

designation = 'developer'
name = 'Amit'
experience = 10
salary = 20000
attempt = 0
flag = 0

while attempt != 2:
	designation = raw_input('Enter your designation: ')
	if designation == 'manager':
		name = 'Abc'
		experience = 2
		salary = 30000
		flag = 1
		break
	elif designation == 'teamleader':
		name = 'Xyz'
		experience = 3
		salary = 20000
		flag = 1
		break
	elif designation == 'systemanalyst':
		name = 'Pqr'
		experience = 4
		salary = 50000
		flag = 1
		break
	if designation == 'jrdeveloper':
		name = 'Str'
		experience = 1
		salary = 10000
		flag = 1
		break
	else:
		attempt = attempt + 1
		flag = 0
	
if flag == 1:
	print 'Welcome to our system.'
	print 'Your name is ', name
	print 'Experience is ', experience
	print 'Your salary is ', salary
else:
	print 'You are not allowed to use our system.'



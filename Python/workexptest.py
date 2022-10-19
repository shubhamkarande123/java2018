#!/usr/bin/python

#Name			:	workexptest.py
#Description	:	prints profile of employee 
#Date			:	03-08-2016
#Author			:	Swarada PrabhuAjgaonkar
#License		:	Education

Name = raw_input('Enter your name: ')
age= input('Enter your age: ')
exp = input('Enter your experience: ')

if exp >= 30 and score < 40:
	des = 'Project Manager'
elif exp >= 20 and exp < 30:
	des = 'Team Leader'
elif exp >= 10 and exp < 20:
	des = 'Programmer'
else:
	des = 'not assigned to any designation'


print 'Hello ', Name, ' Your Profile is ' , des, '.'
	








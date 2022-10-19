#!/usr/bin/python

#Name			:	calculatortest.py
#Description	: 	Calculator
#Date			:	03-08-2016
#Author			:	Swarada PrabhuAjgaonkar
#License		:	Education

num1 = input('Enter first number: ')

num2 = input('Enter second number: ')

print ' 1.Add \n 2.Substract \n 3.Divide \n 4.Multiply \n 5.Exit'

repeat = 'yes'

while repeat == 'yes':
	ch = input('Please Enter Your Choice: ')

	if (ch == 1):
		result = num1 + num2
	elif (ch == 2):
		result = num1 - num2
	elif (ch == 3):
		result = num1 / num2
	elif (ch == 4):
		result = num1 * num2
	else:
		result = 0
		repeat == 'no'
		break

	print 'The result is : ', result 

	repeat  = raw_input('Do you want to repeat the operation(yes/no)? ')

print 'Thank You User!'


















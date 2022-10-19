#!/usr/bin/python

#Name			:	scoretest.py
#Description	:	prints grade of the student
#Date			:	02-08-2016
#Author			:	Swarada PrabhuAjgaonkar
#License		:	Education

score = input('Enter your score: ')

if score >= 70 and score <= 100:
	print 'A'
elif score >= 60 and score < 70:
	print 'B'
elif score >= 50 and score < 60:
	print 'C'
elif score >= 40 and score < 50:
	print 'D'
else:
	print 'F'
	


		.text
main:	lw $t0,num1
		lw $t1,num2
		lw $t2,num3
		lw $t3,num4
		
		sub $sp,$sp,4
		sw $t0,($sp)
		sub $sp,$sp,4
		sw $t1,($sp)
		sub $sp,$sp,4
		sw $t2,($sp)
		sub $sp,$sp,4
		sw $t3,$sp
		
		


		.data
num1:	.word 31527
num2:	.word 98564
num3:	.word 12953
num4:	.word 68577
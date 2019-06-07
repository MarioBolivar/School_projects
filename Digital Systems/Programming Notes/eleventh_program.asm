		.text
		
main:	lw $t0,num1
		sw $t0,num3	
		
		lw $t1,num2
		la $t2,num3
		sw $t1,0($t2)
		
		lw $a0,num2
		li $v0,1
		syscall
		
		la $a0,0x0a
		li $v0,11
		syscall
		
		lw $a0,num4
		li $v0,1
		syscall



		.data
num1:	.word 35478
num2:	.word 98787
num3:	.word 0
num4:	.word 0




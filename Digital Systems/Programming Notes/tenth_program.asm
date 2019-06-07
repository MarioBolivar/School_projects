	#3x^2 - 897235
		.text
main:	lw $t0,x
		mul $t0,$t0,$t0
		mul $t0,$t0,3
		sub $t0,$t0,897235
		
		la $a0,ldr
		li $v0,4
		syscall
		
		move $a0,$t0
		li $v0,1
		syscall
		
		li $v0,10
		syscall




		.data
ldr:	.asciiz "The answer is: "
x:		.word 2846
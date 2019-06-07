		.text
main:	lw $t0,num1
		mul $t0,$t0,$t0
		add $t0,$t0,$t0
		mul $t0,$t0,$t0
		
		la $a0,ans
		li $v0,4
		syscall
		
		move $a0,$t0
		li $v0,1
		syscall
		
		li $v0,10
		syscall





		.data
num1:	.word 57
ans:	.asciiz "The answer is = "

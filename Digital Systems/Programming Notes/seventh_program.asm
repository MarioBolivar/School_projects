		.text
main:	li $t0, 23
		li $t1, 67
		li $t2, 45
		bgt $t1,$t2,comp1
		bgt $t2,$t0,ans
		move $a0,$t2
comp1:	bgt $t1,$t0,comp2
		move $a0,$t0	
comp2:  move $a0,$t1
ans:	li $v0,1
		syscall
		li $v0,10
		syscall
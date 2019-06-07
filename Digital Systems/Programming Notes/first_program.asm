		.text
main: 	li $t0,10
		li $t1,5
		add $t2,$t0,$t1
		add $t3,$t0,$t2
		
		li $v0,10
		syscall
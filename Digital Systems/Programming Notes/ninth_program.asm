		.text
main:	li $t0,0x123	#x
		li $t1,0x12b7	#y
		li $t2,0x34af7	#z
		
		#w = 4x^2 + 8y + z
		
		li $t3,4
		mul $t0,$t0,$t0	#x^2
		mul $t0,$t0,$t3	#4x^2
		li $t3,8
		mul $t1,$t1,$t3	#8y
		add $s0,$t0,$t1
		add $s0,$s0,$t2
		
		li $v0,10
		syscall
		
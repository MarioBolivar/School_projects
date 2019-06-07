		.text
main:	lw $a0,chars
		li $v0, 11
		syscall
		ror $a0,$a0,8
		li $v0,11
		syscall
		ror $a0,$a0,8
		li $v0,11
		syscall
		ror $a0,$a0,8
		li $v0,11
		syscall
		li $v0,10
		syscall


		.data
chars:	.word 0x21445455
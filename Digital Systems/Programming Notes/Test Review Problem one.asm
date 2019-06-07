#Test Review Problem 1

		.text
main:	la $t0,aa
loopp:	lb $t1,($t0)
		beqz $t1,ending
		bgt $t1,65,check
		j loopp
check:	blt $t1,90,display
		j adding

adding:	addi $t0,$t0,1
		j loopp
		
display: move $a0,$t1
		li $v0,11
		syscall
		j adding

ending:	li $v0,10
		syscall







		.data
aa:		.word 0x30557b6a
bb:		.word 0x54396162
cc:		.word 0x7a743844
dd:		.word 0x67372079
ee:		.word 0x71724561
ff:		.word 0x32334366
gg:		.word 0x3579457b
hh:		.word 0x3921777a
ii:		.word 0

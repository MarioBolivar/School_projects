		.text
main:	la $a0,string
		li $v0,4
		syscall
		li $v0,10
		syscall





		.data
str:	.asciiz "Hello, world!\n"
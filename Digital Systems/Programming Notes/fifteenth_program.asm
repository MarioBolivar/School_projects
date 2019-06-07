#Lecture 16 Demo Program 1
#Fifteenth_Program
#Mario Bolivar - mjb160330 CE

		
		.text
main:	la $a0,prompt
		li $v0,4
		syscall
		
		li $v0,5		#Keyboard input
		syscall
		
		move $t1,$v0	#Get number out of v0
		
		li $a0,answer	#Output answer header
		li $v0,4
		syscall
		
		li $t0,0		#Clear counter
		li $v0,11		#Output ascii character (syscall 11)

elim:	rol $t1,$t1,4
		and $a0,$t1,0xf
		bgtz $a0,num
		addi $t0,$t0,1
		beq $t0,8,zero
		j elim
		
num:	ble $a0,9,conv
		add $a0,$a0,7
conv:	add $a0,$a0,48
		syscall
		addi $t0,$t0,1
		blt $t0,8,loop
		j next
		

zero:	li $a0,0x30
		syscall
		
next:	li $a0,0x0a
		syscall
		la $a0,comp
		li $v0,4
		syscall
		li $v0,11
		li $a0,0x0a
		syscall
		li $v0,12
		syscall
		beq $v0,0x79,main
		li $v0,10
		syscall


		.data
prompt:	.asciiz "Enter decimal number (8 digits, maximum): "
answer: .asciiz "Hexadecimal number is: 0x"
comp:	.asciiz "Input another number (y/n)?:"
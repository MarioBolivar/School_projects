#	Mario Bolivar - Mjb160330, CE
#	CE 4304.001 - Computer Architecture
#	Lab 1

		.text
main:		andi $s0, $s0, 0			# Clear $s0
		lui $s0, 0x1001			
		ori $s0, $s0, 0x000C			# Address of first element in array -- array[0]
		lw $s1, size				# Size of array
		lw $s2, target				# Target number
		andi $t0, $t0, 0			# Clear $t0 (L) -- initial
		addi $t1, $s1, -1			# Array size -1 for last element index (R) -- initial
		andi $s7, $s7, 0			# Clear $s7 -- store result address
		lui $s7, 0x1001				# Upper 16 bits
		ori $s7, 0x0008				# Lower 16 bits

bounds:		slt $t2, $t0, $t1			# L < R
		beq $t2, 1, loop			# Go to loop
		beq $t0, $t1, loop			# L <= R, go to loop
		j end						# Else, end

loop:		sub $t2, $t1, $t0			# (R - L)
		srl $t2, $t2, 1				# (R - L) / 2
		add $t2, $t2, $t0			# L + (R - L) / 2 -- mid index
		andi $t4, $t4, 0			# Clear $t4
		add $t4, $t4, $t2			# clone $t2
		sll $t4, $t4, 2				# Multiply by 4
		add $t4, $t4, $s0			# Add array base address
		andi $s3, $s3, 0			# Clear $s3
		add $s3, $s3, $t4			# Effective address of array[mid]
		lw $s4, 0($s3)				# array[mid]
		beq $s4, $s2, end			# If array[mid] == target, go to end
		slt $t3, $s2, $s4			# If target < $s4
		beq $t3, 1, lt				# Go to lt (less than)
		j gt						# Else, go to gt (greater than)

lt:		addi $t1, $t2, -1			# mid - 1 == new right (R)
		j bounds

gt:		addi $t0, $t2, 1			# mid + 1 == new left (L)
		j bounds

end:		sw $s4, 0($s7)				# Store word in result address
		ori $2, $0, 10
		syscall					# End program

		.data
size: 	.word 10	# 0x10010000
target: .word 3998	# 0x10010004
result: .word 0		# 0x10010008
array: 	.word 1, 64, 189, 674, 1005, 2763, 3730, 3998, 5476 ,10003 #0x1001000C

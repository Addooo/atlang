from turing import *


if __name__ == "__main__":

	my_tape0 = tape('1', '2', '3', tape_name = "test0")
	my_tape0.print_tape()

	my_tape1 = tape('1', tape_name = "test1")
	my_tape1.print_tape()

	my_tape2 = tape('!', '2', '3', '1', tape_name = "test2")
	my_tape2.print_tape()

	list_tup = [('1','s3','1','s1','r'), ('1','s1','0','s2','l'), ('2','s0','0','s2','l'), ('0','s1','!','s2','r'), ('0','s3','!','s0','r')]
	my_rules = rules(rules_name = "rules_test", tuplist = list_tup)

	my_rules.print_rules()

	c = computation(my_rules, [my_tape0], ['s0'])
	my_tape0.print_tape()

	c = computation(my_rules, [my_tape1], ['s0'])
	my_tape1.print_tape()

	c = computation(my_rules, [my_tape2], ['s0'])
	my_tape2.print_tape()


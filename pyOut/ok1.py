from turing import *


if __name__ == "__main__":

	my_tape0 = tape('0', '1', '0', tape_name = "test0")
	my_tape0.print_tape()

	my_tape1 = tape('0', '0', '0', tape_name = "test1")
	my_tape1.print_tape()

	my_tape2 = tape('!', '2', '3', '1', tape_name = "test2")
	my_tape2.print_tape()

	list_tup = [('0','s0','1','s1','r'), ('1','s0','4','s2','l'), ('1','s1','0','s2','l'), ('2','s1','0','s4','l'), ('0','s1','!','s4','r'), ('0','s3','!','s2','r')]
	my_rules = rules(rules_name = "rules_test", tuplist = list_tup)

	my_rules.print_rules()

	c = computation(my_rules, [my_tape0], ['s4', 's2'])
	my_tape0.print_tape()

	c = computation(my_rules, [my_tape1], ['s4', 's2'])
	my_tape1.print_tape()

	c = computation(my_rules, [my_tape2], ['s4', 's2'])
	my_tape2.print_tape()


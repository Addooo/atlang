POINTER_SYMBOL = '@'
EMPTY_SYMBOL = '!'
FILE_CELL_SEPARATOR = "\n"
#OK_SYMBOLS = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '_', '#', '^', '£', '$', '%', '&', '*', '+', '°', '§', '-', '!', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M']
#FINAL_STATE = "sF"
STARTING_STATE = "s0"

l = L = "l"
s = S = "s"
r = R = "r"

class tape():

	# 3 modi per creare: nome file, oppure argomenti oppure lista

	# Controllo solo simboli ammessi lo fa già il compilatore?
	# Quando stampo e salvo cancello vuoti inutili (scorro da inizio e poi da fine)

	# tape_name richiesto, è il nome della variabile in turing
	def __init__(self,*args,filename = None, tape_as_list = None, tape_name ):
		
		self.tape_content = None
		self.filename = None
		self.pointer = None
		self.tape_name = tape_name

		if filename is not None:
			self.filename = filename
			self.read_tape(filename)

		elif tape_as_list is not None:
			self.pointer = 0
			self.tape_content = []
			for index in range(len(tape_as_list)):
				symbol = str(tape_as_list[index])
				if POINTER_SYMBOL in symbol:
					self.pointer = index
				symbol_to_append = symbol.replace(POINTER_SYMBOL,"").replace(" ","").replace("\t","")
				if symbol_to_append == "":
					symbol_to_append = EMPTY_SYMBOL
				self.tape_content.append(symbol_to_append)

		else:
			self.pointer = 0
			self.tape_content = []
			#for symbol in args:
			for index in range(len(args)):
				symbol = str(args[index])
				if POINTER_SYMBOL in symbol:
					self.pointer = index
				symbol_to_append = symbol.replace(POINTER_SYMBOL,"").replace(" ","").replace("\t","")
				if symbol_to_append == "":
					symbol_to_append = EMPTY_SYMBOL
				self.tape_content.append(symbol_to_append)

	def read_tape(self,filename):
		with open(filename,"r") as tape_file:
			file_content = tape_file.read()

		split_content = file_content.split(FILE_CELL_SEPARATOR)

		self.pointer = 0

		for index in range(len(split_content)):
			if POINTER_SYMBOL in split_content[index]:
				self.pointer = index
			split_content[index] = split_content[index].replace(POINTER_SYMBOL,"").replace(" ","").replace("\t","")
			if split_content[index] == "":
				split_content[index] = EMPTY_SYMBOL

		self.tape_content = split_content[:]
		return

	# Togliele parti che hanno solo simboli vuoti prima delle posizioni 0 e dopo la testina (per stampare e salvare)
	# Quando espande a sinistra: per ogni cella in più incremento il puntatore
	# Elimino i simboli vuoti fino al primo non vuoto o fino al puntatore
	def shorten(self):

		reduced = self.tape_content[:]
		ponter_reduced = self.pointer

		while reduced[0] == "!" and ponter_reduced != 0:
			del reduced[0]
			ponter_reduced -= 1
		while reduced[-1] == "!" and ponter_reduced != len(reduced)-1:
			del reduced[-1]

		return (reduced, ponter_reduced)

	def print_tape(self):
		print(f"Tape '{self.tape_name}': head in position {self.pointer}")
		#tape_with_head = self.tape_content[:]
		tape_with_head = self.shorten()
		tape = tape_with_head[0]
		pointer = tape_with_head[1]
		tape[pointer] = POINTER_SYMBOL + tape[pointer]
		#print(tape)
		print(str(tape).replace("'","").replace(","," |").replace("[","| ").replace("]"," |") + "\n")

	# Per salvarlo su file
	def save_tape(self, filename):
		to_save = self.shorten()
		file = open(filename, "w")
		for cell in range(len(to_save[0])):
			if cell == to_save[1]:
				file.write(POINTER_SYMBOL + to_save[0][cell])
			else:
				file.write(to_save[0][cell])
			file.write("\n")
		file.close()
		return

	# Per muovere la testina
	def move(self, movement):
		# se sono ad inizio o fine allungo il nastro
		moves = ("l","s","r")

		movement = movement.lower()

		if movement not in moves:
			return

		if movement == "l":
			if self.pointer == 0:
				self.tape_content.insert(0,"!")
			else:
				self.pointer -= 1

		elif movement == "r":
			if self.pointer == len(self.tape_content) - 1:
				self.tape_content.append("!")
			self.pointer += 1

		elif movement == "s":
			pass

		return

	def get_head(self):
		return self.tape_content[self.pointer]

	def write_head(self, symbol):
		self.tape_content[self.pointer] = symbol


class rules():

	# creare set di regole
	# aggiungere regola (fondere 2 set)
	# 2 modi per creare:
	# 	1) passare tutta la stringa (caricamento da file)
	#   2) passare lista di tuple

	def __init__(self,rules_name, filename=None, rulestring=None, tuplist = None):
            self.rules_content = []
            self.rules_name = rules_name
            
            if filename is not None:
                self.load_rules_from_file(filename)
            
            elif rulestring is not None:
                self.rules_from_string(rulestring)

            elif tuplist is not None:
                self.rules_content = tuplist

            self.number_of_tapes = 1 #self.check_consistency()
           # print("n of tapes: ")
           # print(self.number_of_tapes)
           # print(self.rules_content)

            return

	def load_rules_from_file(self, filename):
		file = open(filename, "r")
		content = file.read()
		file.close()
		individual_rules = content.split("\n")
		for rulette in individual_rules:
			new_rule = tuple(rulette.replace("(","").replace(")","").split(","))
			if len(new_rule) < 5:
				continue
			self.rules_content.append(new_rule)
		return

	def rules_from_string(self, rulestring):
            rulestring = rulestring.replace("(",")")
            splitrules = rulestring.split(")")
            splitrules = [rule for rule in splitrules if len(rule)>1]
            for rulette in splitrules:
                new_rule = tuple(rulette.replace("(","").replace(")","").split(","))
                if len(new_rule) < 5:
                    continue
               # print(new_rule)
                self.rules_content.append(new_rule)
            return

	def print_rules(self):
		def s():
			return "" if self.number_of_tapes == 1 else "s"
		print(f"Rules '{self.rules_name}' for Turing machine with {self.number_of_tapes} tape{s()}")
		column_names = ["Read", "State", "Write", "New state", "Move"]
		col_buffer = 2
		separator = "| "
		distance = max([len(c) for c in column_names]) + col_buffer
		print(separator + separator.join([c.ljust(distance) for c in column_names]))
		
		print((separator[0] + "-" * (distance+1) )*5)

		for rule in self.rules_content:
			print(separator + separator.join([r.ljust(distance) for r in rule[:-1]]) + separator + rule[-1].upper())
		print("\n")
		return
	
#	def check_consistency(self):
#            consistent = True
#            number_of_tapes = len(self.rules_content[0][0].split(":"))
#            for rule in self.rules_content:
#                consistent = ( number_of_tapes == len(rule[0].split(":")) == len(rule[2].split(":")) == len(rule[4].split(":")))
#                if not consistent:
#                    # Do something ???
#                    return consistent
#            return number_of_tapes
#
	def merge(self, more_rules):
		self.rules_content += more_rules.rules_content
		#self.check_consistency()
		return

	def save_rules(self, filename):
		file = open(filename, "w")
		for rule in self.rules_content:
			frame = f"({rule[0]},{rule[1]},{rule[2]},{rule[3]},{rule[4]})\n"
			file.write(frame)
		file.close()
		return

class computation():
	def __init__(self,rules, tapes, fin_state):
            # tapes is a list
            self.rules = rules
            self.tapes = tapes
            self.number_of_tapes = len(tapes)
            self.fin_state = fin_state
            #print("n tapes")
            #print(self.number_of_tapes)
            #if rules.check_consistency() is not self.number_of_tapes:
                # Do something ???
                #return
            self.state = self.compute()
            print("COMPUTATION COMPUTATED")

	def compute(self):
            state = STARTING_STATE
            while True:
                pointed_symbols = [t.get_head() for t in self.tapes]
                rule_index = self.find_rule(pointed_symbols, state)
                print(f"Rule index = {rule_index}")
                if rule_index is False:# or state in self.fin_state:
                    if state in self.fin_state:
                        print("Acceptance configuration")
                    else:
                        print("Rejection configuration")
                    break
                
                state = self.rules.rules_content[rule_index][3]
                symbols_to_write = self.rules.rules_content[rule_index][2]#.split(":")
                #print(symbols_to_write)
                moves_to_make = self.rules.rules_content[rule_index][4]#.split(":")
                #print(moves_to_make)
                
                for t in range(self.number_of_tapes):
                    self.tapes[t].write_head(symbols_to_write[t])
                    self.tapes[t].move(moves_to_make[t])
                    
            return state

	def find_rule(self, pointed_symbols, state):
            rule_index = False
            for index in range(len(self.rules.rules_content)):             
                if self.rules.rules_content[index][1] == state and self.rules.rules_content[index][0] == pointed_symbols[0]:
                    rule_index = index
                    break
            return rule_index



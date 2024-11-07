require_relative '../lib/dining_savages_problem/main'

# Getting the cauldron size from the user
puts "Hello world!\nQuantas porções cabem no caldeirão: "
cauldron_size = gets.to_i

# Getting the number of savages from the user
puts "Digite o número de selvagens: "
num_savages = gets.to_i

# Starting the main program
main = Main.new(cauldron_size, num_savages)
main.start

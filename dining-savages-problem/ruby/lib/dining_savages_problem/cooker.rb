class Cooker
  def initialize(cauldron)
    @cauldron = cauldron
  end

  def cook
    if @cauldron.is_empty?
      puts "\u001B[31mO caldeirão está vazio. O cozinheiro esta reabastecendo...\u001B[0m"
      @cauldron.add_portions(@cauldron.capacity)
      sleep(5)
      puts "\u001B[32mCozinheiro: O caldeirão agora tem #{@cauldron.portions} porções.\u001B[0m"
    end
  end
end

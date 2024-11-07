class Cauldron
  attr_reader :capacity, :portions

  def initialize(capacity)
    @capacity = capacity
    @portions = 0
  end

  def is_empty?
    @portions == 0
  end

  def add_portions(amount)
    @portions = [@portions + amount, @capacity].min
  end

  def take_portion
    @portions -= 1 if @portions > 0
  end
end

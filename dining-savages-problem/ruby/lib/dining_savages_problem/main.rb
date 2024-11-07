require 'thread'
require_relative 'cauldron'
require_relative 'cooker'
require_relative 'savage'

class Main
  def initialize(cauldron_size, num_savages)
    @cauldron = Cauldron.new(cauldron_size)
    @cooker = Cooker.new(@cauldron)
    @mutex = Mutex.new
    @savages = Array.new(num_savages) { |i| Savage.new(i + 1, @cauldron, @cooker, @mutex) }
  end

  def start
    threads = @savages.map do |savage|
      Thread.new { savage.eat while true }
    end
    threads.each(&:join)
  end
end

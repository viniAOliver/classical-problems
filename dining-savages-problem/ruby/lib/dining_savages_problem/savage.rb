require 'thread'

class Savage
  def initialize(id, cauldron, cooker, mutex)
    @id = id
    @cauldron = cauldron
    @cooker = cooker
    @mutex = mutex
  end

  def eat
    @mutex.synchronize do
      if @cauldron.is_empty?
        @cooker.cook
      end

      if @cauldron.portions > 0
        sleep(3)
        @cauldron.take_portion
        puts "\u001B[33mSelvagem #{@id} está comendo uma porção. Restam #{@cauldron.portions} porções.\u001B[33m"
      end
    end
  end
end

using System;

namespace DiningPhilosophers
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("O jantar dos filósofos começou!");

            // Get the number of philosophers from the user
            Console.WriteLine("Quantos filósofos estão na mesa?");

            int numPhilosophers;
            while (!int.TryParse(Console.ReadLine(), out numPhilosophers) || numPhilosophers < 2)
            {
                Console.WriteLine("Por favor, insira um número inteiro maior que 1.");
            }

            var diningTable = new DiningTable(numPhilosophers);
            diningTable.StartDinner();

            Console.ReadLine();
        }
    }
}

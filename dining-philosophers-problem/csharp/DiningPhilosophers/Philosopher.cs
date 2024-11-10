using System;
using System.Threading;

namespace DiningPhilosophers
{
    public class Philosopher
    {
        private readonly int _id;
        private readonly Fork _leftFork;
        private readonly Fork _rightFork;

        public Philosopher(int id, Fork leftFork, Fork rightFork)
        {
            _id = id;
            _leftFork = leftFork;
            _rightFork = rightFork;
        }

        public void Dine()
        {
            while (true)
            {
                Think();
                Eat();
            }
        }

        private void Think()
        {
            Console.WriteLine($"Filósofo {_id} esta pensando...");
            Thread.Sleep(new Random().Next(2000, 4000));
        }

        private void Eat()
        {
            Console.WriteLine($"Filósofo {_id} esta faminto.");
            _leftFork.PickUp();
            _rightFork.PickUp();

            Console.WriteLine($"Filósofo {_id} esta comendo.");
            Thread.Sleep(new Random().Next(2000, 4000));

            _rightFork.PutDown();
            _leftFork.PutDown();
        }
    }
}

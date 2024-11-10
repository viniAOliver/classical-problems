using System.Threading;

namespace DiningPhilosophers
{
    public class DiningTable
    {
        private readonly Philosopher[] _philosophers;
        private readonly Fork[] _forks;

        public DiningTable(int numPhilosophers)
        {
            _forks = new Fork[numPhilosophers];
            _philosophers = new Philosopher[numPhilosophers];

            for (int i = 0; i < numPhilosophers; i++)
            {
                _forks[i] = new Fork();
            }

            for (int i = 0; i < numPhilosophers; i++)
            {
                Fork leftFork = _forks[i];
                Fork rightFork = _forks[(i + 1) % numPhilosophers];
                _philosophers[i] = new Philosopher(i + 1, leftFork, rightFork);
            }
        }

        public void StartDinner()
        {
            foreach (var philosopher in _philosophers)
            {
                new Thread(philosopher.Dine).Start();
            }
        }
    }
}

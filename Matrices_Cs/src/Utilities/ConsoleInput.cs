using System;

namespace Matrices_Cs.Utilities
{
    public static class ConsoleInput
    {
        public static int GetInteger()
        {
            while (true)
            {
                var line = Console.ReadLine();
                if (int.TryParse(line, out int value)) return value;
                Console.Write("Entrada inválida, intente de nuevo: ");
            }
        }
    }
}